package com.ai.opt.uac.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnIndustry;
import com.ai.opt.uac.dao.mapper.factory.MapperFactory;
import com.ai.opt.uac.dao.mapper.interfaces.GnIndustryMapper;
import com.ai.opt.uac.service.atom.interfaces.IIndustryAtomSV;

@Component
public class IndustryAtomSVImpl implements IIndustryAtomSV {

	@Override
	public GnIndustry queryByIndustryCode(String industryCode) throws SystemException {
		GnIndustryMapper gnIndustryMapper = MapperFactory.getGnIndustryMapper();
		return gnIndustryMapper.selectByPrimaryKey(industryCode);
	}

	@Override
	public List<GnIndustry> queryIndustryList() throws SystemException {
		GnIndustryMapper gnIndustryMapper = MapperFactory.getGnIndustryMapper();
		return gnIndustryMapper.selectByExample(null);
	}
}
