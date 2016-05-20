package com.ai.opt.uac.api.account.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantInsertResponse;
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
     * @ApiCode UAC_0005
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
     * @ApiCode UAC_0006
	 */
	TenantInsertResponse insertTenantInfo(TenantInfoRequest tenantInfoRequest) throws BusinessException,SystemException;
	/**
	 * 修改租户信息
	 * @param tenantInfoRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode UAC_0015
	 */
    BaseResponse updateTenant(TenantInfoRequest tenantInfoRequest) throws BusinessException,SystemException;
    
}
