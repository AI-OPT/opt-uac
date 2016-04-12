package com.ai.opt.uac.service.atom.interfaces;

import java.util.List;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;

public interface IAccountAtomSV {
	
	GnAccount queryByAccountId(Long accountId) throws SystemException;
	
	int updateByAccountId(GnAccount gnAccount) throws SystemException;
	
	List<GnAccount> queryAccountList(int start, int end, GnAccount params) throws SystemException;
	
	Long insertAccount(GnAccount gnAccount) throws SystemException;
	
}
