package com.example.helloworld.activity;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.example.helloworld.R;
import com.example.helloworld.view.PhotoAdapter;

public class ShowGalleryActivity extends Activity implements OnItemClickListener {

	private GridView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_gallery);

		list = (GridView) findViewById(R.id.list_photo);
		list.setOnItemClickListener(this);

		ArrayList<Bitmap> items = new ArrayList<Bitmap>();
		items.add(loadPhoto());
		items.add(loadPhoto());
		items.add(loadPhoto());
		items.add(loadPhoto());
		items.add(loadPhoto());
		items.add(loadPhoto());
		PhotoAdapter adapter = new PhotoAdapter(this, items);
		list.setAdapter(adapter);

	}

	private Bitmap loadPhoto() {
		InputStream input = null;
		try {
			input = this.openFileInput("image.png");
		} catch (FileNotFoundException e) {
			// エラー処理
		}
		return BitmapFactory.decodeStream(input);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();

	}
}
