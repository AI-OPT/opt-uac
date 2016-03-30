package com.ai.opt.uac.api.industry.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.uac.api.account.interfaces.IIndustryManageSV;
import com.ai.opt.uac.api.account.param.IndustryQueryResponse;
import com.ai.opt.uac.dao.mapper.bo.GnIndustry;
import com.ai.opt.uac.service.busi.interfaces.IIndustryBusiSV;
import com.ai.opt.uac.service.busi.interfaces.IVoValidateSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class IndustryManageSVImpl implements IIndustryManageSV {
    @Autowired
    private IIndustryBusiSV iIndustryBusiSV;

    @Autowired
    IVoValidateSV iVoValidateSV;

    @Override
    public List<IndustryQueryResponse> queryIndustryList()
            throws BusinessException, SystemException {
        List<GnIndustry> list = iIndustryBusiSV.queryIndustryList();
        List<IndustryQueryResponse> responseList = null;
        if (!CollectionUtil.isEmpty(list)) {
            responseList = new ArrayList<IndustryQueryResponse>();
            for (GnIndustry indutry : list) {
                IndustryQueryResponse info = new IndustryQueryResponse();
                BeanUtils.copyProperties(info, indutry);
                responseList.add(info);
            }
        }
        return responseList;
    }

    @Override
    public IndustryQueryResponse queryByIndustryCode(String code)
            throws BusinessException, SystemException {
        // 入参检查
        iVoValidateSV.validateQueyIndustry(code);
        GnIndustry industry = iIndustryBusiSV.queryByIndustryCode(code);
        IndustryQueryResponse response = new IndustryQueryResponse();
        if (industry != null) {
            BeanUtils.copyProperties(response, industry);
        }

        return response;
    }

}
