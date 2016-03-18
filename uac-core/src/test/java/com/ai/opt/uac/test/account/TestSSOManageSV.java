package com.ai.opt.uac.test.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestSSOManageSV {

	@Autowired
	IRegisterSV iRegisterSV;
	
	@Test
	public void testQueryBaseInfo() throws BusinessException, SystemException{
		System.out.println("<<<<<<<<<<<<<<Begin testQueryBaseInfo>>>>>>>>>>>>>>");
		PhoneRegisterRequest request = new PhoneRegisterRequest();
		request.setPassword("123");
		request.setPhone("13289878898");
		
		PhoneRegisterResponse queryBaseInfo = iRegisterSV.registerByPhone(request);
		JSONObject fromObject = JSONObject.fromObject(queryBaseInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testQueryBaseInfo>>>>>>>>>>>>>>");
	}
}
