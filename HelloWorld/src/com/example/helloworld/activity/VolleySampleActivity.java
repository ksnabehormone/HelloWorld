/**
 * 
 */
package com.example.helloworld.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.helloworld.R;

/**
 * Volleyのサンプル
 * 
 * @author shingo
 * 
 */
public class VolleySampleActivity extends Activity implements Listener<JSONObject>, ErrorListener {

	private RequestQueue mQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_volley_sample);

		// 東京都の天気情報
		String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=270000";

		mQueue = Volley.newRequestQueue(this);
		mQueue.add(new JsonObjectRequest(Method.GET, url, null, this, this));
	}

	@Override
	public void onResponse(JSONObject response) {
		try {
			String title = response.get("title").toString();
			TextView view = (TextView) findViewById(R.id.text_title);
			view.setText(title);
		} catch (JSONException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	@Override
	public void onErrorResponse(VolleyError error) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
