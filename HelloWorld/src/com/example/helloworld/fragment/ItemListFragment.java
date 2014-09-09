package com.example.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.helloworld.R;

public class ItemListFragment extends Fragment {

	private ViewGroup rootView;

	private ViewGroup itemListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// rootViewを取得
		rootView = (ViewGroup) inflater.inflate(R.layout.fragment_item_list, container, false);
		// linerlayoutを取得
		itemListView = (ViewGroup) rootView.findViewById(R.id.ItemListLayout);
		// 追加するView
		itemListView.addView(getViewInfo(inflater, "美味しい松阪牛", "2999円", "美味しいお肉"));
		itemListView.addView(getViewInfo(inflater, "高級お肉", "5000円",
				"おいしいおにくんんですよ。食べてよー。お願いしますよー。あああああああああああああああああああ"));
		return rootView;
	}

	private View getViewInfo(LayoutInflater inflater, final String itemName, final String price,
			final String sentence) {
		View item = inflater.inflate(R.layout.layout_item_contents, null, false);
		TextView text = (TextView) item.findViewById(R.id.textView_itemName);
		text.setText(itemName);
		TextView text2 = (TextView) item.findViewById(R.id.textView_price);
		text2.setText(price);
		TextView text3 = (TextView) item.findViewById(R.id.textView_sentence);
		text3.setText(sentence);

		// ViewGroup.LayoutParams params = layout.getLayoutParams();
		// params.width = LinearLayout.LayoutParams.MATCH_PARENT;
		// params.height = LinearLayout.LayoutParams.WRAP_CONTENT +
		// item.getHeight();
		// item.setLayoutParams(params);

		getHeightAfterRendering(text3);
		return item;
	}

	private void getHeightAfterRendering(final View view) {
		ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
		viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				Log.d("Viewの高さを取得", String.valueOf(view.getHeight()));
			}
		});
	}

}
