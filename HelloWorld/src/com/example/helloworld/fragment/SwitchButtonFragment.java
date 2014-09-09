package com.example.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helloworld.R;

public class SwitchButtonFragment extends Fragment implements OnClickListener {

	private ViewGroup rootView;
	private TextView button1;
	private TextView button2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = (ViewGroup) inflater.inflate(R.layout.fragment_switch_button, container, false);
		button1 = (TextView) rootView.findViewById(R.id.Button1);
		button2 = (TextView) rootView.findViewById(R.id.Button2);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Button1:
			selectButton(v.getId());
			break;
		case R.id.Button2:
			selectButton(v.getId());
			break;

		default:
			break;
		}
	}

	private void selectButton(final int selected) {
		if (R.id.Button1 == selected) {
			button1.setSelected(true);
			button2.setSelected(false);
		} else {
			button1.setSelected(false);
			button2.setSelected(true);
		}
	}

}
