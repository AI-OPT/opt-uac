package com.ai.opt.uac.api.register.param;

import java.io.Serializable;

/**
 * 用户注册元素 <br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class PhoneRegisterRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 手机号码，必填
     */
    private String phone;

    /**
     * 密码，必填
     */
    private String accountPassword;

    /**
     * 手机验证码，必填
     */
    private String phoneVerifyCode;

    /**
     * 图片验证码，必填
     */
    private String pictureVerifyCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getPhoneVerifyCode() {
        return phoneVerifyCode;
    }

    public void setPhoneVerifyCode(String phoneVerifyCode) {
        this.phoneVerifyCode = phoneVerifyCode;
    }

    public String getPictureVerifyCode() {
        return pictureVerifyCode;
    }

    public void setPictureVerifyCode(String pictureVerifyCode) {
        this.pictureVerifyCode = pictureVerifyCode;
    }

}
