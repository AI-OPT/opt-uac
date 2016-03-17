package com.ai.opt.uac.api.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.uac.api.sso.interfaces.ILoginSV;
import com.ai.opt.uac.api.sso.param.userLoginRequest;
import com.ai.opt.uac.api.sso.param.userLoginResponse;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.ILoginBusiSV;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class LoginSVImpl implements ILoginSV {
    @Autowired
    private ILoginBusiSV iLoginBusiSV;

    @Override
    public userLoginResponse queryAccountByUserName(userLoginRequest request)
            throws BusinessException, SystemException {
        VoValidateUtils.validateLogin(request);

        // 判断用户名是手机还是邮箱
        GnAccount account = new GnAccount();
        BeanUtils.copyProperties(account, request);
        account.setPhone(request.getUsername());
        GnAccount phoneResult = iLoginBusiSV.queryByUserName(account);
        userLoginResponse response = new userLoginResponse();
        if (phoneResult == null) {
            GnAccount emailAccount = new GnAccount();
            BeanUtils.copyProperties(emailAccount, request);
            emailAccount.setEmail(request.getUsername());
            GnAccount emailResult = iLoginBusiSV.queryByUserName(emailAccount);
            BeanUtils.copyProperties(emailResult, response);
            return response;
        } else {
            BeanUtils.copyProperties(phoneResult, response);
            return response;
        }
    }

}
