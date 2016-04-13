package com.ai.opt.uac.test.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.system.sysaccount.interfaces.ISysAccountManageSV;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInfoQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountInsertResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryRequest;
import com.ai.opt.uac.api.system.sysaccount.param.AccountPageQueryResponse;
import com.ai.opt.uac.api.system.sysaccount.param.AccountUpdateRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestSysAccountSv {
    @Autowired
    ISysAccountManageSV iAccountManageSV;
    
    @Test
    public void testQueryBaseInfo() throws RPCSystemException{
		AccountInfoQueryRequest queryRequest=new AccountInfoQueryRequest();
		queryRequest.setAccountId(1L);
		AccountInfoQueryResponse tenantInfo = iAccountManageSV.queryAccountInfo(queryRequest);
        System.out.println("result="+JSON.toJSONString(tenantInfo));
    }
    @Test
    public void testQueryPage() throws RPCSystemException{
        AccountPageQueryRequest queryRequest = new AccountPageQueryRequest();
        queryRequest.setPageNo(1);
        queryRequest.setPageSize(10);
        queryRequest.setUserName("1326949");
        AccountPageQueryResponse  page= iAccountManageSV.queryAccountPageInfo(queryRequest);
        System.out.println(page.getPageInfo().getCount());
        System.out.println("result="+JSON.toJSONString(page.getPageInfo().getResult()));
    }
    @Test
    public void testUpdate() throws RPCSystemException{
        AccountUpdateRequest updateRequest = new AccountUpdateRequest();
        updateRequest.setAccountId(1L);
        updateRequest.setEmail("1120235906@qq.com");
        updateRequest.setUpdateAccountId(1L);
		BaseResponse base= iAccountManageSV.updateAccountInfo(updateRequest);
        System.out.println("result="+JSON.toJSONString(base));
    }
    
    @Test
    public void testInsert() throws RPCSystemException{
		AccountInsertRequest insertRequest=new AccountInsertRequest();
		insertRequest.setPhone("13269491580");
		insertRequest.setAccountLevel("1");
		insertRequest.setAccountType("01");
		insertRequest.setTenantId("1");
		insertRequest.setCreateAccountId(1L);
		AccountInsertResponse base= iAccountManageSV.insertAccountInfo(insertRequest);
		System.out.println("result="+JSON.toJSONString(base));
    }
    
}
