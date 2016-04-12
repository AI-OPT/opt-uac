package com.ai.opt.uac.api.system.sysaccount.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.system.sysaccount.interfaces.ISysAccountManageSV;
import com.ai.opt.uac.api.system.sysaccount.param.AccountDelRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.ISysAccountBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;

public class SysAccountManageSVImpl implements ISysAccountManageSV{

	@Autowired
	IVoValidateSV iVoValidateSV;
	
	@Autowired
	ISysAccountBusiSV iSysAccountBusiSV;
	
	@Override
	public PageInfo<AccountPageQueryResponse> queryAccountPageInfo(AccountPageQueryRequest queryRequest) {
		iVoValidateSV.validateSysQueryAccountPageInfo(queryRequest);
		PageInfo<GnAccount> queryAccountPageInfo = iSysAccountBusiSV.queryAccountPageInfo(queryRequest);
		return null;
	}

	@Override
	public AccountInfoQueryResponse queryAccountInfo(AccountInfoQueryRequest queryRequest) {
		iVoValidateSV.validateSysQueryAccountInfo(queryRequest);
		Long accountId=queryRequest.getAccountId();
		GnAccount accountInfo = iSysAccountBusiSV.queryByAccountId(accountId);
		AccountInfoQueryResponse accountInfoQueryResponse = new AccountInfoQueryResponse();
		if(accountInfo != null){
			BeanUtils.copyProperties(accountInfoQueryResponse, accountInfo);
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCode.SUCCESS_CODE, "查询成功");
			accountInfoQueryResponse.setResponseHeader(responseHeader);
			return  accountInfoQueryResponse;
		}else{
			ResponseHeader responseHeader=new ResponseHeader(false, ResultCode.FAIL_CODE, "查询失败");
			accountInfoQueryResponse.setResponseHeader(responseHeader);
			return  accountInfoQueryResponse;
		}
	}

	@Override
	public AccountInsertResponse insertAccountInfo(AccountInsertRequest insertRequest) {
		iVoValidateSV.validateSysInsertAccountInfo(insertRequest);
		GnAccount gnAccount=new GnAccount();
		BeanUtils.copyProperties(gnAccount, insertRequest);
		Long accountId = iSysAccountBusiSV.insertAccountInfo(gnAccount);
		AccountInsertResponse accountInsertResponse = new AccountInsertResponse();
		if(accountId != null){
			accountInsertResponse.setAccountId(accountId);
			ResponseHeader responseHeader=new ResponseHeader(true, ResultCode.SUCCESS_CODE, "插入数据成功");
			accountInsertResponse.setResponseHeader(responseHeader);
			return accountInsertResponse;
		}else{
			accountInsertResponse.setAccountId(null);
			ResponseHeader responseHeader=new ResponseHeader(false, ResultCode.FAIL_CODE, "插入数据失败");
			accountInsertResponse.setResponseHeader(responseHeader);
			return accountInsertResponse;
		}
	}

	@Override
	public BaseResponse updateAccountInfo(AccountUpdateRequest updateRequest) {
		iVoValidateSV.validateSysUpdateAccountInfo(updateRequest);
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, updateRequest);
		Timestamp updateTime = gnAccount.getUpdateTime();
		if(updateTime == null){
			gnAccount.setUpdateTime(DateUtil.getSysDate());
		}
		int count = iSysAccountBusiSV.updateAccountInfo(gnAccount);
		BaseResponse baseResponse = new BaseResponse();
		if(count > 0){
			ResponseHeader responseHeader=new ResponseHeader(false, ResultCode.FAIL_CODE, "更新数据成功");
			baseResponse.setResponseHeader(responseHeader);
		}else{
			ResponseHeader responseHeader=new ResponseHeader(false, ResultCode.FAIL_CODE, "无更新数据");
			baseResponse.setResponseHeader(responseHeader);
		}
		return baseResponse;
	}

	@Override
	public BaseResponse deletAccountInfo(AccountDelRequest deleteRequest) {
		iVoValidateSV.validateSysDeletAccountInfo(deleteRequest);
		// TODO Auto-generated method stub
		return null;
	}

}
