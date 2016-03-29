package com.ai.opt.uac.api.seq;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.uac.api.seq.interfaces.ICreateSeqSV;
import com.ai.opt.uac.api.seq.param.PhoneMsgSeqResponse;
import com.ai.opt.uac.constants.AccountConstants;
import com.ai.opt.uac.constants.AccountConstants.SEQ;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class CreateSeqSVImpl implements ICreateSeqSV {

	@Override
	public PhoneMsgSeqResponse createPhoneMsgSeq()throws SystemException {
		String newId = SeqUtil.getNewId(SEQ.PHONE_MSG_SEQ, 7);
		String dateString = DateUtil.getDateString("yyMMddHHmmss");
		PhoneMsgSeqResponse phoneMsgSeqResponse = new PhoneMsgSeqResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setIsSuccess(true);
		responseHeader.setResultCode(AccountConstants.ResultCode.SUCCESS_CODE);
		responseHeader.setResultMessage("创建MsgSeqId成功");
		phoneMsgSeqResponse.setResponseHeader(responseHeader );
		phoneMsgSeqResponse.setMsgSeqId(dateString+newId);
		return phoneMsgSeqResponse;
	}

}
