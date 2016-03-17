package com.ai.opt.uac.service.atom.interfaces;

import com.ai.opt.uac.dao.mapper.bo.GnTenant;

public interface ITenantAtomSV {
	
	int insert(GnTenant gnTenant);
	
	GnTenant queryById(String tenantId);
}
