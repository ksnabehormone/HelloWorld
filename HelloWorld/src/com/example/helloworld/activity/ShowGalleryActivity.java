package com.example.helloworld.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.helloworld.R;
import com.example.helloworld.async.DownloadAdapterAsyncTask;

public class ShowGalleryActivity extends Activity {

	private GridView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_gallery);

		list = (GridView) findViewById(R.id.list_photo);

		loadGallery();
	}

	@Override
	protected void onStart() {
		super.onStart();

	}

	private void loadGallery() {
		// バックグラウンドで読み込ませるパターン
		DownloadAdapterAsyncTask task = new DownloadAdapterAsyncTask(this, list);
		task.execute((Void) null);
	}
}
