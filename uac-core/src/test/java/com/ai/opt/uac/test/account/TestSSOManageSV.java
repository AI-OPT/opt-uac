package com.ai.opt.uac.test.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;
import com.ai.opt.uac.api.security.interfaces.IAccountSecurityManageSV;
import com.ai.opt.uac.api.sso.interfaces.ILoginSV;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.api.sso.param.UserLoginResponse;
import com.alibaba.fastjson.JSON;

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
		request.setAccountPassword("202cb962ac59075b964b07152d234b10");
		request.setPhone("13489898871");
		request.setPhoneVerifyCode("7888");
		request.setPictureVerifyCode("jhkl");
		PhoneRegisterResponse info = iRegisterSV.registerByPhone(request);
		System.out.println("result="+JSON.toJSONString(info));
	}
	@Test
    public void testSSO() throws RPCSystemException{
        UserLoginRequest request = new UserLoginRequest();
        request.setAccountPassword("202cb962ac59075b964b07152d234b10");
        request.setUsername("XXXXteXst.com");
        UserLoginResponse info = iLoginSV.queryAccountByUserName(request);
        System.out.println("result="+JSON.toJSONString(info));
    }
	
}
