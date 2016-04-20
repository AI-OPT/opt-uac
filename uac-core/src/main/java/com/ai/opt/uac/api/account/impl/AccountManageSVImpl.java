package com.ai.opt.uac.api.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.account.interfaces.IAccountManageSV;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountQueryResponse;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.IAccountBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountManageSVImpl implements IAccountManageSV {

	@Autowired
	IAccountBusiSV iAccountBusiSV;
	@Autowired
	IVoValidateSV iVoValidateSV;

	@Override
	public AccountQueryResponse queryBaseInfo(AccountQueryRequest accountQueryRequest) throws BusinessException,SystemException {
		// 入参检查
		iVoValidateSV.validateQueryAccountBaseInfo(accountQueryRequest);
		// 查询数据
		Long accountId = accountQueryRequest.getAccountId();
		GnAccount gnAccount = iAccountBusiSV.queryByAccountId(accountId);
		// 整理返回对象
		AccountQueryResponse accountQueryResponse = new AccountQueryResponse();
		if (gnAccount != null) {
			BeanUtils.copyProperties(accountQueryResponse, gnAccount);
		}
		ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "数据查询成功");
		accountQueryResponse.setResponseHeader(responseHeader);
		return accountQueryResponse;
	}

	@Override
	public BaseResponse updateBaseInfo(AccountBaseModifyRequest accountModifyRequest) throws BusinessException,SystemException {
		// 入参检查
		iVoValidateSV.validateUpdateAccountInfo(accountModifyRequest);
		// 数据库操作
		GnAccount gnAccount = new GnAccount();
		BeanUtils.copyProperties(gnAccount, accountModifyRequest);
		gnAccount.setUpdateTime(DateUtil.getSysDate());
		int updateCount = iAccountBusiSV.updateByAccountId(gnAccount);
		// 整理返回对象
		ResponseHeader responseHeader = new ResponseHeader();
		if (updateCount > 0) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ResultCode.SUCCESS_CODE);
			responseHeader.setResultMessage("数据更新成功");
		} else {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ResultCode.FAIL_CODE);
			responseHeader.setResultMessage("数据库查询失败");
		}
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponseHeader(responseHeader);
		return baseResponse;
	}

    @Override
    public AccountQueryResponse queryByPhone(AccountQueryRequest request)
            throws BusinessException, SystemException {
            // 入参检查
        iVoValidateSV.validateAccountPhone(request);
            // 数据库操作
       GnAccount gnAccount =  iAccountBusiSV.queryByPhone(request.getPhone());
           // 整理返回对象
       AccountQueryResponse response = new AccountQueryResponse();
       ResponseHeader responseHeader = new ResponseHeader();
       if (gnAccount != null) {
           BeanUtils.copyProperties(response, gnAccount);
           responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "数据查询成功");
       }else{
           responseHeader = new ResponseHeader(true, ResultCode.FAIL_CODE, "数据不存在");
       }
       response.setResponseHeader(responseHeader);
       return response;
    }

    @Override
    public AccountQueryResponse queryByEmail(AccountQueryRequest request)
            throws BusinessException, SystemException {
        iVoValidateSV.validateAccountEmail(request);
        GnAccount gnAccount =  iAccountBusiSV.queryByEmail(request.getEmail());
        AccountQueryResponse response = new AccountQueryResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if (gnAccount != null) {
            BeanUtils.copyProperties(response, gnAccount);
            responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "数据查询成功");
        }else{
            responseHeader = new ResponseHeader(true, ResultCode.FAIL_CODE, "数据不存在");
        }
        response.setResponseHeader(responseHeader);
        return response;
    }
}
