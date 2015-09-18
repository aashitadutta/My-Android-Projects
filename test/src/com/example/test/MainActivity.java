package com.example.test;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView text;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.front);
		text = (TextView) findViewById(R.id.textView1);
		btn=(Button) findViewById(R.id.button1);
		
	
		 btn.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 Intent intent = new Intent(MainActivity.this, selection.class);
                 startActivity(intent);
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
