package com.example.helloworld.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.helloworld.R;
import com.example.helloworld.async.DownloadAsyncTask;
import com.example.helloworld.async.SampleAsyncTask;

/**
 * バックグラウンド処理
 * 
 * @author shingo
 * 
 */
public class AsyncActivity extends Activity implements OnClickListener {

	private Button buttonAsync01;

	private Button buttonAsync02;
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async);

		buttonAsync01 = (Button) findViewById(R.id.button_start_async01);
		buttonAsync01.setOnClickListener(this);
		buttonAsync02 = (Button) findViewById(R.id.button_start_async02);
		buttonAsync02.setOnClickListener(this);
		mImageView = (ImageView) findViewById(R.id.image_async);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_start_async01:
			new SampleAsyncTask(this).execute("謎のパラメータ");
			break;
		case R.id.button_start_async02:
			DownloadAsyncTask task = new DownloadAsyncTask(this, mImageView, "");
			task.execute("");
			break;
		default:
			break;
		}

	}
}
