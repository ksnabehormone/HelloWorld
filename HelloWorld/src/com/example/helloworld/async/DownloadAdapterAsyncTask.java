package com.example.helloworld.async;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.AbsListView;

import com.example.helloworld.model.PhotoInfo;
import com.example.helloworld.view.PhotoAdapter;

public class DownloadAdapterAsyncTask extends AsyncTask<Void, Void, List<PhotoInfo>> {

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
	protected List<PhotoInfo> doInBackground(Void... params) {
		List<PhotoInfo> photos = new ArrayList<PhotoInfo>();
		for (String url : findUrls()) {
			PhotoInfo photo = new PhotoInfo();
			photo.url = url;
			photo.bitmap = loadBitmap(url);
			photos.add(photo);
		}
		return photos;
	}

	@Override
	protected void onPostExecute(List<PhotoInfo> result) {
		super.onPostExecute(result);
		PhotoAdapter adapter = new PhotoAdapter(mContext, result);
		listView.setAdapter(adapter);
	}

	/**
	 * /data/data/パッケージ/ファイルURL一覧を取得する
	 * 
	 * @return
	 */
	private ArrayList<String> findUrls() {
		ArrayList<String> urls = new ArrayList<String>();
		File[] files = mContext.getFilesDir().listFiles();
		if (files != null) {
			for (File file : files) {
				urls.add(file.getName());
			}
		}
		return urls;
	}

	/**
	 * URLからBitmapをダウンロードする
	 * 
	 * @param url
	 * @return
	 */
	private Bitmap loadBitmap(String url) {
		InputStream input = null;
		try {
			input = mContext.openFileInput(url);
		} catch (FileNotFoundException e) {
			// エラー処理
		}
		return BitmapFactory.decodeStream(input);
	}

}
