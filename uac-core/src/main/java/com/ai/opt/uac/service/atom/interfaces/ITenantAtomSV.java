package com.ai.opt.uac.service.atom.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;

public interface ITenantAtomSV {
	
	int insert(GnTenant gnTenant) throws SystemException;
	
	GnTenant queryByTenantId(String tenantId) throws SystemException;
}
