package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.register.param.phoneRegisterRequest;
import com.ai.opt.uac.api.register.param.phoneRegisterResponse;

public interface IRegisterBusiSV {
    phoneRegisterResponse  registerByPhone(phoneRegisterRequest registerVo) throws SystemException;
}
