package com.ai.opt.uac.api.security.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;

public interface IAccountSecurityManageSV {
	
	/**
	 * 设置邮箱
	 * @param emailModifyRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0007
	 */
	BaseResponse setEmailData(AccountEmailRequest emailModifyRequest) throws RPCSystemException;
	
	/**
	 * 设置密码
	 * @param emailModifyRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0008
	 */
	BaseResponse setPasswordData(AccountPasswordRequest passwordModifyRequest) throws RPCSystemException;
	
	/**
	 * 设置手机号
	 * @param phoneModifyRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_0009
	 */
	BaseResponse setPhoneData(AccountPhoneRequest phoneModifyRequest) throws RPCSystemException;
}
