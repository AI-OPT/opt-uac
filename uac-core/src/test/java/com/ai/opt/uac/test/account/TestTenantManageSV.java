package com.ai.opt.uac.test.account;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.interfaces.ITenantManageSV;
import com.ai.opt.uac.api.account.param.TenantInfoRequest;
import com.ai.opt.uac.api.account.param.TenantInsertResponse;
import com.ai.opt.uac.api.account.param.TenantQueryResponse;
import com.ai.opt.uac.util.RegexUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestTenantManageSV {

	@Autowired
	ITenantManageSV iTenantManageSV;
	
	@Test
	public void testQueryBaseInfo() throws RPCSystemException{
		System.out.println("<<<<<<<<<<<<<<Begin testQueryBaseInfo>>>>>>>>>>>>>>");
		BaseInfo tenantRequest=new BaseInfo();
		tenantRequest.setTenantId("0001");
		TenantQueryResponse tenantInfo = iTenantManageSV.queryTenantInfo(tenantRequest);
		JSONObject fromObject = JSONObject.fromObject(tenantInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testQueryBaseInfo>>>>>>>>>>>>>>");
	}
	
	@Test
	public void insertTenantInfo() throws RPCSystemException{
		System.out.println("<<<<<<<<<<<<<<Begin insertTenantInfo>>>>>>>>>>>>>>");
		TenantInfoRequest tenantInfoRequest=new TenantInfoRequest();
		//tenantInfoRequest.setIndustryCode("001");
		tenantInfoRequest.setTenantName("test");
		tenantInfoRequest.setCreateAccountId(994L);
		//tenantInfoRequest.setUpdateAccountId(3L);
		TenantInsertResponse tenantInfo = iTenantManageSV.insertTenantInfo(tenantInfoRequest);
		JSONObject fromObject = JSONObject.fromObject(tenantInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End insertTenantInfo>>>>>>>>>>>>>>");
	}
	@Test
    public void updateTenantInfo() throws RPCSystemException{
        System.out.println("<<<<<<<<<<<<<<Begin insertTenantInfo>>>>>>>>>>>>>>");
        TenantInfoRequest tenantInfoRequest=new TenantInfoRequest();
        //tenantInfoRequest.setIndustryCode("001");
        //tenantInfoRequest.setTenantName("camilla");
        tenantInfoRequest.setTenantId("A4E07D5D2261460699A38A88260A32DA");
        tenantInfoRequest.setIndustryCode("01");
        tenantInfoRequest.setUpdateAccountId(3L);
        BaseResponse tenantInfo = iTenantManageSV.updateTenant(tenantInfoRequest);
        JSONObject fromObject = JSONObject.fromObject(tenantInfo);
        System.out.println(fromObject);
        System.out.println("<<<<<<<<<<<<<<End insertTenantInfo>>>>>>>>>>>>>>");
    }
	@Test
	public void testRegexUtil(){
		System.out.println("<<<<<<<<<<<<<<Begin testRegexUtil>>>>>>>>>>>>>>");
		String email = "testemail112@qq.cn";
		boolean checkIsEmail = RegexUtils.checkIsEmail(email);
		System.out.println(checkIsEmail);
		System.out.println("<<<<<<<<<<<<<<End testRegexUtil>>>>>>>>>>>>>>");
	}
}
