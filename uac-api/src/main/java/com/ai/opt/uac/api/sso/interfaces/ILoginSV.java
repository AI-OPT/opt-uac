package com.ai.opt.uac.api.sso.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.api.sso.param.UserLoginResponse;

/**
 * 登录服务<br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public interface ILoginSV {
    /**
     * bass用户登录
     * 
     * @param request
     * @return 登陆账号信息
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_0002
     * 
     */
    UserLoginResponse queryAccountByUserName(UserLoginRequest request)
            throws RPCSystemException;

}
