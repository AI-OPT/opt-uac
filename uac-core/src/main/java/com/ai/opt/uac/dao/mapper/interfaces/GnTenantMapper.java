package com.ai.opt.uac.dao.mapper.interfaces;

import com.ai.opt.uac.dao.mapper.bo.GnTenant;
import com.ai.opt.uac.dao.mapper.bo.GnTenantCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GnTenantMapper {
    int countByExample(GnTenantCriteria example);

    int deleteByExample(GnTenantCriteria example);

    int deleteByPrimaryKey(String tenantId);

    int insert(GnTenant record);

    int insertSelective(GnTenant record);

    List<GnTenant> selectByExample(GnTenantCriteria example);

    GnTenant selectByPrimaryKey(String tenantId);

    int updateByExampleSelective(@Param("record") GnTenant record, @Param("example") GnTenantCriteria example);

    int updateByExample(@Param("record") GnTenant record, @Param("example") GnTenantCriteria example);

    int updateByPrimaryKeySelective(GnTenant record);

    int updateByPrimaryKey(GnTenant record);
}