package com.example.test;

import android.app.Activity;   
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageShow extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.image_display);
	        
	        // get intent data
	        Intent i = getIntent();
	 
	        // Selected image id
	        int position = i.getExtras().getInt("id");
	        ImageAdapter imageAdapter = new ImageAdapter(this);
	 
	        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
	        imageView.setImageResource(imageAdapter.mThumbIds[position]);
	    }
	 
	}

