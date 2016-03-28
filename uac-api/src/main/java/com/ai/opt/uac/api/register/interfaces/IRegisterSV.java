package com.ai.opt.uac.api.register.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;

/**
 * 注册服务<br>
 * Date: 2016年3月16日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author zhanglh
 */
public interface IRegisterSV {

    /**
     * 用户注册 Date: 2016年3月25日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author zhanglh
     * @ApiCode UAC_0001
     */
    @interface RegisterByPhone {}
    PhoneRegisterResponse registerByPhone(PhoneRegisterRequest request) throws BusinessException,SystemException;

}
