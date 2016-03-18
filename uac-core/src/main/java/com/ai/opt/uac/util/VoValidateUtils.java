package com.ai.opt.uac.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountTenantModifyRequest;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.constants.AccountExceptCode;

public final class VoValidateUtils {

    private VoValidateUtils() {
    }

    public static void validateRegister(PhoneRegisterRequest query) throws BusinessException {
        if (query == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(query.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "手机号码不能为空");
        }
        if (StringUtil.isBlank(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
        }
    }

    public static void validateLogin(UserLoginRequest query) throws BusinessException {
        if (query == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(query.getUsername())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "用户名不能为空");
        }
        if (StringUtil.isBlank(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
        }
    }

    /**
     * 新增租户参数检查
     * 
     * @param tenantInfoRequest
     * @throws BusinessException
     */
    public static void validateInsertTenant(TenantInfoRequest tenantInfoRequest)
            throws BusinessException {
        if (tenantInfoRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(tenantInfoRequest.getTenantName())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "企业名称（tenantName）不能为空");
        }
        if (StringUtil.isBlank(tenantInfoRequest.getIndustryCode())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "企业类型（industryCode）不能为空");
        }
        if (tenantInfoRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (tenantInfoRequest.getUpdateAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "修改人ID（updateAccountId）不能为空");
        }
    }

    /**
     * 租户详情查询参数检查
     * 
     * @param tenantRequest
     * @throws BusinessException
     */
    public static void validateQueryTenantInfo(BaseInfo tenantRequest) throws BusinessException {
        if (tenantRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(tenantRequest.getTenantId())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "租户ID（tenantId）不能为空");
        }
    }

    /**
     * 账户详情查询参数检查
     * 
     * @param accountQueryRequest
     * @throws BusinessException
     */
    public static void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest)
            throws BusinessException {
        if (accountQueryRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (accountQueryRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
    }

    /**
     * 修改账户信息参数检查
     * 
     * @param accountModifyRequest
     * @throws BusinessException
     */
    public static void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest)
            throws BusinessException {
        if (accountModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (accountModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (StringUtil.isBlank(accountModifyRequest.getNickName())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "昵称（nickName）不能为空");
        }
        if (accountModifyRequest.getUpdateAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "修改人ID（updateAccountId）不能为空");
        }
    }

    /**
     * 设置账户租户数据参数检查
     * 
     * @param accountModifyRequest
     * @throws BusinessException
     */
    public static void validateSetAccountTenant(AccountTenantModifyRequest accountModifyRequest)
            throws BusinessException {
        if (accountModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (accountModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (StringUtil.isBlank(accountModifyRequest.getTenantId())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "租户ID（tenantId）不能为空");
        }
    }

    /**
     * 设置账户邮箱数据参数检查
     * 
     * @param accountModifyRequest
     * @throws BusinessException
     */
    public static void validateSetAccountEmail(AccountEmailRequest emailModifyRequest)
            throws BusinessException {
        if (emailModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (emailModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (StringUtil.isBlank(emailModifyRequest.getEmail())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "邮箱（email）不能为空");
        }
    }

    /**
     * 设置账户密码数据参数检查
     * 
     * @param accountModifyRequest
     * @throws BusinessException
     */
    public static void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest)
            throws BusinessException {
        if (passwordModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (passwordModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (StringUtil.isBlank(passwordModifyRequest.getPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "密码（password）不能为空");
        }
    }

    /**
     * 设置账户电话数据参数检查
     * 
     * @param accountModifyRequest
     * @throws BusinessException
     */
    public static void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest)
            throws BusinessException {
        if (phoneModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (phoneModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (StringUtil.isBlank(phoneModifyRequest.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "电话（phone）不能为空");
        }
    }
    
    
        
    

}
