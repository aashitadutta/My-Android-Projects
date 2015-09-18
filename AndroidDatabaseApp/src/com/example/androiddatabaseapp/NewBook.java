package com.example.androiddatabaseapp;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewBook extends Activity {
	private static final String LOGCAT=null;
	EditText bookName;
	Button btn1;
	DBController controller=new DBController(this);
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_book);
		btn1 = (Button) findViewById(R.id.btnadd);
		bookName=(EditText) findViewById(R.id.bookName1);
		btn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				
					
				Intent objectInt = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(objectInt);
				this.addNewBook(view);
				Log.d(LOGCAT,"bookName");
			}

			private void addNewBook(View view) {
				// TODO Auto-generated method stub
				HashMap<String,String> al = new HashMap<String,String>();
				al.put("bookName",bookName.getText().toString());
				controller.insertBook(al);
			}

			
			
			
		});
	}
	/*public void addNewBook(View view){
		HashMap<String,String> al = new HashMap<String,String>();
		al.put("bookName",bookName.getText().toString());
		controller.insertBook(al);
		//this.callHomeActivity(view);
	}
	public void callHomeActivity(View view){
		Intent objectInt = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(objectInt);
	}*/
}
