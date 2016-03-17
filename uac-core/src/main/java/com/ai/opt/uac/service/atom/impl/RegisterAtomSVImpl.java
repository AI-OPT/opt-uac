package com.ai.opt.uac.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnAccountMapper;
import com.ai.opt.uac.service.atom.interfaces.IRegisterAtomSV;
@Component
public class RegisterAtomSVImpl implements IRegisterAtomSV {

    @Override
    public long registerByPhone(GnAccount account) {
        GnAccountMapper mapper = MapperFactory.getGnAccountlMapper();
        return mapper.insert(account);
    }

}
