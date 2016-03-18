package com.ai.opt.uac.api.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.uac.api.sso.interfaces.ILoginSV;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.api.sso.param.UserLoginResponse;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.ILoginBusiSV;
import com.ai.opt.uac.util.RegexUtils;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class LoginSVImpl implements ILoginSV {
    @Autowired
    private ILoginBusiSV iLoginBusiSV;

    @Override
    public UserLoginResponse queryAccountByUserName(UserLoginRequest request)
            throws BusinessException, SystemException {
        VoValidateUtils.validateLogin(request);
        // 判断用户名是手机还是邮箱
        boolean isEmial = RegexUtils.checkIsEmail(request.getUsername());
        boolean isPhone = RegexUtils.checkIsPhone(request.getUsername());
        GnAccount account = new GnAccount();
        if (isEmial == true) {
            account.setEmail(request.getUsername());
        }
        if (isPhone == true) {
            account.setPhone(request.getUsername());
        }
        //account.setPassword(request.getPassword());

        GnAccount accountResult = iLoginBusiSV.queryByUserName(account);
        // 组织返回对象
        UserLoginResponse response = new UserLoginResponse();
        if (accountResult != null) {
            BeanUtils.copyProperties(response, accountResult);
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "成功");
            response.setResponseHeader(responseHeaders);
        } else {
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.FAIL_CODE,
                    "用户名或密码错误");
            response.setResponseHeader(responseHeaders);
        }

        return response;
    }

}
