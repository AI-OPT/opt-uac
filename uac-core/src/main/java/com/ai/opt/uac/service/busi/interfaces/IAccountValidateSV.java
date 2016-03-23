package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;

public interface IAccountValidateSV {
    void checkNickName(String nickName) throws BusinessException;

    void checkAccountId(Long accountId) throws BusinessException;

    void checkUpdateAccountId(Long updateAccountId) throws BusinessException;

    void checkPhone(String phone, boolean checkOnly) throws BusinessException;

    void checkAccountPassword(String accountPassword) throws BusinessException;

    void checkUserName(String userName) throws BusinessException;

    void checkEmail(String email, boolean checkOnly) throws BusinessException;

    void checkPhoneVerifyCode(String phoneVerifyCode) throws BusinessException;

    void checkPictureVerifyCode(String pictureVerifyCode) throws BusinessException;

}
