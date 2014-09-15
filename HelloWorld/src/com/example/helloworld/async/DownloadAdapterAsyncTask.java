package com.example.helloworld.async;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.AbsListView;

import com.example.helloworld.view.PhotoAdapter;

public class DownloadAdapterAsyncTask extends AsyncTask<Void, Void, List<Bitmap>> {

	private Context mContext;

	private AbsListView listView;

	public DownloadAdapterAsyncTask(final Context mContext, final AbsListView listView) {
		this.mContext = mContext;
		this.listView = listView;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		listView.setAdapter(null);
	}

	@Override
	protected List<Bitmap> doInBackground(Void... params) {
		List<Bitmap> bmpList = new ArrayList<Bitmap>();
		for (int i = 0; i < 10; i++) {
			bmpList.add(loadPhoto());
		}
		return bmpList;
	}

	@Override
	protected void onPostExecute(List<Bitmap> result) {
		super.onPostExecute(result);
		PhotoAdapter adapter = new PhotoAdapter(mContext, result);
		listView.setAdapter(adapter);
	}

	private Bitmap loadPhoto() {
		InputStream input = null;
		try {
			input = mContext.openFileInput("image.png");
		} catch (FileNotFoundException e) {
			// エラー処理
		}
		return BitmapFactory.decodeStream(input);
	}

}
