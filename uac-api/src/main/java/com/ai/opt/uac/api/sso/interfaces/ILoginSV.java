package com.ai.opt.uac.api.sso.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface ILoginSV {
   
	/**
     * 根据用户名查询
     * @param username
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL login/queryAccountByUserName
     */
    @GET
    @Path("/queryAccountByUserName")
    UserLoginResponse queryAccountByUserName(String username) throws BusinessException,SystemException;

    /**
     * 校验用户名密码
     * @param request
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL login/checkAccountByUserName
     */
    @GET
    @Path("/checkAccountByUserName")
    boolean checkAccountByUserName(UserLoginRequest request) throws BusinessException,SystemException;

}
