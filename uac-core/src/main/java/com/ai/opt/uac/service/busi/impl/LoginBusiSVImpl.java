package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.ILoginAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ILoginBusiSV;
import com.ai.opt.uac.util.Md5Util;

@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {
    @Autowired
    ILoginAtomSV iLoginAtomSV;

    @Override
    public GnAccount queryByUserName(GnAccount account) throws BusinessException {

        GnAccount adAccount = iLoginAtomSV.judgeUser(account);
        if (adAccount == null) {
            throw new BusinessException("10001", "用户名不存在！");
        }
        // 对登录密码进行加密
        Md5Util.stringMD5(account.getPassword());
        GnAccount result = iLoginAtomSV.queryByUserName(account);
        if (result == null) {
            throw new BusinessException("10002", "密码错误！");
        }
        return result;
    }

}
