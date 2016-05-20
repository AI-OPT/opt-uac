package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.uac.api.account.interfaces.ITenantManageSV;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantInsertResponse;
import com.ai.opt.uac.constants.AccountConstants;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IRegisterBusiSV;
import com.ai.opt.uac.util.AccountSeqUtil;

@Service
@Transactional
public class RegisterBusiSVImpl implements IRegisterBusiSV {
    @Autowired
    IRegisterAtomSV iRegisterAtomSV;
    @Autowired
    ITenantManageSV iTenantManageSV;
    @Override
    public long registerByPhone(GnAccount account) throws BusinessException{
        // 生成账号ID
        long accountId = AccountSeqUtil.createAccountId();
        account.setAccountId(accountId);
        //生成租戶
        TenantInfoRequest tenantrequest = new TenantInfoRequest();
        tenantrequest.setCreateAccountId(accountId);
        tenantrequest.setTenantName("test");
        TenantInsertResponse tenanResponse = iTenantManageSV.insertTenantInfo(tenantrequest);
        if(tenanResponse.getResponseHeader().getResultCode().equals(ResultCode.SUCCESS_CODE)){
            account.setTenantId(tenanResponse.getTenantId());
        }else{
            account.setTenantId(AccountConstants.Account.INIT_TENANT_ID); 
        }
        iRegisterAtomSV.registerByPhone(account);
        return accountId;
    }

}
