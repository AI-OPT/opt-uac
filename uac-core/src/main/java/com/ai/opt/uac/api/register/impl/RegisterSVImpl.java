package com.ai.opt.uac.api.register.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.phoneRegisterRequest;
import com.ai.opt.uac.api.register.param.phoneRegisterResponse;
import com.ai.opt.uac.constants.AccountConstants;
import com.ai.opt.uac.constants.AccountConstants.ResultCode;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.service.busi.interfaces.IRegisterBusiSV;
import com.ai.opt.uac.util.VoValidateUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class RegisterSVImpl implements IRegisterSV {
    @Autowired
    private IRegisterBusiSV iRegisterBusiSV;

    @Override
    public phoneRegisterResponse registerByPhone(phoneRegisterRequest request)
            throws BusinessException, SystemException {
        VoValidateUtils.validateRegister(request);
        // 设置默认值
        GnAccount account = new GnAccount();
        BeanUtils.copyProperties(account, request);
        account.setAccountType(AccountConstants.Account.ACCOUNT_TYPE);
        account.setAccountLevel(AccountConstants.Account.ACCOUNT_LEVEL);
        account.setInactiveTime(DateUtil.getTimestamp(AccountConstants.Account.INACTIVE_DATE));
        account.setCreateTime(DateUtil.getSysDate());
        account.setTenantId(AccountConstants.Account.INIT_TENANT_ID);
        long accountId = iRegisterBusiSV.registerByPhone(account);
        phoneRegisterResponse response = new phoneRegisterResponse();
        ResponseHeader responseHeader = new ResponseHeader(true, ResultCode.SUCCESS_CODE, "成功");
        response.setAccountId(accountId);
        response.setResponseHeader(responseHeader);
        return response;
    }

}
