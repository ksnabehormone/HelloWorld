package com.example.helloworld.utils;

import android.app.AlertDialog;
import android.content.Context;

public class DialogUtils {

	public static void alertDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage("Success!");
		builder.show();
	}

	public static void alertDialog(final Context context, final String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(message);
		builder.show();
	}

}
