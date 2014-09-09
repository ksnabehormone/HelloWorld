package com.example.helloworld.model;

import android.widget.EditText;

import com.example.helloworld.interfaces.MyListenerInterface;

public class ToastNotify {

	private EditText et = null;
	private MyListenerInterface listener = null;

	public void checkText() {
		if (this.et.getText().toString().equals("")) {
			// テキストが入力されていない
			listener.noInputText();
		} else {
			// テキストが入力されている場合の処理
			listener.inputText();
		}
	}

	/**
	 * リスナーを追加する
	 * 
	 * @param listener
	 */
	public void setListener(final MyListenerInterface listener) {
		this.listener = listener;
	}

	/**
	 * リスナー
	 */
	public void removeListener() {
		this.listener = null;
	}
}