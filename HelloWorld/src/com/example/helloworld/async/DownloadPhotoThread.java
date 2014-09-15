package com.example.helloworld.async;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.helloworld.model.PhotoInfo;

public class DownloadPhotoThread implements Runnable {

	// Stringのキュー
	private static BlockingQueue<ImageView> queue;

	private Context context;

	private List<PhotoInfo> items;

	private int cmpCount;

	// コンストラクタ
	// ここでスレッドを起動する
	public DownloadPhotoThread(final Context context, List<PhotoInfo> items) {
		this.context = context;
		this.items = items;
		// 　キュー作成
		queue = new LinkedBlockingQueue<ImageView>();

		// スレッド起動
		new Thread(this).start();
	}

	public void pushTaskQueue(ImageView view) {
		queue.offer(view);
	}

	@Override
	public void run() {
		for (;;) {
			ImageView view = null;

			try {
				view = queue.take();
				view.setImageBitmap(loadBitmap(items.get(cmpCount).url));
			} catch (Exception e) {
				// キューから取得できなかったときのエラー
				continue;
			}
			cmpCount++;
		}
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
			input = context.openFileInput(url);
		} catch (FileNotFoundException e) {
			// エラー処理
		}
		return BitmapFactory.decodeStream(input);
	}
}
