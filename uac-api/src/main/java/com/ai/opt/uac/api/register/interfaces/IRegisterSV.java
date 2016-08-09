package com.ai.opt.uac.api.register.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;

/**
 * 注册服务<br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
@Path("/register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface IRegisterSV {

	/**
     * 用户注册 Date: 2016年3月25日 <br>
     * @param request
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL register/registerByPhone
     */
    @GET
    @Path("/registerByPhone")
    PhoneRegisterResponse registerByPhone(PhoneRegisterRequest request) throws BusinessException,SystemException;
    @interface RegisterByPhone {}
}
