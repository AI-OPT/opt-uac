package com.ai.opt.uac.api.security.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;

public interface IAccountSecurityManageSV {
	
	/**
	 * ��������
	 * @param emailModifyRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0008
	 */
	BaseResponse setEmailData(AccountEmailRequest emailModifyRequest) throws BusinessException,SystemException;
	
	/**
	 * ��������
	 * @param emailModifyRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0009
	 */
	BaseResponse setPasswordData(AccountPasswordRequest passwordModifyRequest) throws BusinessException,SystemException;
	
	/**
	 * �����ֻ���
	 * @param phoneModifyRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_
	 */
	BaseResponse setPhoneData(AccountPhoneRequest phoneModifyRequest) throws BusinessException,SystemException;
}
