package com.weqilian.callback;

import android.util.Log;

public class DemoJavaScriptInterface {

	public DemoJavaScriptInterface() {
		// TODO Auto-generated constructor stub
	}
	
	public void clickOnAndroid(){
		Log.i("zzwang", "ClickOnAndroid do......");
	}
	
	public void getInfo(String info1,String info2){
		Log.i("zzwang", "getInfo do.....:" + info1 + "    info2:   "  +  info2);
	}
	
	public void submit(String json){
		Log.i("zzwang", "submit: "  + json);
	}
}
