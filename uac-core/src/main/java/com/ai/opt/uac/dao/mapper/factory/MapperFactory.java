package com.ai.opt.uac.dao.mapper.factory;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.uac.dao.mapper.interfaces.GnAccountMapper;
import com.ai.opt.uac.dao.mapper.interfaces.GnIndustryMapper;
import com.ai.opt.uac.dao.mapper.interfaces.GnTenantMapper;

@Component
public class MapperFactory {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static SqlSessionTemplate st;

    @PostConstruct
    void init() {
        setSqlSessionTemplate(sqlSessionTemplate);
    }

    public static void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        MapperFactory.st = sqlSessionTemplate;
    }

    public static GnAccountMapper getGnAccountlMapper() {
        return st.getMapper(GnAccountMapper.class);
    }
    
    public static GnIndustryMapper getGnIndustryMapper() {
        return st.getMapper(GnIndustryMapper.class);
    }
    
    public static GnTenantMapper getGnTenantMapper() {
        return st.getMapper(GnTenantMapper.class);
    }
}
