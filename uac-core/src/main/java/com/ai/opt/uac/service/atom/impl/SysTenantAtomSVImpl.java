package com.ai.opt.uac.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.tenant.param.QueryTenantRequest;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.dao.mapper.bo.GnTenantCriteria;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnTenantMapper;
import com.ai.opt.uac.service.atom.interfaces.ISysTenantAtomSV;
import com.ai.paas.ipaas.util.StringUtil;
@Component
public class SysTenantAtomSVImpl implements ISysTenantAtomSV {

    @Override
    public PageInfo<GnTenant> queryTenantInfo(QueryTenantRequest tenantRequest) {
        GnTenantCriteria sql = new GnTenantCriteria();
        GnTenantCriteria.Criteria criteria = sql.createCriteria();
        if (!StringUtil.isBlank(tenantRequest.getTenantId())) {
            criteria.andTenantIdEqualTo(tenantRequest.getTenantId());
        }
        if (!StringUtil.isBlank(tenantRequest.getTenantName())) {
            criteria.andTenantNameLike("%"+tenantRequest.getTenantName()+"%");
        }
        if (!StringUtil.isBlank(tenantRequest.getState())) {
            criteria.andStateEqualTo(tenantRequest.getState());
        }
        
        PageInfo<GnTenant> pageInfo = new PageInfo<GnTenant>();
        GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
        pageInfo.setCount(tenantMapper.countByExample(sql));
        sql.setLimitStart(tenantRequest.getPageInfo().getStartRowIndex()-1);
        sql.setLimitEnd(tenantRequest.getPageInfo().getPageSize());
        pageInfo.setResult(tenantMapper.selectByExample(sql));
        pageInfo.setPageNo(tenantRequest.getPageInfo().getPageNo());
        pageInfo.setPageSize(tenantRequest.getPageInfo().getPageSize());
        return pageInfo;

    }

    @Override
    public GnTenant queryTenantById(String tenantId) {
        GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
        return tenantMapper.selectByPrimaryKey(tenantId);
    }

    @Override
    public int updateTenantById(GnTenant gnTenant) throws SystemException {
        GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
        return tenantMapper.updateByPrimaryKeySelective(gnTenant);
    }

}
