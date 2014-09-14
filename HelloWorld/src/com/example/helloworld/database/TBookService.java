package com.example.helloworld.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TBookService extends SQLiteOpenHelper {

	public TBookService(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * このデータベースを初めて使用する時に実行される処理 テーブルの作成や初期データの投入を行う
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// テーブルを作成。SQLの文法は通常のSQLiteと同様
		db.execSQL("create table T_BOOK ("
				+ "BOOK_ID  integer primary key autoincrement not null, " + "TITLE text not null, "
				+ "PRICE  integer )");
		// 必要なら、ここで他のテーブルを作成したり、初期データを挿入したりする
	}

	/**
	 * アプリケーションの更新などによって、データベースのバージョンが上がった場合に実行される処理
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 取りあえず、空実装でよい
	}

}
