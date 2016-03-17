package com.ai.opt.uac.api.account.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.interfaces.ITenantManageSV;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantQueryResponse;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class TenantManageSVImpl implements ITenantManageSV {

	@Override
	public TenantQueryResponse queryTenantInfo(BaseInfo tenantRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse insertTenantInfo(TenantInfoRequest tenantInfoRequest)
			throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}
