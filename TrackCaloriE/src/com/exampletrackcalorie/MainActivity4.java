package com.exampletrackcalorie;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends Activity {

	 Button bt7,bact8;
	   SQLiteDatabase sq;
	   String cal1,hei,wei,ans,key4;
	    EditText bmi,cal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main4);
		bt7=(Button)findViewById(R.id.button7);
		bact8=(Button)findViewById(R.id.button8_1);
		
		Bundle b = getIntent().getExtras();
		 sq= MainActivity4.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
		 sq.execSQL("create table if not exists userdetail(namedetails varchar2(20),agedetails varchar2(20),sexdetails varchar2(20),heightdetails varchar2(20),weightdetails varchar2(20),usernamedetails varchar2(20),passworddetails varchar2(20),physicalactivitydetails varchar2(20));");
			
		 sq.execSQL("create table if not exists caloriedetail(age varchar2(20),sex varchar2(20),physicalactivity varchar2(20),calorie varchar2(20));");
		 
		
		String key1=b.getString("key1");
		String key2=b.getString("key2");
		String key3=b.getString("key3");
		 key4=b.getString("key4");
		 
					//Toast.makeText(MainActivity4.this,key1+key2+key3,Toast.LENGTH_SHORT).show();
		//fetching height an weight
	        
	        	bmi=(EditText)findViewById(R.id.editText10);
	    		cal=(EditText)findViewById(R.id.editText11);
		
		
		
		Cursor  c3=sq.rawQuery("select heightdetails from userdetail where usernamedetails='"+key4+"';",null);
		if(c3!=null)
		{
			
			if(c3.moveToFirst())
			{
				do
				{
					
				hei= c3.getString(0);
           
            
              
				}while(c3.moveToNext());
			}
			//Toast.makeText(MainActivity4.this,hei,Toast.LENGTH_LONG).show();
			
		
			}
		
		
		Cursor  c31=sq.rawQuery("select weightdetails from userdetail where usernamedetails='"+key4+"';",null);
		if(c31!=null)
		{
			
			if(c31.moveToFirst())
			{
				do
				{
					
				wei= c31.getString(0);
      
				}while(c31.moveToNext());
			}
		//	Toast.makeText(MainActivity4.this,wei,Toast.LENGTH_LONG).show();
			
			}
		

		

       ans=String.valueOf(Float.valueOf(wei) / ((Float.valueOf(hei))));
       bmi.setText(ans);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//fetching calorie
		
		
	
        Cursor c1=sq.rawQuery("select calorie from caloriedetail where age='"+key1+"' and sex='"+key2+"' and physicalactivity = '"+key3+"';", null);
		if(c1!=null)
		{
		
			if(c1.moveToFirst())
			{
				do
				{
				 cal1 = c1.getString(0);
               
				 //Toast.makeText(MainActivity4.this,cal1,Toast.LENGTH_SHORT).show();
				}while(c1.moveToNext());
				
			}
			//Toast.makeText(MainActivity4.this,cal1,Toast.LENGTH_LONG).show();
		}
		
       cal.setText(cal1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        

		         

     
      
    
     // Toast.makeText(MainActivity4.this,key1+key2+key3, Toast.LENGTH_SHORT).show();
     
        
		// sq= MainActivity4.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
		 
		
		bt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity4.this,MainActivity5.class);
				
				i.putExtra("key56",key4);
				i.putExtra("rc2",cal1);
				
				startActivity(i);
				
			}
		});
		bact8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity4.this,MainActivity8.class);
				i.putExtra("bmi",ans);
               i.putExtra("key5",key4);
				i.putExtra("rc",cal1);
				startActivity(i);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity4, menu);
		return true;
	}

}
