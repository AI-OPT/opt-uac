package com.ai.opt.uac.service.busi.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;

public interface ILoginBusiSV {
    GnAccount queryByUserName(GnAccount account) throws BusinessException;

}
