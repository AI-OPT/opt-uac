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
    private String username;

    /**
     * 密码，必填
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
