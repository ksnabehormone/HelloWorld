package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.helloworld.R;

public class LifeCycleActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_cycle);
		Log.d("LifeCycleActivity", "onCreate");

		findViewById(R.id.btn_go_life2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LifeCycleActivity.this, LifeCycle2Activity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d("LifeCycleActivity", "onStart");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.d("LifeCycleActivity", "onRestoreInstanceState");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.d("LifeCycleActivity", "onActivityResult");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("LifeCycleActivity", "onResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("LifeCycleActivity", "onSaveInstanceState");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("LifeCycleActivity", "onPause");
	}

	public void onStop() {
		super.onStop();
		Log.d("LifeCycleActivity", "onStop");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.d("LifeCycleActivity", "onDestroy");
	}
}