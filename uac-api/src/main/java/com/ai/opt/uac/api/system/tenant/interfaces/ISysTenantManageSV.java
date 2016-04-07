package com.ai.opt.uac.api.system.tenant.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.tenant.param.QueryTenantRequest;
import com.ai.opt.uac.api.system.tenant.param.QueryTenantResponse;

/**
 * 系统管理-租户服务 
 * Date: 2016年4月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public interface ISysTenantManageSV {

    /**
     * 分页查询租户信息
     * 
     * @param tenantRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_SYS_0001
     */
    PageInfo<QueryTenantResponse> queryTenantInfo(QueryTenantRequest tenantRequest)
            throws BusinessException, SystemException;

    /**
     * 查询详细信息
     * 
     * @param tenantId
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_SYS_0002
     */
    QueryTenantResponse queryTenantById(String tenantId) throws BusinessException, SystemException;

    /**
     * 修改租户
     * 
     * @param tenantRequest
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiCode UAC_SYS_0003
     */
    BaseResponse updateTenantByTenant(QueryTenantRequest tenantRequest)
            throws BusinessException, SystemException;
}
