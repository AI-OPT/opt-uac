package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
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
    public long registerByPhone(GnAccount account) throws BusinessException{
        // 生成账号ID
        long accountId = AccountSeqUtil.createAccountId();
        account.setAccountId(accountId);
        iRegisterAtomSV.registerByPhone(account);
        return accountId;
    }

}
