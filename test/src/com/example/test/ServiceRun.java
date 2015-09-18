package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServiceRun extends Service {
MediaPlayer mp1,mp2,mp3,mp4;
@Override
public IBinder onBind(Intent arg0){
	return null;
}
@Override
public void onCreate(){
	super.onCreate();
	mp1 = MediaPlayer.create(getApplicationContext(),R.raw.dilsere);
	mp2 = MediaPlayer.create(getApplicationContext(),R.raw.humma);
	mp3 = MediaPlayer.create(getApplicationContext(),R.raw.saathiya);
	mp4 = MediaPlayer.create(getApplicationContext(),R.raw.kabhikabhi);
}
@Override
public int onStartCommand(Intent intent,int flags,int startId){
	mp1.start();
	mp2.start();
	mp3.start();
	mp4.start();
	return 0;
}
@Override
public void onDestroy(){
	//int n=Integer.parseInt(getIntent().getExtras().getString("id"));
	mp1.release();
	mp2.release();
	mp3.release();
	mp4.release();
	super.onDestroy();
}



}
