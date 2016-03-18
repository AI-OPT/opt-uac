package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.uac.constants.AccountExceptCode;
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
        //判断手机号码是否存在
        int count = iRegisterAtomSV.getCountByPhone(account.getPhone());
        if(count>=1){
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "该手机已经进行过注册，请重新输入");
        }
        // 生成账号ID
        long accountId = AccountSeqUtil.createAccountId();
        account.setAccountId(accountId);
        iRegisterAtomSV.registerByPhone(account);
        return accountId;
    }

}
