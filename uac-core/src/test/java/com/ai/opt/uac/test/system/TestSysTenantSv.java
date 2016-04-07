package com.ai.opt.uac.test.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.uac.api.system.tenant.interfaces.ISysTenantManageSV;
import com.ai.opt.uac.api.system.tenant.param.QueryTenantRequest;
import com.ai.opt.uac.api.system.tenant.param.QueryTenantResponse;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestSysTenantSv {
    @Autowired
    ISysTenantManageSV iSysTenantManageSV;
    
    @Test
    public void testQueryBaseInfo() throws RPCSystemException{
       
        QueryTenantResponse tenantInfo = iSysTenantManageSV.queryTenantById("0D8A6A08352C4059A8CB91133E8B8D8E");
        System.out.println("result="+JSON.toJSONString(tenantInfo));
    }
    @Test
    public void testQueryPage() throws RPCSystemException{
        QueryTenantRequest request = new QueryTenantRequest();
        PageInfo<QueryTenantResponse> pa = new PageInfo<QueryTenantResponse>();
        pa.setPageSize(10);
        pa.setPageNo(1);
        request.setPageInfo(pa);
        request.setState("0");
        request.setTenantId("FCE0CDC1932041F8BDB6833580805634");
        //request.setTenantName("测试");
        PageInfo<QueryTenantResponse>  page= iSysTenantManageSV.queryTenantInfo(request);
        System.out.println("result="+JSON.toJSONString(page.getResult()));
    }
    @Test
    public void testUpdate() throws RPCSystemException{
        QueryTenantRequest request = new QueryTenantRequest();
        request.setTenantId("FCE0CDC1932041F8BDB6833580805634");
        request.setTenantName("coco");
        BaseResponse base= iSysTenantManageSV.updateTenantByTenant(request);
        System.out.println("result="+JSON.toJSONString(base));
    }
    
}
