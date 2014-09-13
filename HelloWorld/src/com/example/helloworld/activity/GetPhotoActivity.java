package com.example.helloworld.activity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.helloworld.R;
import com.example.helloworld.date.RequestCode;

public class GetPhotoActivity extends Activity implements OnClickListener {

	private Bitmap mBmp;
	private ImageView mImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo_get);

		findViewById(R.id.button_start_gallery).setOnClickListener(this);
		mImage = (ImageView) findViewById(R.id.image_select_pict);
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

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			try {
				InputStream is = getContentResolver().openInputStream(data.getData());
				mBmp = BitmapFactory.decodeStream(is);
				mImage.setImageBitmap(mBmp);
				savePhoto(mBmp);
				is.close();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void savePhoto(Bitmap image) {
		FileOutputStream out = null;
		try {
			// openFileOutputはContextのメソッドなのでActivity内ならばthisでOK
			out = this.openFileOutput("image.png", Context.MODE_PRIVATE);
			image.compress(Bitmap.CompressFormat.PNG, 100, out);
		} catch (FileNotFoundException e) {
			// エラー処理
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
				out = null;
			}
		}
	}

}
