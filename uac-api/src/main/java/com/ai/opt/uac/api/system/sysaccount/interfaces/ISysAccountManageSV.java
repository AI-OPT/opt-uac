package com.ai.opt.uac.api.system.sysaccount.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountDelRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;

@Path("/sysaccountmanage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface ISysAccountManageSV {
	/**
     * 账户分页查询
     * @param queryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysaccountmanage/queryAccountPageInfo
     */
    @GET
    @Path("/queryAccountPageInfo")
	AccountPageQueryResponse queryAccountPageInfo(AccountPageQueryRequest queryRequest);
	
    /**
     * 账户详情查询
     * @param queryRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysaccountmanage/queryAccountInfo
     */
    @GET
    @Path("/queryAccountInfo")
	AccountInfoQueryResponse queryAccountInfo(AccountInfoQueryRequest queryRequest);
	
    /**
     * 增加账户信息
     * @param insertRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysaccountmanage/insertAccountInfo
     */
    @GET
    @Path("/insertAccountInfo")
	AccountInsertResponse insertAccountInfo(AccountInsertRequest insertRequest);
	
    /**
     * 修改账户信息
     * @param updateRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysaccountmanage/updateAccountInfo
     */
    @GET
    @Path("/updateAccountInfo")
	BaseResponse updateAccountInfo(AccountUpdateRequest updateRequest);
	
    /**
     * 删除账户信息
     * @param deleteRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sysaccountmanage/deletAccountInfo
     */
    @GET
    @Path("/deletAccountInfo")
	BaseResponse deletAccountInfo(AccountDelRequest deleteRequest);
}
