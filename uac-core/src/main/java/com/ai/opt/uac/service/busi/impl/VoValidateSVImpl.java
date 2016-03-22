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
        if(!RegexUtils.checkIsPhone(query.getPhone())){
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码格式不正确");
        }
        if (StringUtil.isBlank(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
        }
        if (!RegexUtils.checkPassword(query.getAccountPassword())) {
           throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码格式不正确");
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
		// TODO Auto-generated method stub

	}

	@Override
	public void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateSetAccountTenant(AccountTenantModifyRequest accountModifyRequest) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateSetAccountEmail(AccountEmailRequest emailModifyRequest) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest) throws BusinessException {
		// TODO Auto-generated method stub

	}

}
