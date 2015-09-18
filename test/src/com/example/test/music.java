package com.example.test;
import java.util.ArrayList;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class music extends Activity{
	Button stop;
	Button pause;
	Button resume;
	Spinner spinner1;
	TextView textView2;
	int soundselection;
	private int length=0;
MediaPlayer mediaplayer;
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> dataAdapter;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        textView2 = (TextView) findViewById(R.id.textView2);
        stop=(Button) findViewById(R.id.button1);
        pause=(Button) findViewById(R.id.button2);
        resume=(Button) findViewById(R.id.button3);
        list.add("Select Song");
        list.add("dilsere");
        list.add("humma");
        list.add("saathiya");
        list.add("kabhikabhi");
        dataAdapter = new ArrayAdapter<String>(music.this,android.R.layout.simple_list_item_1,list);
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){
        	@Override
        	public void onItemSelected(AdapterView<?>arg0,View
        			arg1, int arg2, long arg3){
        		//Intent nextIntent = new Intent(music.this,musicplay.class);
        		//nextIntent.putExtra("id",arg2);
        		//startActivity(nextIntent);
        		//mediaplayer.create(getApplicationContext(),dataAdapter);
        		
        		soundselection=arg2;
        		switch (soundselection) {
        		case 1:
        			mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.dilsere);
        		    mediaplayer.start();
        		    mediaplayer.setVolume(100,100);
        		    mediaplayer.setLooping(true);
        		    Toast.makeText(music.this,"Selected Song:"
            				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();
        		    break;
        		case 2:
        			
        			mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.humma);    
                 	mediaplayer.start();   
                    
                    mediaplayer.setVolume(100,100);
        		    mediaplayer.setLooping(true);
                    Toast.makeText(music.this,"Selected Song:"
            				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();    
                       
                    break;
        		case 3:
        			mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.saathiya);    
                    mediaplayer.start(); 
                    mediaplayer.setVolume(100,100);
        		    mediaplayer.setLooping(true);
                    Toast.makeText(getApplicationContext(), "saathiya", Toast.LENGTH_LONG).show();        
                    break;
        		case 4:
                    mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.kabhikabhi);    
                    mediaplayer.start();    
                    mediaplayer.setVolume(100,100);
        		    mediaplayer.setLooping(true);
                    Toast.makeText(getApplicationContext(), "kabhikabhi", Toast.LENGTH_LONG).show();    
                       
                    break;
        		}
        	
         
        	}
        	@Override
        	public void onNothingSelected(AdapterView<?>arg0){
        		
        	}
        });
	
	 stop.setOnClickListener(new View.OnClickListener(){
	    	@Override
			public void onClick(View v) {
	 
	    if (mediaplayer.isPlaying()){
	    mediaplayer.reset();
	    Toast.makeText(getApplicationContext(), "Song Stopped", Toast.LENGTH_LONG).show();
	    } 
	    	}
	 });
	 pause.setOnClickListener(new View.OnClickListener() {    
	        @Override    
	        public void onClick(View v) {  
	        	if(mediaplayer.isPlaying())
        		{
        			mediaplayer.pause();
        			length=mediaplayer.getCurrentPosition();
        			Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_LONG).show();}
            }
        
        });	
	        
	 resume.setOnClickListener(new View.OnClickListener(){
	    	@Override
			public void onClick(View v) {
				if(mediaplayer.isPlaying()==false)
			{
				mediaplayer.seekTo(length);
				mediaplayer.start();
				Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_LONG).show();
			}
			}
		});
	 }}
