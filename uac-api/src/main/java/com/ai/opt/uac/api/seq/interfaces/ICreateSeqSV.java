package com.ai.opt.uac.api.seq.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

public interface ICreateSeqSV {
	/**
	 * 获取短信信息seq
	 * @return
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0011
	 */
	String createPhoneMsgSeq() throws BusinessException,SystemException;
}
