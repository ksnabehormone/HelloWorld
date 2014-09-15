package com.example.helloworld.activity;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.helloworld.R;

public class PhotoZoomActivity extends FragmentActivity implements OnClickListener {

	public static String KEY_PHOTO_URL = "0";

	private String url;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_photo_zoom);

		url = (String) getIntent().getExtras().get(KEY_PHOTO_URL);
		if (url != null) {
			ImageView image = (ImageView) findViewById(R.id.image_photo_zoom);
			image.setImageBitmap(loadBitmap(url));
		}
		findViewById(R.id.button_delete).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		// アラートダイアログのタイトルを設定します
		alertDialogBuilder.setTitle("画像を削除");
		// アラートダイアログのメッセージを設定します
		alertDialogBuilder.setMessage("画像を削除します");
		// アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
		alertDialogBuilder.setPositiveButton("キャンセル", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		// アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
		alertDialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				deleteFile(url);
			}
		});
		// アラートダイアログのキャンセルが可能かどうかを設定します
		alertDialogBuilder.setCancelable(true);
		AlertDialog alertDialog = alertDialogBuilder.create();
		// アラートダイアログを表示します
		alertDialog.show();
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
			input = openFileInput(url);
		} catch (FileNotFoundException e) {
			// エラー処理
		}
		return BitmapFactory.decodeStream(input);
	}
}