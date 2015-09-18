package com.example.test;
import java.util.ArrayList;
import com.example.test.ServiceRun;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class musicplay extends Activity implements AdapterView.OnItemSelectedListener{
TextView tv;
Button pause;
Button resume;
Button stop;
Button back;
int soundselection;
MediaPlayer mediaplayer;
ArrayList<String> list = new ArrayList<String>();
ArrayAdapter<String> dataAdapter;
private int length = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    
	super.onCreate(savedInstanceState);
    setContentView(R.layout.musicplay);
    tv = (TextView) findViewById(R.id.musictext);
    pause = (Button) findViewById(R.id.pause);
    resume = (Button) findViewById(R.id.resume);
    stop = (Button) findViewById(R.id.stop);
    back = (Button) findViewById(R.id.back);
    
    tv.setText("Song.mp3");
    
    /*dataAdapter = new ArrayAdapter<String>(musicplay.this,android.R.layout.simple_list_item_1,list);
    tv.setAdapter(dataAdapter);
    pause.setOnClickListener(new View.OnClickListener() {    
        @Override    
        public void onClick(View v) {    
            switch (soundselection) { 
            case 0:
            	if(mediaplayer.isPlaying())
        		{
        			mediaplayer.pause();
        			length=mediaplayer.getCurrentPosition();}
            }
        }
        });
    
    resume.setOnClickListener(new View.OnClickListener(){
    	@Override
		public void onClick(View v) {
			if(mediaplayer.isPlaying()==false)
		{
			mediaplayer.seekTo(length);
			mediaplayer.start();
		}
		}
	});*/
    
    stop.setOnClickListener(new View.OnClickListener(){
    	@Override
		public void onClick(View v) {
			
    		   //Intent service1 = new Intent(musicplay.this, ServiceRun.class);
				//stopService(service1);
      		   
				String n=getIntent().getExtras().getString("id");
    		
    		    Toast.makeText(musicplay.this,"song stopped",Toast.LENGTH_LONG).show();
    		    }
    });
    
    		/*case 1:   
    			mediaplayer.stop();
    			mediaplayer.release();
    			mediaplayer = null;

    		    Toast.makeText(musicplay.this,"Selected Song:"
        				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();
                break;
    		case 2:    
    			mediaplayer.stop();
    			mediaplayer.release();
    			mediaplayer = null;

    		    Toast.makeText(musicplay.this,"Selected Song:"
        				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();       
                break;
    		case 3:
                //mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.kabhikabhi);    
                mediaplayer.stop();
                mediaplayer.release();
    			mediaplayer = null;

    		    Toast.makeText(musicplay.this,"Selected Song:"
        				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();  
                   
                break;
    		}
    	}
	});*/
  
    back.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View v){
		AlertDialog.Builder alert_dialog=new AlertDialog.Builder(musicplay.this);
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
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	soundselection = arg2;
}

@Override
public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
	
}
}