package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.opt.uac.constants.AccountExceptCode;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IAccountValidateSV;
import com.ai.opt.uac.util.RegexUtils;

@Component
public class AccountValidateSVImpl implements IAccountValidateSV {
	@Autowired
	IRegisterAtomSV iRegisterAtomSV;
	

	/** 昵称最大长度 */
	public static final int NICKNAME_MAXSIZE = 20;
    
    /** 昵称最小长度 */
    public static final int NICKNAME_MINSIZE = 4;
    
    /** 邮箱最大长度 */
    public static final int EMAIL_MAXSIZE = 50;

	@Override
	public void checkNickName(String nickName) throws BusinessException {
		if (StringUtil.isBlank(nickName)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "昵称（nickName）不能为空");
		}
		if (nickName.contains("\u0020")) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "昵称（nickName）不能包含空格");
		}
		int nameSize = StringUtil.getByteLength(nickName);
		if (nameSize < NICKNAME_MINSIZE || nameSize > NICKNAME_MAXSIZE) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "昵称（nickName）长度在" + NICKNAME_MINSIZE + "~" + NICKNAME_MAXSIZE + "个字符，不能包含空格");
		}
	}

	@Override
	public void checkUpdateAccountId(Long updateAccountId) throws BusinessException {
		if (updateAccountId == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "修改人ID（updateAccountId）不能为空");
		}
	}

	@Override
	public void checkAccountId(Long accountId) throws BusinessException {
		if (accountId == null) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "账号ID（accountId）不能为空");
		}
	}

	@Override
	public void checkPhone(String phone, boolean checkOnly) throws BusinessException {
		if (StringUtil.isBlank(phone)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "手机号码不能为空");
		}
		if (!RegexUtils.checkNumberPhone(phone)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码格式不正确");
		}
		if (!RegexUtils.checkPhoneLength(phone)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码长度不正确");
		}
		if (!RegexUtils.checkIsPhone(phone)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号码格式不正确");
		}
		// 判断手机号码是否唯一
		if (checkOnly) {
			int count = iRegisterAtomSV.getCountByPhone(phone);
			if (count >= 1) {
				throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "该手机已经进行过注册，请重新输入");
			}
		}
	}

	@Override
	public void checkAccountPassword(String accountPassword) throws BusinessException {
		if (StringUtil.isBlank(accountPassword)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "密码不能为空");
		}
		if (!RegexUtils.checkPassword(accountPassword)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "密码格式不正确");
		}
		if (!RegexUtils.checkPasswordLength(accountPassword)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "密码长度不正确，应为32个字符");
		}
	}

	@Override
	public void checkUserName(String userName) throws BusinessException {
		if (StringUtil.isBlank(userName)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "用户名不能为空");
		}
	}

	@Override
	public void checkEmail(String email, boolean checkOnly) throws BusinessException {
		if (StringUtil.isBlank(email)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "邮箱（email）不能为空");
		}
		if (!RegexUtils.checkIsEmail(email)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "邮箱（email）格式错误");
		}
		int emailSize = StringUtil.getByteLength(email);
		if(emailSize > EMAIL_MAXSIZE){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "邮箱（email）长度不应大于"+EMAIL_MAXSIZE+"个字符");
		}
		// 判断手机号码是否唯一
		if (checkOnly) {
			int count = iRegisterAtomSV.getCountByEmail(email);
			if (count >= 1) {
				throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "该邮箱已注册，请重新输入");
			}
		}
	}

	@Override
	public void checkPhoneVerifyCode(String phoneVerifyCode) throws BusinessException {
		if (StringUtil.isBlank(phoneVerifyCode)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "手机验证码不能为空");
		}
	}

	@Override
	public void checkPictureVerifyCode(String pictureVerifyCode) throws BusinessException {
		if (StringUtil.isBlank(pictureVerifyCode)) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "图片验证码不能为空");
		}
	}

   

}
