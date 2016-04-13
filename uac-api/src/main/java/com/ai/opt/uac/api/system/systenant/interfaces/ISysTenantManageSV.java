package com.ai.opt.uac.api.system.systenant.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.UpdateTenantRequest;

/**
 * 系统管理-租户服务 Date: 2016年4月7日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public interface ISysTenantManageSV {

	/**
	 * 分页查询租户信息
	 * 
	 * @param tenantRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode UAC_SYS_0001
	 */
	QueryPageTenantResponse queryTenantPageInfo(QueryPageTenantRequest tenantRequest) throws BusinessException, SystemException;

	/**
	 * 查询详细信息
	 * 
	 * @param baseInfo
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode UAC_SYS_0002
	 */
	QueryTenantResponse queryTenantById(BaseInfo baseInfo) throws BusinessException, SystemException;

	/**
	 * 修改租户
	 * 
	 * @param tenantRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhanglh
	 * @ApiCode UAC_SYS_0003
	 */
	BaseResponse updateByTenantId(UpdateTenantRequest tenantRequest) throws BusinessException, SystemException;
}
