package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.helloworld.R;

public class MainActivity extends Activity implements OnClickListener {

	final private int ids[] = { R.id.link_fragment, R.id.link_item_list, R.id.link_framelayout,
			R.id.link_list_height_change, R.id.link_line_break, R.id.link_async,
			R.id.link_layout_test, R.id.link_switch_button, R.id.link_mylistener,
			R.id.link_dialog_fragment };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setClickable();
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.link_fragment:
			forward(KsFragmentActivity.class);
			break;
		case R.id.link_item_list:
			forward(ItemListActivity.class);
			break;
		case R.id.link_framelayout:
			forward(FrameLayoutActivity.class);
			break;
		case R.id.link_list_height_change:
			forward(ListHeightChangeActivity.class);
			break;
		case R.id.link_line_break:
			forward(LineBreakActivity.class);
			break;
		case R.id.link_async:
			forward(AsyncActivity.class);
			break;
		case R.id.link_layout_test:
			forward(LayouotTestActivity.class);
			break;
		case R.id.link_switch_button:
			forward(SelectSwitchButtonActivity.class);
			break;
		case R.id.link_mylistener:
			forward(MyListenerActivity.class);
			break;
		case R.id.link_dialog_fragment:
			forward(DialogFragmentActivity.class);
			break;
		}
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

	private void setClickable() {
		for (int id : ids) {
			Button button = (Button) findViewById(id);
			button.setOnClickListener(this);
		}
	}

}
