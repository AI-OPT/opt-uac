package com.ai.opt.uac.api.system.systenant.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.UpdateTenantRequest;

/**
 * 系统管理-租户服务 Date: 2016年4月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
@Path("/systenantmanage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface ISysTenantManageSV {

	/**
     * 分页查询租户信息
     * @param tenantRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL systenantmanage/queryTenantPageInfo
     */
    @GET
    @Path("/queryTenantPageInfo")
	QueryPageTenantResponse queryTenantPageInfo(QueryPageTenantRequest tenantRequest) throws BusinessException, SystemException;

    /**
     * 查询详细信息
     * @param baseInfo
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL systenantmanage/queryTenantById
     */
    @GET
    @Path("/queryTenantById")
	QueryTenantResponse queryTenantById(BaseInfo baseInfo) throws BusinessException, SystemException;

    /**
     * 修改租户
     * @param tenantRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL systenantmanage/updateByTenantId
     */
    @GET
    @Path("/updateByTenantId")
	BaseResponse updateByTenantId(UpdateTenantRequest tenantRequest) throws BusinessException, SystemException;
}
