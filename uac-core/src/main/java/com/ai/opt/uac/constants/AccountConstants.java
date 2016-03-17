package com.ai.opt.uac.constants;

/**
 * 账户体系常量类 Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public final class AccountConstants {

    private AccountConstants() {

    }

    public final static class SEQ {
        private SEQ() {
        }

        public static final String ACCOUT_ID_SEQ = "GN_ACCOUNT$ACCOUNT_ID$SEQ";

    }

    public final static class Account {
        private Account() {
        }

        /** 账号类型 */
        public static final String ACCOUNT_TYPE = "1";

        /** 账号级别 */
        public static final String ACCOUNT_LEVEL = "1";

        /** 账号状态 */
        public static final String ACCOUNT_STATE = "1";

        /*** 失效时间 */
        public static final String INACTIVE_DATE = "2099-12-31";

        /** 初始租户ID值 */
        public static final String INIT_TENANT_ID = "0";

    }

}
