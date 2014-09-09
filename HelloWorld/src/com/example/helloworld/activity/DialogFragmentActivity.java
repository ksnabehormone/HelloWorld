package com.example.helloworld.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import com.example.helloworld.R;

public class DialogFragmentActivity extends FragmentActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_fragment);

		findViewById(R.id.button_show_dialog).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		showDialogFrag();
	}

	private void showDialogFrag() {
		final TestDialogFragment frag = new TestDialogFragment();
		frag.show(getSupportFragmentManager(), "hoge");
	}

	public static class TestDialogFragment extends DialogFragment implements OnClickListener {

		public static TestDialogFragment newInstance() {
			final TestDialogFragment frag = new TestDialogFragment();
			return frag;
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {

			Dialog dialog = new Dialog(getActivity());

			return dialog;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			Dialog dialog = getDialog();

			WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

			DisplayMetrics metrics = getResources().getDisplayMetrics();
			int dialogWidth = (int) (metrics.widthPixels * 0.8);
			int dialogHeight = (int) (metrics.heightPixels * 0.8);

			lp.width = dialogWidth;
			lp.height = dialogHeight;
			dialog.getWindow().setAttributes(lp);

			// タイトル非表示
			dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			// フルスクリーン
			dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
			dialog.setContentView(R.layout.layout_test_dialog);
			// 背景を透明にする
			// dialog.getWindow().setBackgroundDrawable(new
			// ColorDrawable(Color.TRANSPARENT));
		}

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
		}
	}
}