package com.ai.opt.uac.api.sso.param;

import java.io.Serializable;

/**
 * 登录请求参数 <br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class userLoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名，必填
     */
    private String userName;

    /**
     * 密码，必填
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
