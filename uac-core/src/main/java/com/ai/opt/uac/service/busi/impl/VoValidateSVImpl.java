package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import com.ai.opt.uac.constants.AccountConstants.Account;
import com.ai.opt.uac.constants.AccountConstants.Tenant;
import com.ai.opt.uac.dao.mapper.bo.GnIndustry;
import com.ai.opt.uac.service.busi.interfaces.IIndustryBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.ai.opt.uac.util.RegexUtils;

@Component
public class VoValidateSVImpl implements IVoValidateSV {
	
	@Autowired
	IIndustryBusiSV industryBusiSV;

	@Override
	public void validateRegister(PhoneRegisterRequest query) throws BusinessException {
		if (query == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(query.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "手机号码不能为空");
        }
        if (!RegexUtils.checkNumberPhone((query.getPhone()))) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码格式不正确");
        }
        if (!RegexUtils.checkPhoneLength(query.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码长度不正确");
        }
        if (!RegexUtils.checkIsPhone(query.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码格式不正确");
        }

        if (StringUtil.isBlank(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
        }
        if (!RegexUtils.checkPassword(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码格式不正确");
        }
        if (!RegexUtils.checkPasswordLength(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码长度不正确");
        }
	}

	@Override
	public void validateLogin(UserLoginRequest query) throws BusinessException {
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

	@Override
	public void validateInsertTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException {
		//判空
        if (tenantInfoRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        String tenantName = tenantInfoRequest.getTenantName();
		if (StringUtil.isBlank(tenantName)) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "企业名称（tenantName）不能为空");
        }
        String industryCode = tenantInfoRequest.getIndustryCode();
		if (StringUtil.isBlank(industryCode)) {
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
        //参数是否符合规则
        if(RegexUtils.checkHasSpecialChar(tenantName)){
        	throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "企业名称（tenantName）不能含有特殊字符");
        }
		if(tenantName.contains("\u0020")){
			 throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
	                    "企业名称（tenantName）不能包含空格");
        }
		int tenantNameSize = tenantName.length();
		if(tenantNameSize <Tenant.TENANTNAME_MINSIZE || tenantNameSize>Tenant.TENANTNAME_MAXSIZE){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "企业名称（tenantName）长度为"+Tenant.TENANTNAME_MINSIZE+"~"+Tenant.TENANTNAME_MAXSIZE+"位字符");
		}
		if(industryCode.length()>Tenant.INDUSTRYCODE_MAXSIZE){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "企业类型（industryCode）长度不能大于"+Tenant.INDUSTRYCODE_MAXSIZE);
		}
		GnIndustry gnIndustry = industryBusiSV.queryByIndustryCode(industryCode);
		if(gnIndustry == null || StringUtil.isBlank(gnIndustry.getIndustryName())){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "企业类型（industryCode）未配置"+Tenant.INDUSTRYCODE_MAXSIZE);
		}
	}

	@Override
	public void validateQueryTenantInfo(BaseInfo tenantRequest) throws BusinessException {
		//判空
    	if (tenantRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        String tenantId = tenantRequest.getTenantId();
		if (StringUtil.isBlank(tenantId)) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "租户ID（tenantId）不能为空");
        }
        //参数规则检查
        if(tenantId.length() > Tenant.TENANTID_MAXSIZE){
        	 throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                     "租户ID（tenantId）长度不能超过" + Tenant.TENANTID_MAXSIZE);
        }
	}

	@Override
	public void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException {
		if (accountQueryRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        Long accountId = accountQueryRequest.getAccountId();
        if (accountId == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
	}

	@Override
	public void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException {
		// 判空
        if (accountModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (accountModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        String nickName = accountModifyRequest.getNickName();
        if (StringUtil.isBlank(nickName)) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "昵称（nickName）不能为空");
        }
        if (accountModifyRequest.getUpdateAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "修改人ID（updateAccountId）不能为空");
        }
        //判断参数是否符合规则
        int nameSize = nickName.length();
        if(nickName.contains("\u0020")){
        	throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "昵称（nickName）不能包含空格");
        }
		if(nameSize<Account.NICKNAME_MINSIZE||nameSize > Account.NICKNAME_MAXSIZE){
        	throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "昵称（nickName）长度在"+ Account.NICKNAME_MAXSIZE+"~"+ Account.NICKNAME_MAXSIZE+"个字符，不能包含空格");
        }
	}

	@Override
	public void validateSetAccountTenant(AccountTenantModifyRequest accountModifyRequest) throws BusinessException {
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

	@Override
	public void validateSetAccountEmail(AccountEmailRequest emailModifyRequest) throws BusinessException {
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
        if (!RegexUtils.checkIsEmail(emailModifyRequest.getEmail())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "邮箱（email）格式错误");
        }
        if (emailModifyRequest.getUpdateAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "修改人账号ID（accountId）不能为空");
        }
	}

	@Override
	public void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest) throws BusinessException {
		if (passwordModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (passwordModifyRequest.getAccountId() == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "账号ID（accountId）不能为空");
        }
        if (StringUtil.isBlank(passwordModifyRequest.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "密码（accountPassword）不能为空");
        }
	}

	@Override
	public void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest) throws BusinessException {
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
        if (!RegexUtils.checkNumberPhone(phoneModifyRequest.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "电话（phone）格式错误");
        }
        if (!RegexUtils.checkPhoneLength(phoneModifyRequest.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "电话（phone）长度错误");
        }
        if (!RegexUtils.checkIsPhone(phoneModifyRequest.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "电话（phone）格式错误");
        }
	}

}
