package com.ai.opt.uac.test.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;
import com.ai.opt.uac.api.security.interfaces.IAccountSecurityManageSV;
import com.ai.opt.uac.api.security.param.AccountPasswordRequest;
import com.ai.opt.uac.api.security.param.AccountPhoneRequest;
import com.ai.opt.uac.api.sso.interfaces.ILoginSV;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.api.sso.param.UserLoginResponse;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class TestSSOManageSV {

	@Autowired
	IRegisterSV iRegisterSV;
	@Autowired
	ILoginSV iLoginSV;
	@Autowired
    IAccountSecurityManageSV iAccountSecuritySV;
	@Test
	public void testRegister() throws RPCSystemException{
		PhoneRegisterRequest request = new PhoneRegisterRequest();
		request.setAccountPassword("202cb962ac59075b964b07152d234b7");
		request.setPhone("13489898878%$$");
		PhoneRegisterResponse info = iRegisterSV.registerByPhone(request);
		System.out.println("result="+JSON.toJSONString(info));
	}
	@Test
    public void testSSO() throws RPCSystemException{
        UserLoginRequest request = new UserLoginRequest();
        request.setAccountPassword("123");
        request.setUsername("13489898878");
        UserLoginResponse info = iLoginSV.queryAccountByUserName(request);
        System.out.println("result="+JSON.toJSONString(info));
    }
	@Test
    public void testSetPaswordData() throws RPCSystemException {
        System.out.println("<<<<<<<<<<<<<<Begin testSetPaswordData>>>>>>>>>>>>>>");
        AccountPasswordRequest passwordModifyRequest=new AccountPasswordRequest();
        passwordModifyRequest.setAccountId(1L);
        passwordModifyRequest.setAccountPassword("3432");
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
        phoneModifyRequest.setPhone("13290989889");
        //phoneModifyRequest.setUpdateAccountId(1L);
        BaseResponse setPWDData = iAccountSecuritySV.setPhoneData(phoneModifyRequest);
        JSONObject fromObject = JSONObject.fromObject(setPWDData);
        System.out.println(fromObject);
        System.out.println("<<<<<<<<<<<<<<End testSetPhoneData>>>>>>>>>>>>>>");
    }
}
