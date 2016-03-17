package com.ai.opt.uac.service.atom.impl;

import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnTenantMapper;
import com.ai.opt.uac.service.atom.interfaces.ITenantAtomService;

public class TenantAtomSVImpl implements ITenantAtomService {

	@Override
	public String insert(GnTenant gnTenant) {
		String tenantId = "";
		GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		int count = tenantMapper.insertSelective(gnTenant);
		return count > 0 ? tenantId : null;
	}

	@Override
	public GnTenant queryById(String tenantId) {
		GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		return tenantMapper.selectByPrimaryKey(tenantId);
	}

}
