package com.ai.opt.uac.api.sso.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 登录返回参数 <br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public class UserLoginResponse extends BaseResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 账号ID
     */
    private long accountId;

    /**
     * 账号名
     */
    private String accountName;

    /**
     * 密码
     */
    private String accountPassword;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账号状态
     */
    private String state;

    /**
     * 生效时间
     */
    private Timestamp activeTime;

    /**
     * 失效时间
     */
    private Timestamp inactiveTime;

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getActiveTime() {
        return activeTime == null ? null : (Timestamp) activeTime.clone();
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = (activeTime == null ? null : (Timestamp) activeTime.clone());
    }

    public Timestamp getInactiveTime() {
        return inactiveTime == null ? null : (Timestamp) inactiveTime.clone();
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = (inactiveTime == null ? null : (Timestamp) inactiveTime.clone());
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
