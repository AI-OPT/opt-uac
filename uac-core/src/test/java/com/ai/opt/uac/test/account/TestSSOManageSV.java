package com.ai.opt.uac.test.account;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.RPCSystemException;
import com.ai.opt.uac.api.account.interfaces.IIndustryManageSV;
import com.ai.opt.uac.api.account.param.IndustryQueryResponse;
import com.ai.opt.uac.api.register.interfaces.IRegisterSV;
import com.ai.opt.uac.api.register.param.PhoneRegisterRequest;
import com.ai.opt.uac.api.register.param.PhoneRegisterResponse;
import com.ai.opt.uac.api.security.interfaces.IAccountSecurityManageSV;
import com.ai.opt.uac.api.sso.interfaces.ILoginSV;
import com.ai.opt.uac.api.sso.param.UserLoginRequest;
import com.ai.opt.uac.api.sso.param.UserLoginResponse;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:context/core-context.xml")
@ContextConfiguration({ "/dubbo/provider/dubbo-provider.xml" })
public class TestSSOManageSV {

	@Autowired
	IRegisterSV iRegisterSV;
	@Autowired
	ILoginSV iLoginSV;
	@Autowired
    IAccountSecurityManageSV iAccountSecuritySV;
	@Autowired
	IIndustryManageSV iIndustryManageSV;
	
	@Test
	public void testRegister() throws RPCSystemException{
		PhoneRegisterRequest request = new PhoneRegisterRequest();
		request.setAccountPassword("202cb962ac59075b964b07152d234b10");
		request.setPhone("19098901278");
		request.setPhoneVerifyCode("7888");
		request.setPictureVerifyCode("jhkl");
		PhoneRegisterResponse info = iRegisterSV.registerByPhone(request);
		System.out.println("result="+JSON.toJSONString(info));
	}
	@Test
    public void testSSO() throws RPCSystemException{
        String name = "10898890911";
        UserLoginResponse info = iLoginSV.queryAccountByUserName(name);
        System.out.println("result="+JSON.toJSONString(info));
    }
	@Test
    public void testLoginCheck() throws RPCSystemException{
        String name = "13489898871";
        UserLoginRequest request = new UserLoginRequest();
        request.setUsername("13489898871");
        request.setAccountPassword("202cb962ac59075b964b07152d234b10");
        boolean flag = iLoginSV.checkAccountByUserName(request);
        System.out.println("result="+JSON.toJSONString(flag));
    }
	@Test
    public void testQueyOneIndutry() throws RPCSystemException{
	    IndustryQueryResponse response= iIndustryManageSV.queryByIndustryCode("05");
        System.out.println("result="+JSON.toJSONString(response));
    }
	@Test
    public void testQueyOneIndutryList() throws RPCSystemException{
       List<IndustryQueryResponse> list= iIndustryManageSV.queryIndustryList();
        System.out.println("result="+JSON.toJSONString(list));
    }
}
