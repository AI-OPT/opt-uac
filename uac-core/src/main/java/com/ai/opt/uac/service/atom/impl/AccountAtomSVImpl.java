package com.ai.opt.uac.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnAccountMapper;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
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

}
