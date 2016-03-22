package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;

public interface IVoValidateSV {
	/**
	 * 注册参数检查
	 */
	void validateRegister(PhoneRegisterRequest query) throws BusinessException;
	/**
	 * 登录参数检查
	 */
	void validateLogin(UserLoginRequest query) throws BusinessException;

	/**
	 * 新增租户参数检查
	 */
	void validateInsertTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException;

	/**
	 * 租户详情查询参数检查
	 */
	void validateQueryTenantInfo(BaseInfo tenantRequest) throws BusinessException;

	/**
	 * 账户详情查询参数检查
	 */
	void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException;

	/**
	 * 修改账户信息参数检查
	 */
	void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException;

	/**
	 * 设置账户邮箱数据参数检查
	 */
	void validateSetAccountEmail(AccountEmailRequest emailModifyRequest) throws BusinessException;

	/**
	 * 设置账户密码数据参数检查
	 */
	void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest) throws BusinessException;

	/**
	 * 设置账户电话数据参数检查
	 */
	void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest) throws BusinessException;
}
