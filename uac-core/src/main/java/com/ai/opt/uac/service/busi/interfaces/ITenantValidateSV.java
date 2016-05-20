package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;

public interface ITenantValidateSV {
	void checkTenantId(String tenantId) throws BusinessException;
	
	void checkTenantName(String tenantName) throws BusinessException;
	
	void checkIndustryCode(String industryCode) throws BusinessException;
	
	void checkAccountId(Long accountId) throws BusinessException;
	
	void checkUpdateAccountId(Long updateAccountId) throws BusinessException;
	
	void checkCreateAccountId(Long createAccountId) throws BusinessException;
	
	void checkTenantIdIsExit(String tenantId) throws BusinessException;
	
}
