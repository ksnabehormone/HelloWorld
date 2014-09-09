package com.example.helloworld.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.helloworld.R;

/**
 * バックグラウンド処理
 * 
 * @author shingo
 * 
 */
public class AsyncActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async);
	}

}
