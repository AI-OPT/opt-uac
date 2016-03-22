package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.constants.AccountExceptCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IAccountBusiSV;

@Service
@Transactional
public class AccountBusiSVImpl implements IAccountBusiSV {

    @Autowired
    IAccountAtomSV iAccountAtomSV;

    @Autowired
    IRegisterAtomSV iRegisterAtomSV;

    @Override
    public GnAccount queryByAccountId(Long accountId) throws SystemException {
        return iAccountAtomSV.queryByAccountId(accountId);
    }

    @Override
    public int updateByAccountId(GnAccount gnAccount) throws SystemException {
        // 判断手机号码是否存在
        int count = iRegisterAtomSV.getCountByPhone(gnAccount.getPhone());
        if (count >= 1) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "该手机已经进行存在，请重新输入");
        }
        return iAccountAtomSV.updateByAccountId(gnAccount);
    }

}
