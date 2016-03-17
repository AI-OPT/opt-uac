package com.ai.opt.uac.test.account;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.account.interfaces.IAccountManageSV;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountQueryResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestAccountManageSV {

	@Autowired
	IAccountManageSV iAccountManageSV;
	
	@Test
	public void testQueryBaseInfo() throws BusinessException, SystemException{
		System.out.println("<<<<<<<<<<<<<<Begin testQueryBaseInfo>>>>>>>>>>>>>>");
		AccountQueryRequest accountQueryRequest=new AccountQueryRequest();
		accountQueryRequest.setAccountId(1L);
		AccountQueryResponse queryBaseInfo = iAccountManageSV.queryBaseInfo(accountQueryRequest);
		JSONObject fromObject = JSONObject.fromObject(queryBaseInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testQueryBaseInfo>>>>>>>>>>>>>>");
	}
}
