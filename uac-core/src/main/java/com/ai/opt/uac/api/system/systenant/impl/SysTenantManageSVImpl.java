package com.ai.opt.uac.api.system.systenant.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.system.systenant.interfaces.ISysTenantManageSV;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantData;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.UpdateTenantRequest;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.service.busi.interfaces.ISysTenantBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
@Component
public class SysTenantManageSVImpl implements ISysTenantManageSV {
	@Autowired
	ISysTenantBusiSV itenantBusiSV;
	@Autowired
	IVoValidateSV iVoValidateSV;

	@Override
	public QueryPageTenantResponse queryTenantPageInfo(QueryPageTenantRequest tenantRequest) throws BusinessException, SystemException {
		iVoValidateSV.validateQueyTenantPage(tenantRequest);
		PageInfo<GnTenant> pageVo = itenantBusiSV.queryTenantPageInfo(tenantRequest);
		PageInfo<QueryPageTenantData> pageInfo = new PageInfo<QueryPageTenantData>();
		pageInfo.setCount(pageVo.getCount());
		pageInfo.setPageNo(pageVo.getPageNo());
		pageInfo.setPageSize(pageVo.getPageSize());
		List<GnTenant> tenantList = pageVo.getResult();
		if (!CollectionUtil.isEmpty(tenantList)) {
			Gson gson = new Gson();
			List<QueryPageTenantData> tenants = gson.fromJson(gson.toJson(tenantList), new TypeToken<List<QueryPageTenantData>>() {
			}.getType());
			pageInfo.setResult(tenants);
		}
		QueryPageTenantResponse pageTenantResponse = new QueryPageTenantResponse();
		pageTenantResponse.setPageInfo(pageInfo);
		ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "查询成功");
		pageTenantResponse.setResponseHeader(responseHeader);
		return pageTenantResponse;
	}

	@Override
	public BaseResponse updateByTenantId(UpdateTenantRequest tenantRequest) throws BusinessException, SystemException {
		iVoValidateSV.validateUpdateTenant(tenantRequest);
		// 数据库操作
		GnTenant gnTenant = new GnTenant();
		BeanUtils.copyProperties(gnTenant, tenantRequest);
		gnTenant.setUpdateTime(DateUtil.getSysDate());
		int updateCount = itenantBusiSV.updateTenantById(gnTenant);
		// 整理返回对象
		ResponseHeader responseHeader = new ResponseHeader();
		if (updateCount > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			responseHeader.setResultMessage("数据更新成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("数据库更新失败");
		}
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

	@Override
	public QueryTenantResponse queryTenantById(BaseInfo baseInfo) throws BusinessException, SystemException {
		iVoValidateSV.validateQueyTenantDetail(baseInfo);
		GnTenant gnTenant = itenantBusiSV.queryTenantById(baseInfo.getTenantId());
		// 整理返回对象
		QueryTenantResponse tenantQueryResponse = new QueryTenantResponse();
		if (gnTenant != null) {
			BeanUtils.copyProperties(tenantQueryResponse, gnTenant);
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "查询成功");
			tenantQueryResponse.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.FAIL_CODE, "查询失败，无数据");
			tenantQueryResponse.setResponseHeader(responseHeader);
		}
		return tenantQueryResponse;
	}

}
