package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.register.param.phoneRegisterRequest;
import com.ai.opt.uac.api.register.param.phoneRegisterResponse;
import com.ai.opt.uac.constants.AccountConstants;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IRegisterBusiSV;
import com.ai.opt.uac.util.AccountSeqUtil;

@Service
@Transactional
public class RegisterBusiSVImpl implements IRegisterBusiSV {
    @Autowired
    IRegisterAtomSV iRegisterAtomSV;

    @Override
    public phoneRegisterResponse registerByPhone(phoneRegisterRequest registerVo)
            throws SystemException {
        GnAccount account = new GnAccount();
        BeanUtils.copyProperties(account, registerVo);
        // 生成规则？？？？
        long accountId = AccountSeqUtil.createAccountId();
        account.setAccountId(accountId);
        // 设置默认值
        account.setAccountType(AccountConstants.Account.ACCOUNT_TYPE);
        account.setAccountLevel(AccountConstants.Account.ACCOUNT_LEVEL);
        account.setInactiveTime(DateUtil.getTimestamp(AccountConstants.Account.INACTIVE_DATE));
        account.setCreateTime(DateUtil.getSysDate());
        account.setTenantId(AccountConstants.Account.INIT_TENANT_ID);
        // 返回参数
        phoneRegisterResponse response = new phoneRegisterResponse();
        response.setAccountId(accountId);

        iRegisterAtomSV.registerByPhone(account);

        return response;
    }

}
