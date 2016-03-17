package com.ai.opt.uac.api.register.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.phoneRegisterRequest;
import com.ai.opt.uac.api.register.param.phoneRegisterResponse;
import com.ai.opt.uac.service.busi.interfaces.IRegisterBusiSV;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class RegisterSVImpl implements IRegisterSV {
    @Autowired
    private IRegisterBusiSV iRegisterBusiSV;
    @Override
    public phoneRegisterResponse registerByPhone(phoneRegisterRequest request)
            throws BusinessException, SystemException {
        VoValidateUtils.validateRegister(request);
        return iRegisterBusiSV.registerByPhone(request);
    }

}
