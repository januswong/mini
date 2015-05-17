package com.weqilian.ui;

import com.weqilian.R;
import com.weqilian.callback.DemoJavaScriptInterface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
	
	private WebView mWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_webview);
		initView();
		initWebView();
		startUrl();
	}

	private void startUrl() {
		Intent intent = getIntent();
		String scheme = intent.getScheme();
		Uri uri = intent.getData();
		System.out.println("scheme:"+scheme);
		if (uri != null) {
			String host = uri.getHost();
			String dataString = intent.getDataString();
			String id = uri.getQueryParameter("id");
			String path = uri.getPath();
			String path1 = uri.getEncodedPath();
			String queryString = uri.getQuery();
			System.out.println("host:"+host);
			System.out.println("dataString:"+dataString);
			System.out.println("id:"+id);
			System.out.println("path:"+path);
			System.out.println("path1:"+path1);
			System.out.println("queryString:"+queryString);
		}
		
		// TODO Auto-generated method stub
//		mWebView.loadUrl("http://vshop.weiqilian.com/webapp/index.html");
		mWebView.loadUrl("http://vshop.weiqilian.com/app/getdata.html");
//		mWebView.loadUrl("http://10.135.10.192/test/jstest.html");
	}

	@SuppressLint("SetJavaScriptEnabled") 
	private void initWebView() {
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.getSettings().setDatabaseEnabled(true);
		mWebView.getSettings().setSupportZoom(true); // 设置允许缩放
		mWebView.getSettings().setBuiltInZoomControls(true); // 设置允许缩放控件
		mWebView.getSettings().setUseWideViewPort(true); // 设置此属性，可任意比例缩放。
		mWebView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
		mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		mWebView.getSettings().setAppCacheEnabled(true);
		
		mWebView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
			
		});
		
		mWebView.setWebChromeClient(new WebChromeClient(){
			@Override
			public boolean onJsAlert(WebView view, String url, String message,
					JsResult result) {
				Log.i("zzwang", "js alert: " + message);
				return super.onJsAlert(view, url, message, result);
			}
		});
		
		mWebView.addJavascriptInterface(new DemoJavaScriptInterface(), "android");
	}

	private void initView() {
		mWebView = (WebView) findViewById(R.id.webview);
		findViewById(R.id.title_test).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = String.format("javascript:wave('%s')", System.currentTimeMillis() );
				mWebView.loadUrl(url);
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
