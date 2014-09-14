package com.example.helloworld.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.helloworld.R;

public class FileManageActivity extends Activity {

	private List<String> songList = new ArrayList<String>();
	private ListView lv;
	private File[] files;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_manage);
		lv = (ListView) findViewById(R.id.list_file);

		String sdPath = Environment.getExternalStorageDirectory().getPath();
		files = new File(sdPath).listFiles();
		files = getFilesDir().listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				songList.add(files[i].getName());
			}

			lv = (ListView) findViewById(R.id.list_file);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_expandable_list_item_1, songList);
			lv.setAdapter(adapter);
		}

	}

	private ArrayList<String> findFiles() {
		ArrayList<String> texts = new ArrayList<String>();
		File[] files = getFilesDir().listFiles();
		if (files != null) {
			for (File file : files) {
				texts.add(file.getName());
			}
		}
		return texts;
	}
}
