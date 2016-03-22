package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.constants.AccountConstants.Tenant;
import com.ai.opt.uac.constants.AccountExceptCode;
import com.ai.opt.uac.dao.mapper.bo.GnIndustry;
import com.ai.opt.uac.service.busi.interfaces.IIndustryBusiSV;
import com.ai.opt.uac.service.busi.interfaces.ITenantValidateSV;
import com.ai.opt.uac.util.RegexUtils;

@Component
public class TenantValidateSVImpl implements ITenantValidateSV {
	
	@Autowired
	IIndustryBusiSV industryBusiSV;

	/** * tenantId长度 */
	public static final int TENANTID_MAXSIZE = 32;
	/** * tenantName最大长度 */
	public static final int TENANTNAME_MAXSIZE = 40;
	/** * tenantName最小长度 */
	public static final int TENANTNAME_MINSIZE = 4;
	/** * INDUSTRYCODE最大长度 */
	public static final int INDUSTRYCODE_MAXSIZE = 50;

	@Override
	public void checkTenantName(String tenantName) throws BusinessException {
		if (StringUtil.isBlank(tenantName)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "企业名称（tenantName）不能为空");
		}
		if (RegexUtils.checkHasSpecialChar(tenantName)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "企业名称（tenantName）不能含有特殊字符");
		}
		if (tenantName.contains("\u0020")) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "企业名称（tenantName）不能包含空格");
		}
		int tenantNameSize = tenantName.length();
		if (tenantNameSize < TENANTNAME_MINSIZE || tenantNameSize > TENANTNAME_MAXSIZE) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "企业名称（tenantName）长度为" + Tenant.TENANTNAME_MINSIZE + "~" + Tenant.TENANTNAME_MAXSIZE + "位字符");
		}
	}

	@Override
	public void checkIndustryCode(String industryCode) throws BusinessException {
		if (StringUtil.isBlank(industryCode)) {
            throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR,
                    "企业类型（industryCode）不能为空");
        }
		if(industryCode.length()>INDUSTRYCODE_MAXSIZE){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "企业类型（industryCode）长度不能大于"+INDUSTRYCODE_MAXSIZE);
		}
		GnIndustry gnIndustry = industryBusiSV.queryByIndustryCode(industryCode);
		if(gnIndustry == null || StringUtil.isBlank(gnIndustry.getIndustryName())){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR,
                    "企业类型（industryCode）未配置");
		}
	}

	@Override
	public void checkAccountId(Long accountId) throws BusinessException {
		if (accountId == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "账号ID（accountId）不能为空");
		}
	}

	@Override
	public void checkUpdateAccountId(Long updateAccountId) throws BusinessException {
		if (updateAccountId == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "修改人ID（updateAccountId）不能为空");
		}
	}

	@Override
	public void checkTenantId(String tenantId) throws BusinessException {
		if (StringUtil.isBlank(tenantId)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "租户ID（tenantId）不能为空");
		}
		// 参数规则检查
		if (tenantId.length() > TENANTID_MAXSIZE) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "租户ID（tenantId）长度不能超过" + Tenant.TENANTID_MAXSIZE);
		}
	}
}
