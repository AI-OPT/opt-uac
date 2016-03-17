package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IRegisterBusiSV;
import com.ai.opt.uac.util.AccountSeqUtil;
import com.ai.opt.uac.util.Md5Util;

@Service
@Transactional
public class RegisterBusiSVImpl implements IRegisterBusiSV {
    @Autowired
    IRegisterAtomSV iRegisterAtomSV;

    @Override
    public long registerByPhone(GnAccount account) {
        // 生成账号ID
        long accountId = AccountSeqUtil.createAccountId();
        account.setAccountId(accountId);
        // 对密码加密
        account.setPassword(Md5Util.stringMD5(account.getPassword()));
        iRegisterAtomSV.registerByPhone(account);
        return accountId;
    }

}
