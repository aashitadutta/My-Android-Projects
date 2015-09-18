package com.example.test;
 

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class image extends Activity {
	TextView result;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagegrid);
        result = (TextView) findViewById(R.id.textView1);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
 
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
                Toast.makeText(image.this, "" + position,
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), ImageShow.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
                //result.setText("The text is:"+ text);
            }
        });
	}}