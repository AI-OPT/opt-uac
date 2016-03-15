package com.ai.opt.uac.dao.mapper.interfaces;

import com.ai.opt.uac.dao.mapper.bo.GnAccount;
import com.ai.opt.uac.dao.mapper.bo.GnAccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GnAccountMapper {
    int countByExample(GnAccountCriteria example);

    int deleteByExample(GnAccountCriteria example);

    int deleteByPrimaryKey(Long accountId);

    int insert(GnAccount record);

    int insertSelective(GnAccount record);

    List<GnAccount> selectByExample(GnAccountCriteria example);

    GnAccount selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") GnAccount record, @Param("example") GnAccountCriteria example);

    int updateByExample(@Param("record") GnAccount record, @Param("example") GnAccountCriteria example);

    int updateByPrimaryKeySelective(GnAccount record);

    int updateByPrimaryKey(GnAccount record);
}