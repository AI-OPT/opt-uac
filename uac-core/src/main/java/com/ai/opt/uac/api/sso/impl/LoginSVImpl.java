package com.ai.opt.uac.api.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.uac.api.sso.interfaces.ILoginSV;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.api.sso.param.UserLoginResponse;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.ILoginBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.ai.opt.uac.util.RegexUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class LoginSVImpl implements ILoginSV {
    @Autowired
    private ILoginBusiSV iLoginBusiSV;
    @Autowired
	IVoValidateSV iVoValidateSV;

    @Override
    public UserLoginResponse queryAccountByUserName(String username)
            throws RPCSystemException {
        iVoValidateSV.validateLogin(username);
        // 判断用户名是手机还是邮箱
        boolean isEmial = RegexUtils.checkIsEmail(username);
        boolean isPhone = RegexUtils.checkIsPhone(username);
        GnAccount account = new GnAccount();
        if (isPhone == true) {
            account.setPhone(username);
        }else if (isEmial == true) {
            account.setEmail(username);
        }else{
            account.setAccountName(username); 
        }
        GnAccount accountResult = iLoginBusiSV.queryByUserName(account);
        // 组织返回对象
        UserLoginResponse response = new UserLoginResponse();
        if (accountResult != null) {
            BeanUtils.copyProperties(response, accountResult);
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "成功");
            response.setResponseHeader(responseHeaders);
        } else {
            ResponseHeader responseHeaders = new ResponseHeader(false, ResultCode.FAIL_CODE,
                    "用户不存在");
            response.setResponseHeader(responseHeaders);
        }
        return response;
    }

    @Override
    public boolean checkAccountByUserName(UserLoginRequest request) throws RPCSystemException {
        iVoValidateSV.validateCheckLogin(request);
        // 判断用户名是手机还是邮箱
        boolean isEmial = RegexUtils.checkIsEmail(request.getUsername());
        boolean isPhone = RegexUtils.checkIsPhone(request.getUsername());
        GnAccount account = new GnAccount();
        if (isPhone == true) {
            account.setPhone(request.getUsername());
        }else if (isEmial == true) {
            account.setEmail(request.getUsername());
        }else{
            account.setAccountName(request.getUsername()); 
        }
        return iLoginBusiSV.checkByUserName(account);
    }

}
