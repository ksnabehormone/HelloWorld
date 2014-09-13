package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.helloworld.R;
import com.example.helloworld.date.RequestCode;

public class GetPhotoActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_get);

		findViewById(R.id.button_start_gallery).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_start_gallery:
			startGallery();
			break;

		default:
			break;
		}
	}

	public void startGallery() {
		Intent i = new Intent();
		i.setAction(Intent.ACTION_GET_CONTENT);
		i.setType("image/*");
		startActivityForResult(i, RequestCode.REQUEST_GALLERY);
	}

}
