package com.example.helloworld.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.helloworld.R;

public class FrameLayoutActivity extends FragmentActivity implements OnClickListener {

	private View img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_framelayout);
		findViewById(R.id.textView_framelayout).setOnClickListener(this);

		TextView click = (TextView) findViewById(R.id.textView_framelayout);
		click.setOnClickListener(this);

		img = findViewById(R.id.img_atension);
	}

	@Override
	public void onClick(View v) {
		// Switch省略
		if (img.getVisibility() == View.VISIBLE) {
			img.setVisibility(View.INVISIBLE);
		} else {
			img.setVisibility(View.VISIBLE);
		}

	}
}