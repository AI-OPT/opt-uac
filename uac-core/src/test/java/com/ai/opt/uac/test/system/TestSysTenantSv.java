package com.ai.opt.uac.test.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.system.systenant.interfaces.ISysTenantManageSV;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantRequest;
import com.ai.opt.uac.api.system.systenant.param.QueryPageTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.QueryTenantResponse;
import com.ai.opt.uac.api.system.systenant.param.UpdateTenantRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestSysTenantSv {
    @Autowired
    ISysTenantManageSV iSysTenantManageSV;
    
    @Test
    public void testQueryBaseInfo() throws RPCSystemException{
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setTenantId("0D8A6A08352C4059A8CB91133E8B8D8E");
		QueryTenantResponse tenantInfo = iSysTenantManageSV.queryTenantById(baseInfo );
        System.out.println("result="+JSON.toJSONString(tenantInfo));
    }
    @Test
    public void testQueryPage() throws RPCSystemException{
        QueryPageTenantRequest request = new QueryPageTenantRequest();
        request.setPageSize(10);
        request.setPageNo(1);
        request.setState("0");
        request.setTenantId("FCE0CDC1932041F8BDB6833580805634");
        //request.setTenantName("测试");
        QueryPageTenantResponse  page= iSysTenantManageSV.queryTenantPageInfo(request);
        System.out.println("result="+JSON.toJSONString(page.getPageInfo().getResult()));
    }
    @Test
    public void testUpdate() throws RPCSystemException{
        UpdateTenantRequest request = new UpdateTenantRequest();
        request.setTenantId("FCE0CDC1932041F8BDB6833580805634");
        request.setTenantName("coco");
        request.setUpdateAccountId(1L);
        BaseResponse base= iSysTenantManageSV.updateByTenantId(request);
        System.out.println("result="+JSON.toJSONString(base));
    }
    
}
