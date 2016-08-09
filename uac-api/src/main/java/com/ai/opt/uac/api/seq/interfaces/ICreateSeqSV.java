package com.ai.opt.uac.api.seq.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.seq.param.PhoneMsgSeqResponse;

@Path("/createseq")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface ICreateSeqSV {

	/**
     * 获取短信信息seq
     * @return	PhoneMsgSeqResponse
     * @throws BusinessException
     * @throws SystemException
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL createseq/createPhoneMsgSeq
     */
    @GET
    @Path("/createPhoneMsgSeq")
	PhoneMsgSeqResponse createPhoneMsgSeq() throws BusinessException,SystemException;
}
