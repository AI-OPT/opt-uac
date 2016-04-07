package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.tenant.param.QueryTenantRequest;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.service.atom.interfaces.ISysTenantAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ISysTenantBusiSV;

@Service
@Transactional
public class SysTenantBusiSVImpl implements ISysTenantBusiSV {
    @Autowired
    ISysTenantAtomSV itenantAtomSV;

    @Override
    public PageInfo<GnTenant> queryTenantInfo(QueryTenantRequest tenantRequest) {

        return itenantAtomSV.queryTenantInfo(tenantRequest);
    }

    @Override
    public GnTenant queryTenantById(String tenantId) {
        return itenantAtomSV.queryTenantById(tenantId);
    }

    @Override
    public int updateTenantById(GnTenant gnTenant) throws SystemException {
        return itenantAtomSV.updateTenantById(gnTenant);
    }

}
