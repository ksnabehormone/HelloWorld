package com.example.helloworld.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.helloworld.R;

public class ItemListActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
	}
}
