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
import com.ai.opt.uac.api.system.sysaccount.param.AccountDelRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.api.system.systenant.param.UpdateTenantRequest;
import com.ai.opt.uac.constants.AccountExceptCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.ILoginAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IAccountValidateSV;
import com.ai.opt.uac.service.busi.interfaces.ITenantValidateSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.ai.opt.uac.util.RegexUtils;

@Component
public class VoValidateSVImpl implements IVoValidateSV {

    @Autowired
    ITenantValidateSV iTenantValidateSV;

    @Autowired
    IAccountValidateSV iAccountValidateSV;

    @Autowired
    ILoginAtomSV iLoginAtomSV;

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
    public void validateLogin(String username) throws BusinessException {

        iAccountValidateSV.checkUserName(username);
    }

    @Override
    public void validateInsertTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException {
        if (tenantInfoRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
       // iTenantValidateSV.checkAccountId(tenantInfoRequest.getAccountId());
        iTenantValidateSV.checkTenantName(tenantInfoRequest.getTenantName());
        iTenantValidateSV.checkCreateAccountId(tenantInfoRequest.getCreateAccountId());
    }

    @Override
    public void validateQueryTenantInfo(BaseInfo tenantRequest) throws BusinessException {
        if (tenantRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iTenantValidateSV.checkTenantId(tenantRequest.getTenantId());
    }

    @Override
    public void validateQueryAccountBaseInfo(AccountQueryRequest accountQueryRequest)
            throws BusinessException {
        if (accountQueryRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iTenantValidateSV.checkAccountId(accountQueryRequest.getAccountId());
    }

    @Override
    public void validateUpdateAccountInfo(AccountBaseModifyRequest accountModifyRequest)
            throws BusinessException {
        if (accountModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iAccountValidateSV.checkAccountId(accountModifyRequest.getAccountId());
        iAccountValidateSV.checkNickName(accountModifyRequest.getNickName());
        iAccountValidateSV.checkUpdateAccountId(accountModifyRequest.getUpdateAccountId());
    }

    @Override
    public void validateSetAccountEmail(AccountEmailRequest emailModifyRequest)
            throws BusinessException {
        if (emailModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iAccountValidateSV.checkAccountId(emailModifyRequest.getAccountId());
        iAccountValidateSV.checkEmail(emailModifyRequest.getEmail(), true);
        iAccountValidateSV.checkUpdateAccountId(emailModifyRequest.getUpdateAccountId());
    }

    @Override
    public void validateSetAccountPwd(AccountPasswordRequest passwordModifyRequest)
            throws BusinessException {
        if (passwordModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iAccountValidateSV.checkAccountId(passwordModifyRequest.getAccountId());
        iAccountValidateSV.checkAccountPassword(passwordModifyRequest.getAccountPassword());
        iAccountValidateSV.checkUpdateAccountId(passwordModifyRequest.getUpdateAccountId());
    }

    @Override
    public void validateSetPhoneTenant(AccountPhoneRequest phoneModifyRequest)
            throws BusinessException {
        if (phoneModifyRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iAccountValidateSV.checkAccountId(phoneModifyRequest.getAccountId());
        iAccountValidateSV.checkPhone(phoneModifyRequest.getPhone(), true);
        iAccountValidateSV.checkUpdateAccountId(phoneModifyRequest.getUpdateAccountId());
    }

    @Override
    public void validateCheckLogin(UserLoginRequest query) throws BusinessException {
        if (query == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iAccountValidateSV.checkUserName(query.getUsername());
        if (StringUtil.isBlank(query.getAccountPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
        }
        // 判断用户名是手机还是邮箱
        boolean isEmial = RegexUtils.checkIsEmail(query.getUsername());
        boolean isPhone = RegexUtils.checkIsPhone(query.getUsername());
        GnAccount account = new GnAccount();
        if (isPhone == true) {
            account.setPhone(query.getUsername());
        }else if (isEmial == true) {
            account.setEmail(query.getUsername());
        }else{
            account.setAccountName(query.getUsername()); 
        }
        account.setAccountPassword(query.getAccountPassword());
        GnAccount accounts = iLoginAtomSV.queryByUserName(account);
        if (accounts == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "用户名错误");
        } else {
            boolean flag = iLoginAtomSV.checkByUserName(account);
            if (!flag) {
                throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "密码错误");
            }
        }

    }

    @Override
    public void validateQueyIndustry(String code)throws BusinessException {
        if (StringUtil.isBlank(code)) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
    }

    @Override
    public void validateQueyTenantPage(QueryPageTenantRequest request) throws BusinessException {
        if (request==null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (request.getPageSize()==null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "分页信息为空");
        }
        if (request.getPageNo()==null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "分页信息为空");
        }
    }

    @Override
    public void validateQueyTenantDetail(BaseInfo baseInfo) throws BusinessException {
        if (baseInfo == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象不能为空");
        }
        iTenantValidateSV.checkTenantId(baseInfo.getTenantId());
    }

    @Override
    public void validateUpdateTenant(UpdateTenantRequest request) throws BusinessException {
        if (request==null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iTenantValidateSV.checkTenantId(request.getTenantId());
        iTenantValidateSV.checkUpdateAccountId(request.getUpdateAccountId());
    }
    
	@Override
	public void validateSysQueryAccountPageInfo(AccountPageQueryRequest queryRequest) throws BusinessException {
		if (queryRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
		Integer pageNo = queryRequest.getPageNo();
		if(pageNo == null){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "页码（pageNo）不能为空");
		}
		Integer pageSize = queryRequest.getPageSize();
		if(pageSize == null){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "单页大小（pageSize）不能为空");
		}
	}

	@Override
	public void validateSysQueryAccountInfo(AccountInfoQueryRequest queryRequest) throws BusinessException {
		if (queryRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
		iAccountValidateSV.checkAccountId(queryRequest.getAccountId());
	}

	@Override
	public void validateSysInsertAccountInfo(AccountInsertRequest insertRequest) throws BusinessException {
		if (insertRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
		String accountLevel = insertRequest.getAccountLevel();
		String accountType = insertRequest.getAccountType();
		String email = insertRequest.getEmail();
		String phone = insertRequest.getPhone();
		String tenantId = insertRequest.getTenantId();
		Long createAccountId = insertRequest.getCreateAccountId();
		iAccountValidateSV.checkTenantId(tenantId);
		iAccountValidateSV.checkPhone(phone, true);
		if(!StringUtil.isBlank(email)){
			iAccountValidateSV.checkEmail(email, true);
		}
		iAccountValidateSV.checkAccountLevel(accountLevel);
		iAccountValidateSV.checkAccountType(accountType);
		iAccountValidateSV.checkCreateAccountId(createAccountId);
	}

	@Override
	public void validateSysUpdateAccountInfo(AccountUpdateRequest updateRequest) throws BusinessException {
		if (updateRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
		iAccountValidateSV.checkAccountId(updateRequest.getAccountId());
		iAccountValidateSV.checkUpdateAccountId(updateRequest.getUpdateAccountId());
	}

	@Override
	public void validateSysDeletAccountInfo(AccountDelRequest deleteRequest) throws BusinessException {
		if (deleteRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
		iAccountValidateSV.checkAccountId(deleteRequest.getAccountId());
		iAccountValidateSV.checkUpdateAccountId(deleteRequest.getUpdateAccountId());
	}

    @Override
    public void validateAccountPhone(AccountQueryRequest request) throws BusinessException {
        if (request == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(request.getPhone())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "手机号码不能为空");
        }
    }

    @Override
    public void validateAccountEmail(AccountQueryRequest request) throws BusinessException {
        if (request == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(request.getEmail())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "邮箱不能为空");
        }
    }

    @Override
    public void validateUpdateTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException {
        if (tenantInfoRequest == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        iTenantValidateSV.checkTenantId(tenantInfoRequest.getTenantId());
        //iTenantValidateSV.checkTenantName(tenantInfoRequest.getTenantName());
        //iTenantValidateSV.checkIndustryCode(tenantInfoRequest.getIndustryCode());
        iTenantValidateSV.checkUpdateAccountId(tenantInfoRequest.getUpdateAccountId());
    }  
}
