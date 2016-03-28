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
     * 根据用户名查询
     * 
     * @param username
     * @return
     * @throws RPCSystemException
     * @author zhanglh
     * @ApiCode UAC_0002
     */
    UserLoginResponse queryAccountByUserName(String username) throws BusinessException,SystemException;

    /**
     * 校验用户名密码
     * 
     * @param request
     * @return
     * @throws RPCSystemException
     * @author zhanglh
     * @ApiCode UAC_0010
     */
    boolean checkAccountByUserName(UserLoginRequest request) throws BusinessException,SystemException;

}
