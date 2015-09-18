package com.example.androiddatabaseapp;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    Intent intent;
    TextView bookId;
    Button btn;
    DBController controller = new DBController(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ArrayList<HashMap<String,String>>bookList=controller.getAllBooks();
		if(bookList.size()!=0){
			ListView l = getListView();
			l.setOnItemClickListener(new OnItemClickListener(){
				public void onItemClick(AdapterView<?> parent,View view,int position, long id){
					bookId=(TextView) view.findViewById(R.id.bookId);
					String valBookId=bookId.getText().toString();
					Intent objIndent =new Intent(getApplicationContext(),EditBook.class);
					objIndent.putExtra("bookId",valBookId);
					startActivity(objIndent);
				}	
			});

ListAdapter adapter = new SimpleAdapter(MainActivity.this,bookList,R.layout.view_book_entry,new String[]{"bookId","bookName"},new int[]{R.id.bookId,R.id.bookName1
			});
			setListAdapter(adapter);
			
		}
	}
	
}
/*			btn = (Button) findViewById(R.id.button1);

			
			btn.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					Intent objIndent=new Intent(getApplicationContext(),NewBook.class);
					startActivity(objIndent);	
				}
			});
			
			
		}
	
	}
		
}*/

		

