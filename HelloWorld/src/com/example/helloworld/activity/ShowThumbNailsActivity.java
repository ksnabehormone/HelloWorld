package com.example.helloworld.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.example.helloworld.R;

public class ShowThumbNailsActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_thumb_nails);

		ImageView imageView = (ImageView) findViewById(R.id.image_thumb);
		String fname = getFilesDir() + "/image.png";
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,// データの種類
				null, // 項目(null 全項目)
				MediaStore.Images.ImageColumns.DATA + " = ?",// フィルタ条件(null　フィルタなし)
				new String[] { fname },// フィルタ用パラメータ
				null// ソート
				);
		if (cursor.moveToFirst()) {
			// サムネイルの取得
			long id = cursor.getLong(cursor.getColumnIndex("_id"));
			Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(resolver, id,
					MediaStore.Images.Thumbnails.MICRO_KIND, null);
			imageView.setImageBitmap(thumbnail);
		}
	}
}
