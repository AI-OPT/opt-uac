package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;

public interface ISysAccountBusiSV {

	GnAccount queryByAccountId(Long accountId) throws SystemException;
	
	PageInfo<GnAccount> queryAccountPageInfo(AccountPageQueryRequest pageQueryRequest) throws SystemException;
	
	Long insertAccountInfo(GnAccount gnAccount) throws SystemException;
	
	int updateAccountInfo(GnAccount gnAccount) throws SystemException;
	
	int deleteByAccountId(GnAccount gnAccount) throws SystemException;
}
