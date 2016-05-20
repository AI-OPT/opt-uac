package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
import com.ai.opt.uac.service.atom.interfaces.ITenantAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ITenantBusiSV;

@Service
@Transactional
public class TenantBusiSVImpl implements ITenantBusiSV {

	@Autowired
	ITenantAtomSV itenantAtomSV;
	@Autowired
	IAccountAtomSV iAccountAtomSV;

	@Override
	public GnTenant queryByTenantId(String tenantId) throws SystemException {
		return itenantAtomSV.queryByTenantId(tenantId);
	}

	@Override
	public boolean insertTenantAndSyncAccount(GnTenant gnTenant) throws SystemException {
		int insertCount = itenantAtomSV.insert(gnTenant);
		if(insertCount>0){
		    return true;
		}else{
		    return false;
		}
		
	}

    @Override
    public int updateByTenantId(GnTenant gnTenant) throws SystemException {
        return itenantAtomSV.updateTenantById(gnTenant);
    }

}
