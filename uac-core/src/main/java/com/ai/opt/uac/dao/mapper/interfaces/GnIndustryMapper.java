package com.ai.opt.uac.dao.mapper.interfaces;

import com.ai.opt.uac.dao.mapper.bo.GnIndustry;
import com.ai.opt.uac.dao.mapper.bo.GnIndustryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GnIndustryMapper {
    int countByExample(GnIndustryCriteria example);

    int deleteByExample(GnIndustryCriteria example);

    int deleteByPrimaryKey(String industryCode);

    int insert(GnIndustry record);

    int insertSelective(GnIndustry record);

    List<GnIndustry> selectByExample(GnIndustryCriteria example);

    GnIndustry selectByPrimaryKey(String industryCode);

    int updateByExampleSelective(@Param("record") GnIndustry record, @Param("example") GnIndustryCriteria example);

    int updateByExample(@Param("record") GnIndustry record, @Param("example") GnIndustryCriteria example);

    int updateByPrimaryKeySelective(GnIndustry record);

    int updateByPrimaryKey(GnIndustry record);
}