package com.weqilian.manager;

public class URLManager {
	
	/**
	 * ��¼����ӿ�
	 * @return
	 */
	public static final String getSignUrl(){
		return "http://api.ssql.com.cn/cgi-bin/login/sign.html";
	}
	
	/**
	 * ������֤��ӿ�
	 * @return
	 */
	public static final String getSmsServiceUrl(){
		return "http://api.ssql.com.cn/cgi-bin/asmx/smsservice.html";
	}
	
	/**
	 * ע��ӿ�
	 * @return
	 */
	public static final String getRegisterUrl(){
		return "http://api.ssql.com.cn/cgi-bin/register/create.html";
	}

}
