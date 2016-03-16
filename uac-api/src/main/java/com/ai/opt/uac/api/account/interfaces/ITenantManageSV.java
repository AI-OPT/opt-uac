package com.ai.opt.uac.api.account.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantQueryResponse;

public interface ITenantManageSV {
	
	/**
	 * ��ѯ�⻧��Ϣ
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
	 * �����⻧��Ϣ(����)
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
