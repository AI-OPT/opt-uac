package com.ai.opt.uac.api.seq.param;

import com.ai.opt.base.vo.BaseResponse;

public class PhoneMsgSeqResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;
	
	private String msgSeqId;

	public String getMsgSeqId() {
		return msgSeqId;
	}

	public void setMsgSeqId(String msgSeqId) {
		this.msgSeqId = msgSeqId;
	}

}
