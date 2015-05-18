package com.weqilian.ui;

import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.volley.Request.Method;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.weqilian.R;
import com.weqilian.manager.URLManager;

public class SplashActivity extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initView();
//		requestLogin();	
		requestGetSms();
//		requestRegister();
	}

	private void requestRegister() {
		// TODO Auto-generated method stub
		
	}

	private void requestGetSms() {

		JSONObject jsonObj = new JSONObject();
		JSONObject obj = new JSONObject();
		try {
			jsonObj.put("mobile", "14705607978");
			obj.put("smsservice", jsonObj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonRequest<JSONObject>  jsonRequest = new JsonObjectRequest(Method.POST, URLManager.getSmsServiceUrl(), obj, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				
				Log.i("zzwang", "   id: " + Thread.currentThread().getId() +"   onResponse:  " + arg0.toString());
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				Log.i("zzwang", "onErrorResponse:  " + error.getMessage());
			}
		}){
			@Override
			protected Response<JSONObject> parseNetworkResponse(
					NetworkResponse response) {
				// TODO Auto-generated method stub
				return super.parseNetworkResponse(response);
			}
		};
		
		RequestQueue queue = Volley.newRequestQueue(this);
		queue.add(jsonRequest);
	
		
	}

	private void requestLogin() {
		// TODO Auto-generated method stub
		JSONObject jsonObj = new JSONObject();
		JSONObject obj = new JSONObject();
		try {
			jsonObj.put("mobile", "18656132832");  
			jsonObj.put("password", "234200"); 
			obj.put("sign", jsonObj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("zzwang11111111", e.getMessage());
		}
		JsonRequest<JSONObject>  jsonRequest = new JsonObjectRequest(Method.POST, URLManager.getSignUrl(), obj, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject arg0) {
				// TODO Auto-generated method stub
				
				Log.i("zzwang", "   id: " + Thread.currentThread().getId() +"   onResponse:  " + arg0.toString());
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				Log.i("zzwang", "onErrorResponse:  " + error.getMessage());
			}
		}){
			@Override
			protected Response<JSONObject> parseNetworkResponse(
					NetworkResponse response) {
				// TODO Auto-generated method stub
				return super.parseNetworkResponse(response);
			}
		};
		
		RequestQueue queue = Volley.newRequestQueue(this);
		queue.add(jsonRequest);
	}

	private void initView() {
		// TODO Auto-generated method stub
		findViewById(R.id.login_btn).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_btn:
			Intent i = new Intent(SplashActivity.this,WebViewActivity.class);
			startActivity(i);
			break;

		default:
			break;
		}
	}

}
