package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IAccountBusiSV;

@Service
@Transactional
public class AccountBusiSVImpl implements IAccountBusiSV {

    @Autowired
    IAccountAtomSV iAccountAtomSV;

    @Override
    public GnAccount queryByAccountId(Long accountId) throws SystemException {
        return iAccountAtomSV.queryByAccountId(accountId);
    }

    @Override
    public int updateByAccountId(GnAccount gnAccount) throws SystemException {
        return iAccountAtomSV.updateByAccountId(gnAccount);
    }

}
