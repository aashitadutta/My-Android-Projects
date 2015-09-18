package com.example.androiddatabaseapp;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditBook extends Activity {
EditText bookName;
String bookId=null;
Button btn1;
Button btn2;
DBController controller = new DBController(this);
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_edit_book);
	bookName=(EditText) findViewById(R.id.bookName1);
	btn1 = (Button) findViewById(R.id.button1);
	btn2 = (Button) findViewById(R.id.button2);
	Intent obj = getIntent();
	bookId = obj.getStringExtra("bookId");
	HashMap<String,String>booklist = controller.getBookInfo(bookId);
	if(booklist.size()!=0){
		bookName.setText(booklist.get("bookName"));}
		btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
			}
			
		});
		
		btn2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
			}
			
		});
	
}
public void editBook(View view){
	HashMap<String,String> al = new HashMap<String,String>();
	bookName=(EditText) findViewById(R.id.bookName1);
	Intent obj = getIntent();
	bookId=obj.getStringExtra("bookId");
	al.put("bookId",bookId);
	al.put("bokName",bookName.getText().toString());
	controller.updateBook(al);
	this.callHomeActivity(view);
}
public void removeBook(View view){
	Intent obj = getIntent();
	bookId=obj.getStringExtra("bookId");
	controller.deleteBook(bookId);
	this.callHomeActivity(view);
}
public void callHomeActivity(View view){
	Intent obj = new Intent(getApplicationContext(),MainActivity.class);
	startActivity(obj);
}
}
