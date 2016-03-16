package com.ai.opt.uac.api.account.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantQueryResponse;

public interface ITenantManageSV {
	
	/**
	 * 查询租户信息
	 * @param tenantReaponse
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0006
	 */
	TenantQueryResponse queryTenantInfo(BaseInfo tenantRequest) throws BusinessException,SystemException;
	
	/**
	 * 设置租户信息(新增)
	 * @param tenantInfoRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0007
	 */
	BaseResponse insertTenantInfo(TenantInfoRequest tenantInfoRequest) throws BusinessException,SystemException;
}
