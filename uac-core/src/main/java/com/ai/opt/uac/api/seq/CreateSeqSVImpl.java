package com.ai.opt.uac.api.seq;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.seq.interfaces.ICreateSeqSV;
import com.ai.opt.uac.constants.AccountConstants.SEQ;

@Component
public class CreateSeqSVImpl implements ICreateSeqSV {

	@Override
	public String createPhoneMsgSeq() {
		String newId = SeqUtil.getNewId(SEQ.PHONE_MSG_SEQ, 8);
		String dateString = DateUtil.getDateString("yyMMddHHmmss");
		return dateString+newId;
	}

}
