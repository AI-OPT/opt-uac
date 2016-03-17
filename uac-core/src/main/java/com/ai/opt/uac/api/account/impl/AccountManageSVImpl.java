package com.ai.opt.uac.api.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.account.interfaces.IAccountManageSV;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountQueryResponse;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.IAccountBusiSV;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountManageSVImpl implements IAccountManageSV {

	@Autowired
	IAccountBusiSV iAccountBusiSV;

	@Override
	public AccountQueryResponse queryBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException, SystemException {
		//入参检查
		VoValidateUtils.validateQueryAccountBaseInfo(accountQueryRequest);
		//查询数据
		Long accountId = accountQueryRequest.getAccountId();
		GnAccount gnAccount = iAccountBusiSV.queryByAccountId(accountId);
		//整理返回对象
		AccountQueryResponse accountQueryResponse = new AccountQueryResponse();
		BeanUtils.copyProperties(accountQueryResponse, gnAccount);
		ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, null);
		accountQueryResponse.setResponseHeader(responseHeader);
		return accountQueryResponse;
	}

	@Override
	public BaseResponse updateBaseInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException, SystemException {
		//入参检查
		VoValidateUtils.validateUpdateAccountInfo(accountModifyRequest);
		//数据库操作
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, accountModifyRequest);
		gnAccount.setUpdateTime(DateUtil.getSysDate());
		int updateCount = iAccountBusiSV.updateByAccountId(gnAccount);
		//整理返回对象
		BaseResponse baseResponse = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		if(updateCount > 0){
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
		}else{
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("数据库查询失败");
		}
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}
}
