package com.weqilian.ui;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import manager.URLManager;

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

public class SplashActivity extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initView();
//		requestLogin();	
		requestGetSms();
	}

	private void requestGetSms() {

		JSONObject jsonObj = new JSONObject();
		Map<String, String> map = new HashMap<String, String>();  
		map.put("mobile", "15212776323");  
		try {
			jsonObj.put("smsservice", map);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("zzwang11111111", e.getMessage());
		}
		JsonRequest<JSONObject>  jsonRequest = new JsonObjectRequest(Method.POST, URLManager.getSmsServiceUrl(), jsonObj, new Listener<JSONObject>() {

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

	private void requestLogin() {
		// TODO Auto-generated method stub
		JSONObject jsonObj = new JSONObject();
		Map<String, String> map = new HashMap<String, String>();  
		map.put("mobile", "12345678911");  
		map.put("password", "88cadf93e4ef147a8a1c7080c13375d3"); 
		try {
			jsonObj.put("sign", map);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("zzwang11111111", e.getMessage());
		}
		JsonRequest<JSONObject>  jsonRequest = new JsonObjectRequest(Method.POST, URLManager.getSignUrl(), jsonObj, new Listener<JSONObject>() {

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
