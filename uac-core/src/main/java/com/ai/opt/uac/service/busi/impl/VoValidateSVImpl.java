package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.constants.AccountExceptCode;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IAccountValidateSV;
import com.ai.opt.uac.service.busi.interfaces.ITenantValidateSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;

@Component
public class VoValidateSVImpl implements IVoValidateSV {

	@Autowired
	IRegisterAtomSV iRegisterAtomSV;
	@Autowired
	ITenantValidateSV iTenantValidateSV;
	@Autowired
	IAccountValidateSV iAccountValidateSV;

	@Override
	public void validateRegister(PhoneRegisterRequest query) throws BusinessException {
		if (query == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iAccountValidateSV.checkPhone(query.getPhone(), true);
		iAccountValidateSV.checkAccountPassword(query.getAccountPassword());
		iAccountValidateSV.checkPhoneVerifyCode(query.getPhoneVerifyCode());
		iAccountValidateSV.checkPictureVerifyCode(query.getPictureVerifyCode());
	}

	@Override
	public void validateLogin(UserLoginRequest query) throws BusinessException {
		if (query == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iAccountValidateSV.checkUserName(query.getUsername());
		if (StringUtil.isBlank(query.getAccountPassword())) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
		}
	}

	@Override
	public void validateInsertTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException {
		if (tenantInfoRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iTenantValidateSV.checkTenantName(tenantInfoRequest.getTenantName());
		iTenantValidateSV.checkIndustryCode(tenantInfoRequest.getIndustryCode());
		iTenantValidateSV.checkAccountId(tenantInfoRequest.getAccountId());
	}

	@Override
	public void validateQueryTenantInfo(BaseInfo tenantRequest) throws BusinessException {
		if (tenantRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iTenantValidateSV.checkTenantId(tenantRequest.getTenantId());
	}

	@Override
	public void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException {
		if (accountQueryRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iTenantValidateSV.checkAccountId(accountQueryRequest.getAccountId());
	}

	@Override
	public void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException {
		if (accountModifyRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iAccountValidateSV.checkAccountId(accountModifyRequest.getAccountId());
		iAccountValidateSV.checkNickName(accountModifyRequest.getNickName());
		iAccountValidateSV.checkUpdateAccountId(accountModifyRequest.getUpdateAccountId());
	}

	@Override
	public void validateSetAccountEmail(AccountEmailRequest emailModifyRequest) throws BusinessException {
		if (emailModifyRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iAccountValidateSV.checkAccountId(emailModifyRequest.getAccountId());
		iAccountValidateSV.checkEmail(emailModifyRequest.getEmail(), true);
		iAccountValidateSV.checkUpdateAccountId(emailModifyRequest.getUpdateAccountId());
	}

	@Override
	public void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest) throws BusinessException {
		if (passwordModifyRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iAccountValidateSV.checkAccountId(passwordModifyRequest.getAccountId());
		iAccountValidateSV.checkAccountPassword(passwordModifyRequest.getAccountPassword());
		iAccountValidateSV.checkUpdateAccountId(passwordModifyRequest.getUpdateAccountId());
	}

	@Override
	public void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest) throws BusinessException {
		if (phoneModifyRequest == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		iAccountValidateSV.checkAccountId(phoneModifyRequest.getAccountId());
		iAccountValidateSV.checkPhone(phoneModifyRequest.getPhone(), true);
		iAccountValidateSV.checkUpdateAccountId(phoneModifyRequest.getUpdateAccountId());
	}

}
