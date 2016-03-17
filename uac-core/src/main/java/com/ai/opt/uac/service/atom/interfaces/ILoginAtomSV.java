package com.ai.opt.uac.service.atom.interfaces;

import com.ai.opt.uac.dao.mapper.bo.GnAccount;

public interface ILoginAtomSV {
    GnAccount queryByUserName(GnAccount account);

}
