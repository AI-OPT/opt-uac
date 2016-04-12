package com.ai.opt.uac.api.system.systenant.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.system.systenant.interfaces.ISysTenantManageSV;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantRequest;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantResponse;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.service.busi.interfaces.ISysTenantBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class SysTenantManageSVImpl implements ISysTenantManageSV{
    @Autowired
    ISysTenantBusiSV itenantBusiSV;
    @Autowired
    IVoValidateSV iVoValidateSV;
    @Override
    public PageInfo<QueryTenantResponse> queryTenantInfo(QueryTenantRequest tenantRequest)
            throws BusinessException, SystemException {
        iVoValidateSV.validateQueyTenantPage(tenantRequest);
        PageInfo<GnTenant> pageVo = itenantBusiSV.queryTenantInfo(tenantRequest);
        PageInfo<QueryTenantResponse> pageInfo = new PageInfo<QueryTenantResponse>();
        pageInfo.setCount(pageVo.getCount());
        pageInfo.setPageNo(pageVo.getPageNo());
        pageInfo.setPageSize(pageVo.getPageSize());
        if (!CollectionUtil.isEmpty(pageVo.getResult())) {
            List<QueryTenantResponse> tenants = new ArrayList<>();
            for (GnTenant idx : pageVo.getResult()) {
                GnTenant tenant = itenantBusiSV.queryTenantById(idx.getTenantId());
                if (tenant != null) {
                    if(tenant.getUpdateAccountId()==null){
                        tenant.setUpdateAccountId(0l); 
                    }
                    if(tenant.getCreateAccountId()==null){
                        tenant.setCreateAccountId(0l); 
                    }
                    QueryTenantResponse tenantInfo = new QueryTenantResponse();
                    BeanUtils.copyProperties(tenantInfo, tenant);
                    tenants.add(tenantInfo);
                }
            }
            pageInfo.setResult(tenants);
        }
        return pageInfo;
    }

    @Override
    public BaseResponse updateTenantByTenant(QueryTenantRequest tenantRequest)
            throws BusinessException, SystemException {
        iVoValidateSV.validateUpdateTenant(tenantRequest);
     // 数据库操作
        GnTenant gnTenant = new GnTenant();
        BeanUtils.copyProperties(gnTenant, tenantRequest);
        gnTenant.setUpdateTime(DateUtil.getSysDate());
        int updateCount = itenantBusiSV.updateTenantById(gnTenant);
        // 整理返回对象
        ResponseHeader responseHeader = new ResponseHeader();
        if (updateCount > 0) {
            responseHeader.setIsSuccess(true);
            responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
            responseHeader.setResultMessage("数据更新成功");
        } else {
            responseHeader.setIsSuccess(false);
            responseHeader.setResultCode(ResultCode.FAIL_CODE);
            responseHeader.setResultMessage("数据库更新失败");
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponseHeader(responseHeader);
        return baseResponse;
    }

    @Override
    public QueryTenantResponse queryTenantById(String tenantId)
            throws BusinessException, SystemException {
        iVoValidateSV.validateQueyTenantDetail(tenantId);
        GnTenant gnTenant = itenantBusiSV.queryTenantById(tenantId);
        // 整理返回对象
        QueryTenantResponse tenantQueryResponse = new QueryTenantResponse();
        if (gnTenant != null) {
            BeanUtils.copyProperties(tenantQueryResponse, gnTenant);
        }
        ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "查询成功");
        tenantQueryResponse.setResponseHeader(responseHeader);
        return tenantQueryResponse;
    }

}
