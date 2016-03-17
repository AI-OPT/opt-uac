package com.ai.opt.uac.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnTenantMapper;
import com.ai.opt.uac.service.atom.interfaces.ITenantAtomSV;

@Component
public class TenantAtomSVImpl implements ITenantAtomSV {

	@Override
	public int insert(GnTenant gnTenant) throws SystemException {
		GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		return tenantMapper.insertSelective(gnTenant);
	}

	@Override
	public GnTenant queryByTenantId(String tenantId) throws SystemException {
		GnTenantMapper tenantMapper = MapperFactory.getGnTenantMapper();
		return tenantMapper.selectByPrimaryKey(tenantId);
	}

}
