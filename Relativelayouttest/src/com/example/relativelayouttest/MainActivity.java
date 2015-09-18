package com.example.relativelayouttest;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends Activity {
	EditText textField;
	Spinner spinner1;
	Spinner spinner2;
	Button button1;
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayAdapter<String> dataAdapter;
	ArrayAdapter<String> dataAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textField = (EditText) findViewById(R.id.editText);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        button1 = (Button) findViewById(R.id.button1);
        list.add("Thu,20-08-2015");
        list.add("Fri,21-08-2015");
        list.add("Sat,22-08-2015");
        list.add("Sun,23-08-2015");
        list1.add("8:00am");
        list1.add("9:00am");
        list1.add("10:00am");
        list1.add("11:00am");
        dataAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
        dataAdapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list1);
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){
        	@Override
        	public void onItemSelected(AdapterView<?>arg0,View
        			arg1, int arg2, long arg3){
        		Toast.makeText(MainActivity.this,"Date selected is"
        				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();
        	}
        	@Override
        	public void onNothingSelected(AdapterView<?>arg0){
        		
        	}
        });
        spinner2.setAdapter(dataAdapter1);
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener(){
        	@Override
        	public void onItemSelected(AdapterView<?>arg0,View
        			arg1, int arg2, long arg3){
        		Toast.makeText(MainActivity.this,"Time selected is"
        				+dataAdapter1.getItem(arg2), Toast.LENGTH_LONG).show();
        	}
        	@Override
        	public void onNothingSelected(AdapterView<?>arg0){
        		
        	}
        });
        button1.setOnClickListener(new OnClickListener(){
    		@Override
    		public void onClick(View v){
    		AlertDialog.Builder alert_dialog=new AlertDialog.Builder(MainActivity.this);
    		alert_dialog.setTitle("Confirmation...");
    		alert_dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
    			@Override
    			public void onClick(DialogInterface dialog,int which){
    			}
    		});
alert_dialog.setPositiveButton("Leavecurrent",new DialogInterface.OnClickListener() {

@Override
public void onClick(DialogInterface dialog, int which) {
	// TODO Auto-generated method stub
	finish();
}
});
alert_dialog.show();
    		
    		}
    		});
    	
}
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
}
