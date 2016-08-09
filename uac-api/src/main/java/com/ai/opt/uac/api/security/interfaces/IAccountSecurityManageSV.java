package com.ai.opt.uac.api.security.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;

@Path("/accountsecuritymanage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface IAccountSecurityManageSV {
	
	/**
     * 设置邮箱
     * @param emailModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountsecuritymanage/setEmailData
     */
    @GET
    @Path("/setEmailData")
	BaseResponse setEmailData(AccountEmailRequest emailModifyRequest) throws BusinessException,SystemException;
	
    /**
     * 设置密码
     * @param emailModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountsecuritymanage/setPasswordData
     */
    @GET
    @Path("/setPasswordData")
	BaseResponse setPasswordData(AccountPasswordRequest passwordModifyRequest) throws BusinessException,SystemException;
	
    /**
     * 设置手机号
     * @param phoneModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountsecuritymanage/setPhoneData
     */
    @GET
    @Path("/setPhoneData")
	BaseResponse setPhoneData(AccountPhoneRequest phoneModifyRequest) throws BusinessException,SystemException;
}
