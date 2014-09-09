package com.example.helloworld.interfaces;

import java.util.EventListener;

public interface MyListenerInterface extends EventListener {
	/**
	 * 文字が入力されていない状態を通知する
	 */
	public void noInputText();

	/**
	 * 文字が入力されている状態を通知する
	 */
	public void inputText();
}
