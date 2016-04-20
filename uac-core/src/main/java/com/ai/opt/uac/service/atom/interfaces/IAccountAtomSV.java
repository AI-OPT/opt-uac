package com.ai.opt.uac.service.atom.interfaces;

import java.util.List;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria;

public interface IAccountAtomSV {
	
	GnAccount queryByAccountId(Long accountId) throws SystemException;
	
	int updateByAccountId(GnAccount gnAccount) throws SystemException;
	
	List<GnAccount> queryAccountList(GnAccountCriteria example) throws SystemException;
	
	int queryAccountCount(GnAccountCriteria example) throws SystemException;
	
	Long insertAccount(GnAccount gnAccount) throws SystemException;
	
	GnAccount queryByPhone(String phone)throws SystemException;
	
}
