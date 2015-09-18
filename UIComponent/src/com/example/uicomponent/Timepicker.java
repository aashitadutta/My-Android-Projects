package com.example.uicomponent;

import java.util.Calendar;

import com.example.uicomponent.TimePickerFragment.TimePickedListener;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Timepicker extends FragmentActivity implements TimePickedListener {
private TextView pickedTimeText;
private Button pickTimeButton;
@Override
public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activitymain);
	pickedTimeText = (TextView) findViewById(R.id.text_picked_time);
	pickTimeButton = (Button) findViewById(R.id.button_pick_time);
	pickTimeButton.setOnClickListener(new OnClickListener(){
		public void onClick(View v){
			DialogFragment newFragment=new TimePickerFragment();
			newFragment.show(getSupportFragmentManager(),"timePicker");
		}
	});
}
public void onTimePicked(Calendar time){
	pickedTimeText.setText(DateFormat.format("h:mm a",time));
}
}
