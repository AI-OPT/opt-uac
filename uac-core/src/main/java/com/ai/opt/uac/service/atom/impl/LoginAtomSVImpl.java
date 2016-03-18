package com.ai.opt.uac.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.service.atom.interfaces.ILoginAtomSV;

@Component
public class LoginAtomSVImpl implements ILoginAtomSV {

    @Override
    public GnAccount queryByUserName(GnAccount account) {

        GnAccountCriteria conditon = new GnAccountCriteria();
        GnAccountCriteria.Criteria criteria = conditon.or();
        if (!StringUtil.isBlank(account.getPhone())) {
            criteria.andPhoneEqualTo(account.getPhone());
        }
        if (!StringUtil.isBlank(account.getEmail())) {
            criteria.andEmailEqualTo(account.getEmail());
        }
        if (!StringUtil.isBlank(account.getAccountName())) {
            criteria.andAccountNameEqualTo(account.getAccountName());
        }
        /*
         * if(!StringUtil.isBlank(account.getPassword())){
         * criteria.andPasswordEqualTo(account.getPassword()); }
         */

        List<GnAccount> list = MapperFactory.getGnAccountlMapper().selectByExample(conditon);
        if (!CollectionUtil.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

}
