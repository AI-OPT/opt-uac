package com.ai.opt.uac.api.account.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountQueryResponse;

@Path("/accountmanage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface IAccountManageSV {
	
	/**
     * 查询账户信息
     * @param accountQueryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountmanage/queryBaseInfo
     */
    @GET
    @Path("/queryBaseInfo")
	AccountQueryResponse queryBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException,SystemException;
	
    /**
     * 修改账户中心基础信息
     * @param AccountBaseModifyRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountmanage/updateBaseInfo
     */
    @GET
    @Path("/updateBaseInfo")
	BaseResponse updateBaseInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException,SystemException;
    /**
     * 根据手机号码进行查询（不加状态）
     * @param request
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountmanage/queryByPhone
     */
    @GET
    @Path("/queryByPhone")
	AccountQueryResponse queryByPhone(AccountQueryRequest request) throws BusinessException,SystemException;
    /**
     * 根据email进行查询（不加状态）
     * @param request
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL accountmanage/queryByEmail
     */
    @GET
    @Path("/queryByEmail")
	AccountQueryResponse queryByEmail(AccountQueryRequest request) throws BusinessException,SystemException;
	
	
}
