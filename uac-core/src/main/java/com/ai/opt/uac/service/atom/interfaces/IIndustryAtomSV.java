package com.ai.opt.uac.service.atom.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnIndustry;

public interface IIndustryAtomSV {
	GnIndustry queryByIndustryCode(String industryCode) throws SystemException;
}
