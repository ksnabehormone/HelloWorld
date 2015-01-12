package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.example.helloworld.R;

public class LifeCycle2Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life_cycle2);
		Log.d("LifeCycle2Activity", "onCreate");

		if (savedInstanceState == null) {

			findViewById(R.id.btn_go_life).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(LifeCycle2Activity.this, LifeCycleActivity.class);
					startActivity(intent);
				}
			});

			((EditText) findViewById(R.id.edit_life2)).setText("default");

		} else {
			((EditText) findViewById(R.id.edit_life2)).setText((String) savedInstanceState
					.get("KEY"));
		}

	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d("LifeCycle2Activity", "onStart");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.d("LifeCycle2Activity", "onRestoreInstanceState " + savedInstanceState.get("KEY"));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.d("LifeCycle2Activity", "onActivityResult");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("LifeCycle2Activity", "onResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("LifeCycle2Activity", "onSaveInstanceState");
		outState.putString("KEY", "test");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("LifeCycle2Activity", "onPause");
	}

	public void onStop() {
		super.onStop();
		Log.d("LifeCycle2Activity", "onStop");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.d("LifeCycle2Activity", "onDestroy");
	}
}