package com.exampletrackcalorie;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity9 extends Activity {

	String trial2,trial5,trial6;
	Button b1,b2;
	EditText e1,e2;
	SQLiteDatabase sq;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main9);
		
		e1=(EditText)findViewById(R.id.editTextc);
		e2=(EditText)findViewById(R.id.editTextf);
		SharedPreferences sharedPref = getSharedPreferences("PREFS_NAME", 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDate = sdf.format(new Date());
        if (sharedPref.getString("LAST_LAUNCH_DATE","nodate").contains(currentDate)){
        	 sq= MainActivity9.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
    		 sq.execSQL("create table if not exists food(foodname varchar2(20),calories varchar2(20));");
    		 
        	Bundle b=getIntent().getExtras();
        	trial2=b.getString("trial1");
        	b2=(Button)findViewById(R.id.buttonR);
        	b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.myfitnesspal.com/food/calorie-chart-nutrition-facts"));
		            startActivity(i);
		
				}
			});
        	b1=(Button)findViewById(R.id.buttonO);
        	 b1.setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View arg0) {
     				// TODO Auto-generated method stub
     				
     				String food=e1.getText().toString();
     				String cal=e2.getText().toString();
     				Toast.makeText(MainActivity9.this,food+cal,Toast.LENGTH_SHORT).show();
     				 sq.execSQL("insert into food values('"+food+"','"+cal+"');");
     				 Intent i=new Intent(MainActivity9.this,MainActivity5.class);
     				 i.putExtra("key56",trial2);
     				 startActivity(i);
     			}
     		});
        }
        else
        {
        	 sq= MainActivity9.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
    		 sq.execSQL("create table if not exists food(foodname varchar2(20),calories varchar2(20));");
    		 

        	Bundle b=getIntent().getExtras();
        	trial5=b.getString("trial3");
        	
        	trial6=b.getString("trial4");
        	b2=(Button)findViewById(R.id.buttonR);
        	b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.myfitnesspal.com/food/calorie-chart-nutrition-facts"));
		            startActivity(i);
		
				}
			});
        	b1=(Button)findViewById(R.id.buttonO);		
		 b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String food=e1.getText().toString();
				String cal=e2.getText().toString();
				 sq.execSQL("insert into food values('"+food+"','"+cal+"');");
				 Intent i=new Intent(MainActivity9.this,MainActivity5.class);
				 i.putExtra("rc2",trial5);
				 i.putExtra("key56",trial6);
				 startActivity(i);
			}
		});
        }	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity9, menu);
		return true;
	}

}
