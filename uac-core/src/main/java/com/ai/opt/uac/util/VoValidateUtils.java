package com.ai.opt.uac.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.api.register.param.phoneRegisterRequest;
import com.ai.opt.uac.api.sso.param.userLoginRequest;
import com.ai.opt.uac.constants.AccountExceptCode;


public final class VoValidateUtils {

	private VoValidateUtils() {
	}

	public static void validateRegister(phoneRegisterRequest query) throws BusinessException {
		if (query == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		if (StringUtil.isBlank(query.getPhone())) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "手机号码不能为空");
		}
		if (StringUtil.isBlank(query.getPassword())) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
		}
	}

    public static void validateLogin(userLoginRequest query) throws BusinessException {
        if (query == null) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
        }
        if (StringUtil.isBlank(query.getUsername())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "用户名不能为空");
        }
        if (StringUtil.isBlank(query.getPassword())) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
        }
    }   
}
