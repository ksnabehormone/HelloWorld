package com.example.helloworld.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class HandlerActivity extends Activity implements OnClickListener, Runnable {

	private Thread mLooper;
	private Handler mHandler;

	private TextView text;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler);
		text = (TextView) findViewById(R.id.text_handler);
		button = (Button) findViewById(R.id.button_handler);
		button.setOnClickListener(this);

		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				text.setText((String) msg.obj);
			}
		};
	}

	@Override
	public void onStart() {
		super.onStart();
		mLooper = new Thread(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		// スレッドを削除
		mLooper = null;
	}

	@Override
	public void onClick(View v) {
		// スレッド処理を開始
		if (mLooper != null) {
			mLooper.start();
		}
	}

	@Override
	public void run() {
		long time = System.currentTimeMillis();
		long count = 0;

		while (mLooper != null) {

			long now = System.currentTimeMillis();
			if (now - time > 1000) {

				// Message msg = new Message(); //非推奨
				Message msg = Message.obtain(); // 推奨
				// Message msg = mHandler.obtainMessage(); //推奨
				msg.obj = new String("ループが" + count + "回終了しました");

				// ハンドラへのメッセージ送信
				mHandler.sendMessage(msg);

				// スレッドの利用変数を初期化
				time = now;
				count++;
			}
		}
	}

}
