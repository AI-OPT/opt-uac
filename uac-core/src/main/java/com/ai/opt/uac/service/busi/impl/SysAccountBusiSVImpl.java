package com.ai.opt.uac.service.busi.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.constants.AccountConstants.Account;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ISysAccountBusiSV;
import com.ai.opt.uac.util.RegexUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Transactional
public class SysAccountBusiSVImpl implements ISysAccountBusiSV {

	@Autowired
	IAccountAtomSV iAccountAtomSV;

	@Override
	public GnAccount queryByAccountId(Long accountId) throws SystemException {
		return iAccountAtomSV.queryByAccountId(accountId);
	}

	@Override
	public PageInfo<GnAccount> queryAccountPageInfo(AccountPageQueryRequest pageQueryRequest) throws SystemException {
		Integer pageNo = pageQueryRequest.getPageNo();
		Integer pageSize = pageQueryRequest.getPageSize();
		GnAccount params = new GnAccount();
		BeanUtils.copyProperties(params, pageQueryRequest);
		String userName = pageQueryRequest.getUserName();
		boolean isEmial = RegexUtils.checkIsEmail(userName);
		boolean isPhone = RegexUtils.checkIsPhone(userName);
		if (isPhone == true) {
			params.setPhone(userName);
		} else if (isEmial == true) {
			params.setEmail(userName);
		} else {
			params.setAccountName(userName);
		}
		List<GnAccount> accountList = iAccountAtomSV.queryAccountList((pageNo - 1) * pageSize, pageSize, params);
		PageInfo<GnAccount> pageInfo = new PageInfo<GnAccount>();
		pageInfo.setPageNo(pageNo);
		pageInfo.setPageSize(pageSize);
		pageInfo.setResult(accountList);
		if (accountList != null && accountList.size() > 0) {
			pageInfo.setCount(accountList.size());
		} else {
			pageInfo.setCount(0);
		}
		return pageInfo;
	}

	@Override
	public Long insertAccountInfo(GnAccount gnAccount) throws SystemException {
		Timestamp activeTime = gnAccount.getActiveTime();
		if (activeTime == null) {
			gnAccount.setActiveTime(DateUtil.getSysDate());
		}
		Timestamp inactiveTime = gnAccount.getInactiveTime();
		if (inactiveTime == null) {
			gnAccount.setInactiveTime(DateUtil.getTimestamp(Account.INACTIVE_DATE, DateUtil.DATETIME_FORMAT));
		}
		Timestamp createTime = gnAccount.getCreateTime();
		if (createTime == null) {
			gnAccount.setCreateTime(DateUtil.getSysDate());
		}
		String accountPassword = gnAccount.getAccountPassword();
		if (StringUtil.isBlank(accountPassword)) {
			gnAccount.setAccountPassword(Account.DEFAULT_PASSWORD);
		}
		return iAccountAtomSV.insertAccount(gnAccount);
	}

	@Override
	public int updateAccountInfo(GnAccount gnAccount) throws SystemException {
		Timestamp updateTime = gnAccount.getUpdateTime();
		if (updateTime == null) {
			gnAccount.setUpdateTime(DateUtil.getSysDate());
		}
		return iAccountAtomSV.updateByAccountId(gnAccount);
	}

	@Override
	public int deleteByAccountId(GnAccount gnAccount) throws SystemException {
		Timestamp inactiveTime = gnAccount.getInactiveTime();
		if (inactiveTime == null) {
			gnAccount.setInactiveTime(DateUtil.getSysDate());
		}
		Timestamp updateTime = gnAccount.getUpdateTime();
		if (updateTime == null) {
			gnAccount.setUpdateTime(DateUtil.getSysDate());
		}
		return iAccountAtomSV.updateByAccountId(gnAccount);
	}
}
