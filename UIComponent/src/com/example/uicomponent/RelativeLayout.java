package com.example.uicomponent;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class RelativeLayout extends Activity{
	Button getTime;
	ImageView imageView;
	Spinner spinner;
	TextView timeView;
	CheckBox checkBox;
	RatingBar ratingBar;
	Button back;
	ArrayList<String> list = new ArrayList<String>();
	static final int TIME_DIALOG_ID	 = 999;
	int hour,minute;
	ArrayAdapter<String> dataAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTime = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        spinner = (Spinner) findViewById(R.id.spinner);
        timeView = (TextView) findViewById(R.id.timeView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        back = (Button) findViewById(R.id.exit);
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        list.add("Bangalore");
        list.add("Chennai");
        list.add("Hyderabad");
        list.add("Pune");
        dataAdapter = new ArrayAdapter<String>(RelativeLayout.this,android.R.layout.simple_list_item_1,list);
        spinner.setAdapter(dataAdapter);
        getTime.setOnClickListener(new OnClickListener(){
        	@SuppressWarnings("deprecation")
        	@Override
        	public void onClick(View arg0){
        		showDialog(TIME_DIALOG_ID);
        	}
        });
        spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
        	@Override
        	public void onItemSelected(AdapterView<?>arg0,View
        			arg1, int arg2, long arg3){
        		Toast.makeText(RelativeLayout.this,"Selected City:"
        				+dataAdapter.getItem(arg2), Toast.LENGTH_LONG).show();
        	}
        	@Override
        	public void onNothingSelected(AdapterView<?>arg0){
        		
        	}
        });
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {@Override
       
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        		if(isChecked){
        			Toast.makeText(RelativeLayout.this, "You checked:",Toast.LENGTH_LONG).show();
        		}else{
        			Toast.makeText(RelativeLayout.this, "You unchecked", Toast.LENGTH_LONG).show();
        		}}
        	});
        	ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){
        		@Override
        		public void onRatingChanged(RatingBar ratingBar,float rating,boolean fromUser){
        			Toast.makeText(RelativeLayout.this, "You rated:"+rating, Toast.LENGTH_LONG).show();
        		}
        	});
        	back.setOnClickListener(new OnClickListener(){
        		@Override
        		public void onClick(View v){
        		AlertDialog.Builder alert_dialog=new AlertDialog.Builder(RelativeLayout.this);
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
        protected Dialog onCreateDialog(int id){
        	switch(id){
        	case TIME_DIALOG_ID:
        		return new TimePickerDialog(this,timePickerListener,hour,minute,false);
        	}
        	return null;
        }
        private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
				// TODO Auto-generated method stub
				hour=selectedHour;
				minute = selectedMinute;
				timeView.setText("Time is:"+new StringBuilder().append(hour).append(":").append(minute));
			}
		};
	}
	

	
