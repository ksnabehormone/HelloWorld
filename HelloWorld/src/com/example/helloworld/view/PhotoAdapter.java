package com.example.helloworld.view;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.helloworld.R;
import com.example.helloworld.activity.PhotoZoomActivity;
import com.example.helloworld.model.PhotoInfo;

/**
 * 
 * @author shingo
 * 
 */
public class PhotoAdapter extends BaseAdapter {

	private Context context;
	// レイアウトを差し込むためにInflaterは必須
	private LayoutInflater inflater;
	// 1アイテム当たりの情報を詰め込むための情報
	private List<PhotoInfo> items;

	public PhotoAdapter(Context context, List<PhotoInfo> items) {
		this.context = context;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.items = items;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {

			LayoutInflater inflater = LayoutInflater.from(context);

			convertView = inflater.inflate(R.layout.adapter_photo, null);

			convertView.setFocusable(false);

			SquareImageView image = (SquareImageView) convertView.findViewById(R.id.image_photo);

			image.setImageBitmap(items.get(position).bitmap);

			image.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					final Intent intent = new Intent(context, PhotoZoomActivity.class);
					intent.putExtra(PhotoZoomActivity.KEY_PHOTO_URL, items.get(position).url);
					context.startActivity(intent);

				}
			});

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
