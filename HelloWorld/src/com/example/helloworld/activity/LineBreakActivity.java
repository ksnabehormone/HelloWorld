package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.view.WrapLayout;

public class LineBreakActivity extends Activity {

	private static String[] tags = { "hoge1", "hoge2", "hoge3", "hoge4", "hoge5", "hoge6", "hoge7",
			"hoge8", "hoge9", "hoge10", "hoge11", "hoge12", };

	private static int TEXT_LENGTH = 150;

	private ViewGroup rl;

	private WrapLayout wrapLayout;

	private ViewGroup labelList;

	private RelativeLayout lineout;

	private RelativeLayout lineout2;

	private LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_line_break);

		inflater = getLayoutInflater();

		// layoutを取得
		rl = (LinearLayout) findViewById(R.id.rl);
		wrapLayout = (WrapLayout) findViewById(R.id.wrap_layout);
		labelList = (ViewGroup) findViewById(R.id.label_list);
		lineout = (RelativeLayout) findViewById(R.id.lineout);
		lineout2 = (RelativeLayout) findViewById(R.id.lineout2);

		addWrapLaout();
		addLableLayout();
		addLineout();
		addLineout2();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		addRl();
		breakLineout();
	}

	private void addRl() {
		// 再描画対策
		if (rl.getChildCount() != 0) {
			return;
		}

		// 画面幅を取得
		int lengthMax = rl.getWidth();
		// 今の幅
		int lengthCurrent = 0;

		// 保持するためのlinearlayout
		LinearLayout line = createLinearLayout();

		// 1000個くらいいれると若干固まるから別スレッドで作るとかやったほうがいいかも？
		for (int i = 0; i < tags.length; i++) {
			TextView view = createView(i);

			lengthCurrent += TEXT_LENGTH;

			// 画面幅を超えていない場合
			if (lengthMax < lengthCurrent) {
				// 現状あるやつを保存
				rl.addView(line);
				// 新しい　linearlayouthorizen を立ち上げて追加
				lengthCurrent = 0;
				line = createLinearLayout();
			}
			line.addView(view);
		}
		rl.addView(line);
	}

	private void addWrapLaout() {
		for (int i = 0; i < tags.length; i++) {
			View view = createView(i);
			wrapLayout.addView(view);
		}
	}

	private void addLableLayout() {
		for (int i = 0; i < tags.length; i++) {
			View label = inflater.inflate(R.layout.layout_label, null, false);
			labelList.addView(label);
		}
	}

	private void addLineout() {
		for (int i = 0; i < tags.length; i++) {
			View view = createView(i);
			lineout.addView(view);
		}
	}

	private void addLineout2() {
		// for (int i = 0; i < tags.length; i++) {
		// View view = createView(i);
		// view.setId(i);
		// lineout.addView(view);
		// }
		View v0 = createView(0);
		RelativeLayout.LayoutParams p0 = new RelativeLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		p0.addRule(RelativeLayout.ALIGN_TOP, R.id.test);
		p0.addRule(RelativeLayout.RIGHT_OF, R.id.test);
		lineout2.addView(v0, p0);

		View v1 = createView(1);
		RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		p1.addRule(RelativeLayout.ALIGN_TOP, 0);
		p1.addRule(RelativeLayout.RIGHT_OF, 0);
		lineout2.addView(v1, p1);
	}

	private void breakLineout() {
		// 子供の数を取得
		int l = lineout.getChildCount();
		// 無いなら何もしない
		if (l == 0) {
			return;
		}
		// ディスプレイの横幅を取得
		WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		int max = display.getWidth();

		int margin = 0;
		// 一番最初は基点となるので何もしない
		View pline = lineout.getChildAt(0);
		// 一行全体の長さ
		int total = pline.getWidth() + margin;
		for (int i = 1; i < l; i++) {
			int w = lineout.getChildAt(i).getWidth() + margin;
			RelativeLayout.LayoutParams prm = (RelativeLayout.LayoutParams) lineout.getChildAt(i)
					.getLayoutParams();
			// 横幅を超えないなら前のボタンの右に出す
			if (max > total + w) {
				total += w;
				prm.addRule(RelativeLayout.ALIGN_TOP, i - 1);
				prm.addRule(RelativeLayout.RIGHT_OF, i - 1);
			}
			// 超えたら下に出す
			else {
				prm.addRule(RelativeLayout.BELOW, i - 1);
				// 基点を変更
				pline = lineout.getChildAt(i);
				// 長さをリセット
				total = pline.getWidth() + margin;
			}
		}
	}

	private TextView createView(int index) {
		String s = tags[index];
		TextView view = new TextView(this);
		view.setText(s);
		view.setId(index);
		view.setWidth(TEXT_LENGTH);
		view.setBackgroundResource(R.color.gray);
		return view;
	}

	private LinearLayout createLinearLayout() {
		final LinearLayout l = new LinearLayout(this);
		l.setOrientation(LinearLayout.HORIZONTAL);
		return l;
	}

}
