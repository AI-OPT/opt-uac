package com.ai.opt.uac.service.busi.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.constants.AccountConstants;
import com.ai.opt.uac.constants.AccountConstants.Account;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria.Criteria;
import com.ai.opt.uac.service.atom.interfaces.IAccountAtomSV;
import com.ai.opt.uac.service.busi.interfaces.ISysAccountBusiSV;
import com.ai.opt.uac.util.AccountSeqUtil;

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
		GnAccountCriteria example = new GnAccountCriteria();
		String userName = pageQueryRequest.getUserName();
		if (StringUtil.isBlank(userName)) {
			Criteria criteria = example.or();
			setQueryPageInfoCriteria(criteria, pageQueryRequest, 0);
		} else {
			Criteria criteriaPhone = example.or();
			setQueryPageInfoCriteria(criteriaPhone, pageQueryRequest, 1);
			Criteria criteriaEmail = example.or();
			setQueryPageInfoCriteria(criteriaEmail, pageQueryRequest, 2);
			Criteria criteriaName = example.or();
			setQueryPageInfoCriteria(criteriaName, pageQueryRequest, 3);
		}
		PageInfo<GnAccount> pageInfo = new PageInfo<GnAccount>();
		int accountCount = iAccountAtomSV.queryAccountCount(example);
		pageInfo.setCount(accountCount);
		Integer pageNo = pageQueryRequest.getPageNo();
		Integer pageSize = pageQueryRequest.getPageSize();
		example.setLimitStart((pageNo - 1) * pageSize);
		example.setLimitEnd(pageSize);
		List<GnAccount> accountList = iAccountAtomSV.queryAccountList(example);
		pageInfo.setPageNo(pageNo);
		pageInfo.setPageSize(pageSize);
		pageInfo.setResult(accountList);
		return pageInfo;
	}

	/**
	 * 设置分页查询条件
	 * 
	 * @param criteria
	 * @param pageQueryRequest
	 * @param type
	 *            1：手机 2：邮箱 3：账户名
	 * @return
	 */
	private void setQueryPageInfoCriteria(Criteria criteria, AccountPageQueryRequest pageQueryRequest, int type) {
		String tenantId = pageQueryRequest.getTenantId();
		if (!StringUtil.isBlank(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		String accountType = pageQueryRequest.getAccountType();
		if (!StringUtil.isBlank(accountType)) {
			criteria.andAccountTypeEqualTo(accountType);
		}
		String accountLevel = pageQueryRequest.getAccountLevel();
		if (!StringUtil.isBlank(accountLevel)) {
			criteria.andAccountLevelEqualTo(accountLevel);
		}
		String userName = pageQueryRequest.getUserName();
		if (!StringUtil.isBlank(userName)) {
			// boolean isEmial = RegexUtils.checkIsEmail(userName);
			// boolean isPhone = RegexUtils.checkIsPhone(userName);
			// if (isPhone == true) {
			// criteria.andPhoneLike("%" + userName + "%");
			// } else if (isEmial == true) {
			// criteria.andEmailLike("%" + userName + "%");
			// } else {
			// criteria.andAccountNameLike("%" + userName + "%");
			// }
			if (type == 1) {
				criteria.andPhoneLike("%" + userName + "%");
			} else if (type == 2) {
				criteria.andEmailLike("%" + userName + "%");
			} else if (type == 3) {
				criteria.andAccountNameLike("%" + userName + "%");
			}
		}
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
		String state = gnAccount.getState();
		if (StringUtil.isBlank(state)) {
			gnAccount.setState(AccountConstants.Account.ACCOUNT_STATE);
		}
		String nickName = gnAccount.getNickName();
		if (StringUtil.isBlank(nickName)) {
			gnAccount.setNickName(AccountSeqUtil.createNickName());
		}
		String accountType = gnAccount.getAccountType();
		if (StringUtil.isBlank(accountType)) {
			gnAccount.setAccountType(AccountConstants.Account.ACCOUNT_TYPE);
		}
		String accountLevel = gnAccount.getAccountLevel();
		if(StringUtil.isBlank(accountLevel)){
			gnAccount.setAccountLevel(AccountConstants.Account.ACCOUNT_LEVEL);
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
