package com.example.uicomponent;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
EditText textField;
Button submit;
Button next;
TextView result;
String text;
Button showNotification;
public LinearLayout activity;
long when;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        textField = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.button);
        next = (Button) findViewById(R.id.buttonNext);
        result = (TextView) findViewById(R.id.textView);
        showNotification = (Button) findViewById(R.id.showNotification);
        when = System.currentTimeMillis();
        submit.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View arg0){
        		text = textField.getText().toString();
        		result.setText("The text is:"+ text);
        	}
        });	
        next.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View arg0){
        		Intent nextIntent = new Intent(MainActivity.this,RelativeLayout.class);
        		startActivity(nextIntent);
        		
        	}
        });
        showNotification.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){ 
        		showNotification();
        	}
    });
        
    }
        
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
    	MenuInflater inflater=getMenuInflater();
    	inflater.inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.first:
    		showNotification();
    		return true;
    	case R.id.second:
    		startActivity(new Intent(this,RelativeLayout.class));
    		return true;
    	}
    	return false;
    	}
    @SuppressWarnings("deprecation")
    public void showNotification(){
    	NotificationManager notificationManager = (NotificationManager)MainActivity.this.
    			getSystemService(Context.NOTIFICATION_SERVICE);
    	Intent intent = new Intent(this,MainActivity.class);
    	intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    	PendingIntent contentIntent = PendingIntent.getActivity(this,0,intent,0);
    	Notification notification  = new Notification(R.drawable.ic_launcher,"New Message",when);
    	notification.ledARGB = Color.RED;
    	notification.ledOffMS = 300;
    	notification.ledOnMS=300;
    	notification.defaults |= Notification.DEFAULT_SOUND;
    	notification.defaults |= Notification.DEFAULT_LIGHTS;
    	notification.flags |= Notification.FLAG_AUTO_CANCEL | Notification.FLAG_SHOW_LIGHTS;
    	notification.setLatestEventInfo(this, "Notification", "This is status bar notification", contentIntent);
    	notificationManager.notify(10001,notification);
    }
    @Override
    public void onClick(View v){
    	
    }
    }
    
    

