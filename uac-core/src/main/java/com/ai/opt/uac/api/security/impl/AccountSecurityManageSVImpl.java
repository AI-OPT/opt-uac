package com.ai.opt.uac.api.security.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.security.interfaces.IAccountSecurityManageSV;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountSecurityManageSVImpl implements IAccountSecurityManageSV {

	@Override
	public BaseResponse setEmailData(AccountEmailRequest emailModifyRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse setPasswordData(
			AccountPasswordRequest passwordModifyRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse setPhoneData(AccountPhoneRequest phoneModifyRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
