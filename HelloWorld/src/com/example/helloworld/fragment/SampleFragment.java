package com.example.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.helloworld.R;
import com.example.helloworld.utils.DialogUtils;

public class SampleFragment extends Fragment implements OnClickListener {

	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/**
		 * inflate(挿入するフラグメントのID, 親View, attachToRoot?)
		 */
		rootView = inflater.inflate(R.layout.fragment_sample, container, false);
		((Button) rootView.findViewById(R.id.button_alert)).setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_alert:
			DialogUtils.alertDialog(getActivity());
			break;
		}

	}
}
