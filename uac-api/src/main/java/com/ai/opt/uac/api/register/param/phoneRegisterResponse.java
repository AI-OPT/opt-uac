package com.ai.opt.uac.api.register.param;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 注册返回参数 <br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class phoneRegisterResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 账号ID
     */
    private long accountId;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

}
