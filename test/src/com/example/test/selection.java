package com.example.test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class selection extends Activity{
Button btn1;
Button btn2;
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn1 = (Button) findViewById(R.id.button1);
    btn2 = (Button) findViewById(R.id.button2);
    btn1.setOnClickListener(new View.OnClickListener(){
    	@Override
    	public void onClick(View v){
    		Intent nextIntent = new Intent(selection.this,music.class);
    		startActivity(nextIntent);
    		
    	}
    });
    btn2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
       	 Intent intent = new Intent(selection.this, image.class);
            startActivity(intent);
    	}
    });
}
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}

}
