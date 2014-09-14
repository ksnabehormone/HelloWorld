package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.helloworld.R;

public class MainActivity extends Activity {

	private LinearLayout list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = (LinearLayout) findViewById(R.id.layout_main_list);
		addButton("Fragment基礎", KsFragmentActivity.class);
		addButton("アイテムリスト", ItemListActivity.class);
		addButton("FrameLayout重ねて表示", FrameLayoutActivity.class);
		addButton("リストの高さを個別に変えれるか", ListHeightChangeActivity.class);
		addButton("横に並べて改行", LineBreakActivity.class);
		addButton("非同期", AsyncActivity.class);
		addButton("レイアウトテスト", LayouotTestActivity.class);
		addButton("スイッチボタン", SelectSwitchButtonActivity.class);
		addButton("独自リスナー", MyListenerActivity.class);
		addButton("DialogFragment", DialogFragmentActivity.class);
		addButton("Volleyのサンプル", VolleySampleActivity.class);
		addButton("画像取得サンプル", GetPhotoActivity.class);
		addButton("取得した画像を表示", ShowGalleryActivity.class);
		addButton("File操作", FileManageActivity.class);
		addButton("サムネイル一覧", ShowThumbNailsActivity.class);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 画面遷移 ※manifest忘れずに
	 * 
	 * @param forwardTo
	 */
	private void forward(final Class<?> forwardTo) {
		Intent intent = new Intent(MainActivity.this, forwardTo);
		startActivity(intent);
	}

	private void addButton(String title, final Class<?> forwardTo) {
		Button view = new Button(this);
		view.setText(title);
		view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				forward(forwardTo);
			}
		});
		list.addView(view);
	}

}
