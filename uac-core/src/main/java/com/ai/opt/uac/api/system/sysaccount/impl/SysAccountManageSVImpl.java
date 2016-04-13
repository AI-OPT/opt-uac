package com.ai.opt.uac.api.system.sysaccount.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.uac.api.system.sysaccount.interfaces.ISysAccountManageSV;
import com.ai.opt.uac.api.system.sysaccount.param.AccountDelRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryData;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.ISysAccountBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
@Component
public class SysAccountManageSVImpl implements ISysAccountManageSV {

	@Autowired
	IVoValidateSV iVoValidateSV;

	@Autowired
	ISysAccountBusiSV iSysAccountBusiSV;

	@Override
	public AccountPageQueryResponse queryAccountPageInfo(AccountPageQueryRequest queryRequest) {
		iVoValidateSV.validateSysQueryAccountPageInfo(queryRequest);
		PageInfo<GnAccount> accountPageInfo = iSysAccountBusiSV.queryAccountPageInfo(queryRequest);
		AccountPageQueryResponse accountPageQueryResponse = new AccountPageQueryResponse();
		PageInfo<AccountPageQueryData> pageInfo = new PageInfo<AccountPageQueryData>();
		int count = accountPageInfo.getCount();
		pageInfo.setCount(count);
		Integer pageNo = accountPageInfo.getPageNo();
		pageInfo.setPageNo(pageNo);
		Integer pageSize = accountPageInfo.getPageSize();
		pageInfo.setPageSize(pageSize);
		List<GnAccount> accountList = accountPageInfo.getResult();
		if (accountList != null && accountList.size() > 0) {
			Gson gson = new Gson();
			String accountListJson = gson.toJson(accountList);
			List<AccountPageQueryData> accountPageDatList = gson.fromJson(accountListJson, new TypeToken<List<AccountPageQueryData>>() {
			}.getType());
			pageInfo.setResult(accountPageDatList);
		}
		accountPageQueryResponse.setPageInfo(pageInfo);
		ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE,"查询成功");
		accountPageQueryResponse.setResponseHeader(responseHeader );
		return accountPageQueryResponse;
	}

	@Override
	public AccountInfoQueryResponse queryAccountInfo(AccountInfoQueryRequest queryRequest) {
		iVoValidateSV.validateSysQueryAccountInfo(queryRequest);
		Long accountId = queryRequest.getAccountId();
		GnAccount accountInfo = iSysAccountBusiSV.queryByAccountId(accountId);
		AccountInfoQueryResponse accountInfoQueryResponse = new AccountInfoQueryResponse();
		if (accountInfo != null) {
			BeanUtils.copyProperties(accountInfoQueryResponse, accountInfo);
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "查询成功");
			accountInfoQueryResponse.setResponseHeader(responseHeader);
			return accountInfoQueryResponse;
		} else {
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.FAIL_CODE, "查询失败,无数据");
			accountInfoQueryResponse.setResponseHeader(responseHeader);
			return accountInfoQueryResponse;
		}
	}

	@Override
	public AccountInsertResponse insertAccountInfo(AccountInsertRequest insertRequest) {
		iVoValidateSV.validateSysInsertAccountInfo(insertRequest);
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, insertRequest);
		Long accountId = iSysAccountBusiSV.insertAccountInfo(gnAccount);
		AccountInsertResponse accountInsertResponse = new AccountInsertResponse();
		if (accountId != null) {
			accountInsertResponse.setAccountId(accountId);
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "插入数据成功");
			accountInsertResponse.setResponseHeader(responseHeader);
			return accountInsertResponse;
		} else {
			accountInsertResponse.setAccountId(null);
			ResponseHeader responseHeader = new ResponseHeader(false, ResultCode.FAIL_CODE, "插入数据失败");
			accountInsertResponse.setResponseHeader(responseHeader);
			return accountInsertResponse;
		}
	}

	@Override
	public BaseResponse updateAccountInfo(AccountUpdateRequest updateRequest) {
		iVoValidateSV.validateSysUpdateAccountInfo(updateRequest);
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, updateRequest);
		int count = iSysAccountBusiSV.updateAccountInfo(gnAccount);
		BaseResponse baseResponse = new BaseResponse();
		if (count > 0) {
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "更新数据成功");
			baseResponse.setResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = new ResponseHeader(false, ResultCode.FAIL_CODE, "无更新数据");
			baseResponse.setResponseHeader(responseHeader);
		}
		return baseResponse;
	}

	@Override
	public BaseResponse deletAccountInfo(AccountDelRequest deleteRequest) {
		iVoValidateSV.validateSysDeletAccountInfo(deleteRequest);
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, deleteRequest);
		int count = iSysAccountBusiSV.deleteByAccountId(gnAccount);
		BaseResponse baseResponse = new BaseResponse();
		if (count > 0) {
			ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "删除成功");
			baseResponse.setResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = new ResponseHeader(false, ResultCode.FAIL_CODE, "无删除数据");
			baseResponse.setResponseHeader(responseHeader);
		}
		return baseResponse;
	}

}
