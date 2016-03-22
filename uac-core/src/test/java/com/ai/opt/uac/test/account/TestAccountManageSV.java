package com.ai.opt.uac.test.account;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.account.interfaces.IAccountManageSV;
import com.ai.opt.uac.api.account.param.AccountBaseModifyRequest;
import com.ai.opt.uac.api.account.param.AccountQueryRequest;
import com.ai.opt.uac.api.account.param.AccountQueryResponse;
import com.ai.opt.uac.api.security.interfaces.IAccountSecurityManageSV;
import com.ai.opt.uac.api.security.param.AccountEmailRequest;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestAccountManageSV {

	@Autowired
	IAccountManageSV iAccountManageSV;
	@Autowired
	IAccountSecurityManageSV iAccountSecuritySV;
	
	@Test
	public void testQueryBaseInfo() throws RPCSystemException{
		System.out.println("<<<<<<<<<<<<<<Begin testQueryBaseInfo>>>>>>>>>>>>>>");
		AccountQueryRequest accountQueryRequest=new AccountQueryRequest();
		accountQueryRequest.setAccountId(1L);
		AccountQueryResponse queryBaseInfo = iAccountManageSV.queryBaseInfo(accountQueryRequest);
		JSONObject fromObject = JSONObject.fromObject(queryBaseInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testQueryBaseInfo>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testUpdateBaseInfo() throws RPCSystemException{
		System.out.println("<<<<<<<<<<<<<<Begin testUpdateBaseInfo>>>>>>>>>>>>>>");
		AccountBaseModifyRequest accountModifyRequest=new AccountBaseModifyRequest();
		accountModifyRequest.setAccountId(1L);
		accountModifyRequest.setNickName("测试猿在测试");
		accountModifyRequest.setUpdateAccountId(1L);
		BaseResponse updateBaseInfo = iAccountManageSV.updateBaseInfo(accountModifyRequest);
		JSONObject fromObject = JSONObject.fromObject(updateBaseInfo);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testUpdateBaseInfo>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testSetEmailData() throws RPCSystemException {
		System.out.println("<<<<<<<<<<<<<<Begin testSetEmailData>>>>>>>>>>>>>>");
		AccountEmailRequest emailModifyRequest=new AccountEmailRequest();
		emailModifyRequest.setAccountId(1L);
		emailModifyRequest.setEmail("XXX@email.com");
		emailModifyRequest.setUpdateAccountId(1L);
		BaseResponse setEmailData = iAccountSecuritySV.setEmailData(emailModifyRequest);
		JSONObject fromObject = JSONObject.fromObject(setEmailData);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testSetEmailData>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testSetPaswordData() throws RPCSystemException {
		System.out.println("<<<<<<<<<<<<<<Begin testSetPaswordData>>>>>>>>>>>>>>");
		AccountPasswordRequest passwordModifyRequest=new AccountPasswordRequest();
		passwordModifyRequest.setAccountId(1L);
		passwordModifyRequest.setAccountPassword("112233441");
		passwordModifyRequest.setUpdateAccountId(2L);
		BaseResponse setPWDData = iAccountSecuritySV.setPasswordData(passwordModifyRequest);
		JSONObject fromObject = JSONObject.fromObject(setPWDData);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testSetPaswordData>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testSetPhoneData() throws RPCSystemException {
		System.out.println("<<<<<<<<<<<<<<Begin testSetPhoneData>>>>>>>>>>>>>>");
		AccountPhoneRequest phoneModifyRequest=new AccountPhoneRequest();
		phoneModifyRequest.setAccountId(1L);
		phoneModifyRequest.setPhone("18011223344");
		phoneModifyRequest.setUpdateAccountId(1L);
		BaseResponse setPWDData = iAccountSecuritySV.setPhoneData(phoneModifyRequest);
		JSONObject fromObject = JSONObject.fromObject(setPWDData);
		System.out.println(fromObject);
		System.out.println("<<<<<<<<<<<<<<End testSetPhoneData>>>>>>>>>>>>>>");
	}
}
