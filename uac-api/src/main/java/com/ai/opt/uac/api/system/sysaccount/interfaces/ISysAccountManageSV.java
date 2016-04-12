package com.ai.opt.uac.api.system.sysaccount.interfaces;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountDelRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;

public interface ISysAccountManageSV {
	/**
	 * 账户分页查询
	 * @param queryRequest
	 * @return
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_SYS_0004
	 */
	AccountPageQueryResponse queryAccountPageInfo(AccountPageQueryRequest queryRequest);
	
	/**
	 * 账户详情查询
	 * @param queryRequest
	 * @return
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_SYS_0005
	 */
	AccountInfoQueryResponse queryAccountInfo(AccountInfoQueryRequest queryRequest);
	
	/**
	 * 增加账户信息
	 * @param insertRequest
	 * @return
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_SYS_0006
	 */
	AccountInsertResponse insertAccountInfo(AccountInsertRequest insertRequest);
	
	/**
	 * 修改账户信息
	 * @param updateRequest
	 * @return
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_SYS_0007
	 */
	BaseResponse updateAccountInfo(AccountUpdateRequest updateRequest);
	
	/**
	 * 删除账户信息
	 * @param deleteRequest
	 * @return
	 * @author jiaxs
     * @ApiDocMethod
     * @ApiCode UAC_SYS_0008
	 */
	BaseResponse deletAccountInfo(AccountDelRequest deleteRequest);
}
