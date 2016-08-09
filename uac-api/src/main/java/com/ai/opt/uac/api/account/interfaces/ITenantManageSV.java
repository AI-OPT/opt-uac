package com.ai.opt.uac.api.account.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantInsertResponse;
import com.ai.opt.uac.api.account.param.TenantQueryResponse;

@Path("/tenantmanage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface ITenantManageSV {
	
	/**
     * 查询租户信息
     * @param tenantReaponse
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL tenantmanage/queryTenantInfo
     */
    @GET
    @Path("/queryTenantInfo")
	TenantQueryResponse queryTenantInfo(BaseInfo tenantRequest) throws BusinessException,SystemException;
	
    /**
     * 设置租户信息(新增)
     * @param tenantInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL tenantmanage/insertTenantInfo
     */
    @GET
    @Path("/insertTenantInfo")
	TenantInsertResponse insertTenantInfo(TenantInfoRequest tenantInfoRequest) throws BusinessException,SystemException;
    /**
     * 修改租户信息
     * @param tenantInfoRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL tenantmanage/updateTenant
     */
    @GET
    @Path("/updateTenant")
    BaseResponse updateTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException,SystemException;
    
}
