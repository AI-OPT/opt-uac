package com.ai.opt.uac.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria.Criteria;
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
	public List<GnAccount> queryAccountList(int start, int end, GnAccount params) throws SystemException {
		GnAccountMapper gnAccountlMapper = MapperFactory.getGnAccountlMapper();
		GnAccountCriteria example = new GnAccountCriteria();
		example.setLimitStart(start);
		example.setLimitEnd(end);
		Criteria criteria = example.createCriteria();
		String tenantId = params.getTenantId();
		if(!StringUtil.isBlank(tenantId)){
			criteria.andTenantIdEqualTo(tenantId);
		}
		String accountName = params.getAccountName();
		if(!StringUtil.isBlank(accountName)){
			criteria.andAccountNameEqualTo(accountName);
		}
		String phone = params.getPhone();
		if(!StringUtil.isBlank(phone)){
			//criteria.andPhoneEqualTo(phone);
			criteria.andPhoneLike("%"+phone+"%");
		}
		String email = params.getEmail();
		if(!StringUtil.isBlank(email)){
			//criteria.andEmailEqualTo(email);
			criteria.andEmailLike("%"+email+"%");
		}
		String accountType = params.getAccountType();
		if(!StringUtil.isBlank(accountType)){
			criteria.andAccountTypeEqualTo(accountType);
		}
		String accountLevel = params.getAccountLevel();
		if(!StringUtil.isBlank(accountLevel)){
			criteria.andAccountLevelEqualTo(accountLevel);
		}
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

}
