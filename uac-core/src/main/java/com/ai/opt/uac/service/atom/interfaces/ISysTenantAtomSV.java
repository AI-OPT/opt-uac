package com.ai.opt.uac.service.atom.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantRequest;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;

public interface ISysTenantAtomSV {
    PageInfo<GnTenant> queryTenantInfo(QueryTenantRequest tenantRequest);

    GnTenant queryTenantById(String tenantId);

    int updateTenantById(GnTenant gnTenant) throws SystemException;

}
