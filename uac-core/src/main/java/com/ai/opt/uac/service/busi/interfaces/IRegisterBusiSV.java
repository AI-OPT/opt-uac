package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;

public interface IRegisterBusiSV {
    long  registerByPhone(GnAccount account) throws BusinessException;
}
