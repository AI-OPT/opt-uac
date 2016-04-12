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
import com.ai.opt.uac.api.system.tenant.param.QueryTenantRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountDelRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;

public interface IVoValidateSV {
    /**
     * 注册参数检查
     */
    void validateRegister(PhoneRegisterRequest query) throws BusinessException;

    /**
     * 登录参数检查
     */
    void validateLogin(String username) throws BusinessException;

    /**
     * 登录校验参数检查
     */
    void validateCheckLogin(UserLoginRequest query) throws BusinessException;

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
    void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest)
            throws BusinessException;

    /**
     * 修改账户信息参数检查
     */
    void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest)
            throws BusinessException;

    /**
     * 设置账户邮箱数据参数检查
     */
    void validateSetAccountEmail(AccountEmailRequest emailModifyRequest) throws BusinessException;

    /**
     * 设置账户密码数据参数检查
     */
    void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest)
            throws BusinessException;

    /**
     * 设置账户电话数据参数检查
     */
    void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest) throws BusinessException;

    /**
     * 查询企业类型参数检查
     */
    void validateQueyIndustry(String code) throws BusinessException;

    /**
     * 系统管理的分页查询租户参数检查
     */
    void validateQueyTenantPage(QueryTenantRequest request) throws BusinessException;

    /**
     * 系统管理查询租户详情参数检查
     */
    void validateQueyTenantDetail(String tenantId) throws BusinessException;

    /**
     * 系统管理修改租户参数检查
     */
    void validateUpdateTenant(QueryTenantRequest request) throws BusinessException;
    
	/**
	 * 系统管理-账户分页查询检查
	 */
	void validateSysQueryAccountPageInfo(AccountPageQueryRequest queryRequest) throws BusinessException;
	
	/**
	 * 系统管理-账户详情查询检查
	 */
	void validateSysQueryAccountInfo(AccountInfoQueryRequest queryRequest) throws BusinessException;
	
	/**
	 * 系统管理-账户新增检查
	 */
	void validateSysInsertAccountInfo(AccountInsertRequest insertRequest) throws BusinessException;
	
	/**
	 * 系统管理-账户修改检查
	 */
	void validateSysUpdateAccountInfo(AccountUpdateRequest updateRequest) throws BusinessException;
	
	/**
	 * 系统管理-账户删除检查
	 */
	void validateSysDeletAccountInfo(AccountDelRequest deleteRequest) throws BusinessException;
}
