package com.ai.opt.uac.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnIndustry;
import com.ai.opt.uac.service.atom.interfaces.IIndustryAtomSV;
import com.ai.opt.uac.service.busi.interfaces.IIndustryBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Transactional
public class IndustryBusiSVImpl implements IIndustryBusiSV {
	
	@Autowired
	IIndustryAtomSV iIndustryAtomSV;

	@Override
	public GnIndustry queryByIndustryCode(String industryCode) throws SystemException {
		return iIndustryAtomSV.queryByIndustryCode(industryCode);
	}

}
