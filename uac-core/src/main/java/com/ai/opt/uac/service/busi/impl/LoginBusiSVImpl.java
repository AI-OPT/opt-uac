package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.ILoginAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ILoginBusiSV;

@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {
    @Autowired
    ILoginAtomSV iLoginAtomSV;

    @Override
    public GnAccount queryByUserName(GnAccount account) throws BusinessException {

        // 对登录密码进行加密
       // Md5Util.stringMD5(account.getPassword());
        return iLoginAtomSV.queryByUserName(account);

    }

}
