package com.example.helloworld.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.util.Log;

/**
 * 第一引数、初期パラメータ 第二引数、プログレスパラメータ 第三引数、結果のパラーメータ
 * 
 * @author shingo
 * 
 */
public class SampleAsyncTask extends AsyncTask<String, Integer, String> implements OnCancelListener {

	final String TAG = "MyAsyncTask";
	ProgressDialog dialog;
	Context context;

	public SampleAsyncTask(Context context) {
		this.context = context;
	}

	@Override
	protected void onPreExecute() {
		Log.d(TAG, "onPreExecute");
		dialog = new ProgressDialog(context);
		dialog.setTitle("Please wait");
		dialog.setMessage("Loading data...");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setCancelable(true);
		dialog.setOnCancelListener(this);
		dialog.setMax(100);
		dialog.setProgress(0);
		dialog.show();
	}

	/**
	 * バックグラウンド処理
	 */
	@Override
	protected String doInBackground(String... params) {
		Log.d(TAG, "doInBackground - " + params[0]);

		try {
			for (int i = 0; i < 10; i++) {
				if (isCancelled()) {
					Log.d(TAG, "Cancelled!");
					break;
				}
				Thread.sleep(1000);
				publishProgress((i + 1) * 10);
			}
		} catch (InterruptedException e) {
			Log.d(TAG, "InterruptedException in doInBackground");
		}
		return "Finish";
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		Log.d(TAG, "onProgressUpdate - " + values[0]);
		dialog.setProgress(values[0]);
	}

	@Override
	protected void onCancelled() {
		Log.d(TAG, "onCancelled");
		dialog.dismiss();
	}

	/**
	 * バックグラウンド処理が終わった後の処理（表示の更新）
	 */
	@Override
	protected void onPostExecute(String result) {
		Log.d(TAG, "onPostExecute - " + result);
		dialog.dismiss();
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		Log.d(TAG, "Dialog onCancell... calling cancel(true)");
		this.cancel(true);
	}
}