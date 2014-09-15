package com.example.helloworld.async;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.os.Handler;
import android.os.Message;

public class SampleTaskQueue {

	private static final int THREAD_MAX_NUM = 3;

	// Stringのキュー
	private static BlockingQueue<String> queue;
	private static Handler handler;

	// コンストラクタ
	// ここでスレッドを起動する
	public SampleTaskQueue() {
		// 　キュー作成
		queue = new LinkedBlockingQueue<String>();

		// スレッド起動
		for (int i = 0; i < THREAD_MAX_NUM; i++) {
			new Thread(new OneThread()).start();
		}

		// ハンドラー作成
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// スレッドのなんか処理
			}
		};
	}

	public void pushTaskQueue(String text) {
		queue.offer(text);
	}

	private static class OneThread implements Runnable {

		@Override
		public void run() {
			for (;;) {
				String text = null;

				try {
					text = queue.take();
				} catch (Exception e) {
					// キューから取得できなかったときのエラー
				}

				// 完了時のメッセージ
				Message msg = Message.obtain();
				msg.obj = text;
				handler.sendMessage(msg);
			}
		}
	}

}
