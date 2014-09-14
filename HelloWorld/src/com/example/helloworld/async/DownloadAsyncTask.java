package com.example.helloworld.async;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * 画像をバックグラウンドで読み込ませる
 * 
 * @author shingo
 * 
 */
public class DownloadAsyncTask extends AsyncTask<String, Integer, Bitmap> {

	private Context mContext;

	private ImageView mView;

	private String path;

	public DownloadAsyncTask(final Context mContext, final ImageView mImageView,
			final String imagePath) {
		this.mContext = mContext;
		this.mView = mImageView;
		this.path = imagePath;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		// viewの設定
		mView = mView;

		// 読み込み中画像

		// 読み込み処理
		return loadPhoto();
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		super.onPostExecute(result);
		mView.setImageBitmap(result);
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
