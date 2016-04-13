package com.ai.opt.uac.service.busi.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.dao.mapper.bo.GnTenantCriteria;
import com.ai.opt.uac.service.atom.interfaces.ITenantAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ISysTenantBusiSV;
import com.ai.paas.ipaas.util.StringUtil;

@Service
@Transactional
public class SysTenantBusiSVImpl implements ISysTenantBusiSV {
    @Autowired
    ITenantAtomSV itenantAtomSV;

    @Override
    public PageInfo<GnTenant> queryTenantPageInfo(QueryPageTenantRequest tenantRequest) {
    	Integer pageNo = tenantRequest.getPageNo();
    	Integer pageSize = tenantRequest.getPageSize();
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
        int count = itenantAtomSV.queryTenantCount(sql);
        sql.setLimitStart((pageNo-1)*pageSize);
        sql.setLimitEnd(pageSize);
        List<GnTenant> queryTenantList = itenantAtomSV.queryTenantList(sql);
        
        PageInfo<GnTenant> pageInfo = new PageInfo<GnTenant>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCount(count);
		pageInfo.setResult(queryTenantList);
		return pageInfo;
    }

    @Override
    public GnTenant queryTenantById(String tenantId) {
        return itenantAtomSV.queryByTenantId(tenantId);
    }

    @Override
    public int updateTenantById(GnTenant gnTenant) throws SystemException {
    	Timestamp updateTime = gnTenant.getUpdateTime();
    	if(updateTime == null){
    		gnTenant.setUpdateTime(DateUtil.getSysDate());
    	}
        return itenantAtomSV.updateTenantById(gnTenant);
    }

}
