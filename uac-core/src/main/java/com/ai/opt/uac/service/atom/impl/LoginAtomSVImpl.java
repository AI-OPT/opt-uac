package com.ai.opt.uac.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.constants.AccountConstants;
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
        // 状态
        criteria.andStateEqualTo(AccountConstants.Account.ACCOUNT_STATE);
        // 生效时间小于等于当前时间

        criteria.andActiveTimeLessThanOrEqualTo(DateUtil.getSysDate());

        // 失效时间大于当前时间
        criteria.andInactiveTimeGreaterThan(DateUtil.getSysDate());

        List<GnAccount> list = MapperFactory.getGnAccountlMapper().selectByExample(conditon);
        if (!CollectionUtil.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean checkByUserName(GnAccount account) throws SystemException {
        GnAccountCriteria conditon = new GnAccountCriteria();
        GnAccountCriteria.Criteria criteria = conditon.or();
        boolean checkFlag;
        if (!StringUtil.isBlank(account.getPhone())) {
            criteria.andPhoneEqualTo(account.getPhone());
        }
        if (!StringUtil.isBlank(account.getEmail())) {
            criteria.andEmailEqualTo(account.getEmail());
        }
        if (!StringUtil.isBlank(account.getAccountName())) {
            criteria.andAccountNameEqualTo(account.getAccountName());
        }

        if (!StringUtil.isBlank(account.getAccountPassword())) {
            criteria.andAccountPasswordEqualTo(account.getAccountPassword());
        }

        List<GnAccount> list = MapperFactory.getGnAccountlMapper().selectByExample(conditon);
        if (CollectionUtil.isEmpty(list)) {
            checkFlag = false;
        } else {
            checkFlag = true;
        }
        return checkFlag;
    }

}
