package com.weqilian.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.weqilian.R;

public class SplashActivity extends Activity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initView();
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
