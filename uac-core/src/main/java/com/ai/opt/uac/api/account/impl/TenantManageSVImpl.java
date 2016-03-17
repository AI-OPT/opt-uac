package com.ai.opt.uac.api.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.UUIDUtil;
import com.ai.opt.uac.api.account.interfaces.ITenantManageSV;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantInsertResponse;
import com.ai.opt.uac.api.account.param.TenantQueryResponse;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.constants.AccountConstants.Tenant;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.service.busi.interfaces.ITenantBusiSV;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class TenantManageSVImpl implements ITenantManageSV {

	@Autowired
	ITenantBusiSV itenantBusiSV;

	@Override
	public TenantQueryResponse queryTenantInfo(BaseInfo tenantRequest) throws BusinessException, SystemException {
		// 检查参数
		VoValidateUtils.validateQueryTenantInfo(tenantRequest);
		// 查询数据
		String tenantId = tenantRequest.getTenantId();
		GnTenant gnTenant = itenantBusiSV.queryTenantById(tenantId);
		// 整理返回对象
		TenantQueryResponse tenantQueryResponse = new TenantQueryResponse();
		BeanUtils.copyProperties(tenantQueryResponse, gnTenant);
		ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "成功");
		tenantQueryResponse.setResponseHeader(responseHeader);
		return tenantQueryResponse;
	}

	@Override
	public TenantInsertResponse insertTenantInfo(TenantInfoRequest tenantInfoRequest) throws BusinessException, SystemException {
		// 参数检查
		VoValidateUtils.validateInsertTenant(tenantInfoRequest);
		// 设置入参值 默认值
		GnTenant gnTenant = new GnTenant();
		BeanUtils.copyProperties(gnTenant, tenantInfoRequest);
		String tenantId = UUIDUtil.genId32();
		gnTenant.setTenantId(tenantId);
		gnTenant.setState(Tenant.STATE_NOTSIGNED);
		gnTenant.setCreateAccountId(tenantInfoRequest.getAccountId());
		gnTenant.setCreateTime(DateUtil.getSysDate());
		GnAccount gnAccount = new GnAccount();
		gnAccount.setTenantId(tenantId);
		gnAccount.setUpdateAccountrId(tenantInfoRequest.getAccountId());
		// 设置返回对象
		boolean isSuccess = itenantBusiSV.insertTenantAndSyncAccount(gnTenant, gnAccount);
		ResponseHeader responseHeader = new ResponseHeader();
		TenantInsertResponse tenantResponse = new TenantInsertResponse();
		if (isSuccess) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			tenantResponse.setTenantId(tenantId);
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("数据库操作失败");
			tenantResponse.setTenantId(null);
		}
		tenantResponse.setResponseHeader(responseHeader);
		return tenantResponse;
	}

}
