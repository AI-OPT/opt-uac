package com.ai.opt.uac.util;

import com.ai.opt.sdk.sequence.util.SeqUtil;
import com.ai.opt.uac.constants.AccountConstants.SEQ;

/**
 * 生成账号Id
 * Date: 2016年3月17日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public final class AccountSeqUtil {

    private AccountSeqUtil() {
    }

    /**
     * 生成账号ID
     *
     * @return
     * @author zhanglh
     * @ApiCode
     */
    public static long createAccountId() {
        return SeqUtil.getNewId(SEQ.ACCOUT_ID_SEQ);

    }
}
