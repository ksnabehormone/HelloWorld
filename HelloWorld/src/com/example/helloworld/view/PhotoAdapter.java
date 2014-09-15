package com.example.helloworld.view;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.helloworld.R;

public class PhotoAdapter extends BaseAdapter {

	private Context context;
	// レイアウトを差し込むためにInflaterは必須
	private LayoutInflater inflater;
	// 1アイテム当たりの情報を詰め込むための情報
	private List<Bitmap> items;

	public PhotoAdapter(Context context, List<Bitmap> items) {
		this.context = context;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {

			LayoutInflater inflater = LayoutInflater.from(context);

			convertView = inflater.inflate(R.layout.adapter_photo, null);

			convertView.setFocusable(false);

			SquareImageView image = (SquareImageView) convertView.findViewById(R.id.image_photo);

			image.setImageBitmap(items.get(position));

		}

		return convertView;
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
