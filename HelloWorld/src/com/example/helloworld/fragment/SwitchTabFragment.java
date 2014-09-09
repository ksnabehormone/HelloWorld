package com.example.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.view.AppTabWidget;
import com.example.helloworld.view.AppTabWidget.OnTabSelectListener;

public class SwitchTabFragment extends Fragment implements OnTabSelectListener {

	private ViewGroup rootView;
	private TextView text;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = (ViewGroup) inflater.inflate(R.layout.fragment_switch_tab, container, false);
		((AppTabWidget) rootView.findViewById(R.id.TabWidget)).setOnTabSelectListener(this);
		text = (TextView) rootView.findViewById(R.id.TextTab);
		return rootView;
	}

	@Override
	public void onTabSelect(View v, int selectedIndex) {
		text.setText(((TextView) v).getText());
	}
}