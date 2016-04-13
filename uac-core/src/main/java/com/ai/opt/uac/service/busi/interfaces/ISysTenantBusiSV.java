package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;

public interface ISysTenantBusiSV {
    PageInfo<GnTenant> queryTenantPageInfo(QueryPageTenantRequest tenantRequest);
    
    GnTenant queryTenantById(String tenantId);
    
    int updateTenantById(GnTenant gnTenant) throws SystemException;

}
