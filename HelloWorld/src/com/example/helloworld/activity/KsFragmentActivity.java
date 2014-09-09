package com.example.helloworld.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.helloworld.R;
import com.example.helloworld.fragment.SampleFragment;

/**
 * フラグメントサンプル
 * 
 * @author shingo
 * 
 */
public class KsFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		// FragmentManagerを取得
		FragmentManager manager = getFragmentManager();
		// Fragmentのインスタンスを取得
		Fragment frag = manager.findFragmentById(R.id.sample_fragment);
		// お決まりのトランザクション開始
		FragmentTransaction xact = manager.beginTransaction();
		// Fragmentのインスタンスを取得
		SampleFragment sampleFragment = new SampleFragment();
		// インフレーとする
		xact.add(R.id.sample_fragment, sampleFragment);
		// お決まりのコミットで終了
		xact.commit();
	}
}
