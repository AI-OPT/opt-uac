package com.ai.opt.uac.api.account.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.interfaces.IAccountManageSV;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountQueryResponse;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountManageSVImpl implements IAccountManageSV {

	@Override
	public AccountQueryResponse queryBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException, SystemException {
		VoValidateUtils.validateQueryAccountBaseInfo(accountQueryRequest);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse updateBaseInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException, SystemException {
		VoValidateUtils.validateUpdateAccountInfo(accountModifyRequest);
		// TODO Auto-generated method stub
		return null;
	}
}
