package com.example.uicomponent;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
	private TimePickedListener mlistener;
	@Override
public Dialog onCreateDialog(Bundle savedInstanceState){
	final Calendar c=Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	return new TimePickerDialog(getActivity(),this,hour,minute,DateFormat.is24HourFormat(getActivity()));
}
	@Override
public void onAttach(Activity activity){
	super.onAttach(activity);
	try{
		mlistener=(TimePickedListener)activity;
	}
	catch(ClassCastException e){
		throw new ClassCastException(activity.toString()+"must implement"+TimePickedListener.class.getName());
	}
}
public void onTimeSet(TimePicker view,int hourOfday,int minute ){
	Calendar c=Calendar.getInstance();
	c.set(Calendar.HOUR_OF_DAY,hourOfday);
	c.set(Calendar.MINUTE,minute);
	mlistener.onTimePicked(c);
}
public static interface TimePickedListener{
	public void onTimePicked(Calendar time);
}
}
