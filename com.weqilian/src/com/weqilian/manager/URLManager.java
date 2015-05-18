package com.weqilian.manager;

public class URLManager {
	
	/**
	 * 登录请求接口
	 * @return
	 */
	public static final String getSignUrl(){
		return "http://api.ssql.com.cn/cgi-bin/login/sign.html";
	}
	
	/**
	 * 短信验证码接口
	 * @return
	 */
	public static final String getSmsServiceUrl(){
		return "http://api.ssql.com.cn/cgi-bin/asmx/smsservice.html";
	}
	
	/**
	 * 注册接口
	 * @return
	 */
	public static final String getRegisterUrl(){
		return "http://api.ssql.com.cn/cgi-bin/register/create.html";
	}

}
