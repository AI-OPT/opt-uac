package com.ai.opt.uac.util;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.api.register.param.phoneRegisterRequest;
import com.ai.opt.uac.constants.AccountExceptCode;


public final class VoValidateUtils {

	private VoValidateUtils() {
	}

	public static void validateRegister(phoneRegisterRequest query) throws BusinessException {
		if (query == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		if (StringUtil.isBlank(query.getPhone())) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "租户ID不能为空");
		}
		if (StringUtil.isBlank(query.getPassword())) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "渠道ID不能为空");
		}
	}	
}
