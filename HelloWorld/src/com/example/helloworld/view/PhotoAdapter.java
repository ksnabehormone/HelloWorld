package com.example.helloworld.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.helloworld.R;

public class PhotoAdapter extends BaseAdapter {

	// レイアウトを差し込むためにInflaterは必須
	private LayoutInflater inflater;
	// 1アイテム当たりの情報を詰め込むための情報
	private ArrayList<Bitmap> items;

	public PhotoAdapter(Context context, ArrayList<Bitmap> items) {
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = inflater.inflate(R.layout.adapter_photo, null);
		view.setFocusable(false);
		ImageView image = (ImageView) view.findViewById(R.id.image_photo);
		image.setImageBitmap(items.get(position));
		return view;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public int getCount() {
		return items.size();
	}
}
