package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;

public interface ITenantBusiSV {
	GnTenant queryByTenantId(String tenantId) throws SystemException;
	
	boolean insertTenantAndSyncAccount(GnTenant gnTenant,GnAccount gnAccount) throws SystemException;
}
