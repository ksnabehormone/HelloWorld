package com.example.helloworld.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class AppTabWidget extends LinearLayout implements OnClickListener {

	/**
	 * アーキテクチャ tabの子ViewにClieckListerをセットし
	 * 呼ばれたViewからコールバックでOnTabSeleberListerを呼び出す
	 */

	private int selectedIndex;

	private ArrayList<View> tabs = new ArrayList<View>();

	private OnTabSelectListener mOnTabSelectListener;

	public AppTabWidget(Context context) {
		super(context);

		// これはだめな例
		// インスタンスが生成される段階ではまだ子Viewが取得されていない
		// init();
	}

	public AppTabWidget(Context context, AttributeSet attrs) {
		super(context, attrs);

		// これはだめな例
		// インスタンスが生成される段階ではまだ子Viewが取得されていない
		// init();
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		init();
	}

	@Override
	public void onClick(View v) {
		// 選択したtabのindexを設定
		for (int i = 0; i < tabs.size(); i++) {
			if (tabs.get(i) == v) {
				selectedIndex = i;
				tabs.get(i).setSelected(true);
			} else {
				tabs.get(i).setSelected(false);
			}
		}
		// 選択したやつのイベント処理
		if (v != this) {
			mOnTabSelectListener.onTabSelect(v, selectedIndex);
		}
	}

	private void init() {
		this.setOnClickListener(this);
		int tabCount = this.getChildCount();
		for (int i = 0; i < tabCount; i++) {
			tabs.add(this.getChildAt(i));
			tabs.get(i).setOnClickListener(this);
		}
	}

	public void setSelectedTab(int selectedIndex) {
		for (int i = 0; i < tabs.size(); i++) {
			if (i == selectedIndex) {
				tabs.get(i).setSelected(true);
			} else {
				tabs.get(i).setSelected(false);
			}
		}
	}

	public void setOnTabSelectListener(final OnTabSelectListener mOnTabSelectListener) {
		this.mOnTabSelectListener = mOnTabSelectListener;
	}

	public interface OnTabSelectListener {
		void onTabSelect(View v, int selectedIndex);
	}
}
