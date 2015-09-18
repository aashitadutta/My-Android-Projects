package com.example.androiddatabaseapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController extends SQLiteOpenHelper {
public DBController(Context applicationcontext){
	super(applicationcontext,"androidsqlite.db",null,1);
}
@Override
public void onCreate(SQLiteDatabase database){
	String query;
	query="Create table books(bookID Integer primary key,bookName Text)";
	database.execSQL(query);
}
@Override
public void onUpgrade(SQLiteDatabase database,int version_old,int current_version){
	String query;
	query="Drop table if exists books";
	database.execSQL(query);
	onCreate(database);
}
public void insertBook(HashMap<String,String> al){
    SQLiteDatabase database=this.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put("bookName", al.get("bookName"));
    database.insert("books", null, values);
    database.close();
}
public int updateBook(HashMap<String,String>al){
	SQLiteDatabase database = this.getWritableDatabase();
	ContentValues values = new ContentValues();
	 values.put("bookName", al.get("bookName"));
	 return database.update("books", values, "bookId"+"=?", new String[]{al.get("bookId")});
	 }
public void deleteBook(String id){
	SQLiteDatabase database = this.getWritableDatabase();
	String deletequery="Delete From books where bookId='"+id+"'";
	database.execSQL(deletequery);
}
public ArrayList<HashMap<String,String>>getAllBooks(){
	ArrayList<HashMap<String,String>>wordList;
	wordList=new ArrayList<HashMap<String,String>>();
	String selectQuery="Select * from books";
	SQLiteDatabase database=this.getWritableDatabase();
	Cursor cursor=database.rawQuery(selectQuery,null);
	if(cursor.moveToFirst()){
		do{
			HashMap<String,String> al = new HashMap<String,String>();
			al.put("bookId",cursor.getString(0));
			al.put("bookName",cursor.getString(1));
			wordList.add(al);
					
		}
		while(cursor.moveToNext());
	}
	return wordList;
}
public HashMap<String,String>getBookInfo(String id){
	HashMap<String,String>wordList=new HashMap<String,String>();
	SQLiteDatabase database=this.getReadableDatabase();
	String selectQuery="Select * from books where bookId='"+id+"'";
	Cursor cursor=database.rawQuery(selectQuery,null);
	if(cursor.moveToFirst()){
		do{
			wordList.put("bookName",cursor.getString(1));
		}
		while(cursor.moveToNext());
	
	}
	return wordList;
}
}
