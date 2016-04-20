package com.ai.opt.uac.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnAccountMapper;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
import com.ai.opt.uac.util.AccountSeqUtil;
@Component
public class AccountAtomSVImpl implements IAccountAtomSV {

	@Override
	public GnAccount queryByAccountId(Long accountId) throws SystemException {
		GnAccountMapper gnAccountlMapper = MapperFactory.getGnAccountlMapper();
		return gnAccountlMapper.selectByPrimaryKey(accountId);
	}

	@Override
	public int updateByAccountId(GnAccount gnAccount) throws SystemException {
		GnAccountMapper gnAccountlMapper = MapperFactory.getGnAccountlMapper();
		return gnAccountlMapper.updateByPrimaryKeySelective(gnAccount);
	}

	@Override
	public List<GnAccount> queryAccountList(GnAccountCriteria example) throws SystemException {
		GnAccountMapper gnAccountlMapper = MapperFactory.getGnAccountlMapper();
		return gnAccountlMapper.selectByExample(example);
	}

	@Override
	public Long insertAccount(GnAccount gnAccount) throws SystemException {
		GnAccountMapper gnAccountlMapper = MapperFactory.getGnAccountlMapper();
		// 生成账号ID
        long accountId = AccountSeqUtil.createAccountId();
        gnAccount.setAccountId(accountId);
        int count = gnAccountlMapper.insertSelective(gnAccount);
        if(count >= 0){
        	return accountId;
        }else{
        	return null;
        }
	}

	@Override
	public int queryAccountCount(GnAccountCriteria example) throws SystemException {
		GnAccountMapper gnAccountlMapper = MapperFactory.getGnAccountlMapper();
		return gnAccountlMapper.countByExample(example);
	}

    @Override
    public GnAccount queryByPhone(String phone) throws SystemException {
        GnAccountCriteria conditon = new GnAccountCriteria();
        GnAccountCriteria.Criteria criteria = conditon.or();
        criteria.andPhoneEqualTo(phone);
        List<GnAccount> list = MapperFactory.getGnAccountlMapper().selectByExample(conditon);
        if(!CollectionUtil.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    @Override
    public GnAccount queryByEmail(String email) throws SystemException {
        GnAccountCriteria conditon = new GnAccountCriteria();
        GnAccountCriteria.Criteria criteria = conditon.or();
        criteria.andEmailEqualTo(email);
        List<GnAccount> list = MapperFactory.getGnAccountlMapper().selectByExample(conditon);
        if(!CollectionUtil.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }

}
