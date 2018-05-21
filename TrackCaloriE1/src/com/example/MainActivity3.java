package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity3 extends Activity {

	Button bt4,bt5;
	SQLiteDatabase sq;
	RadioGroup radiogroup2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		 sq= MainActivity3.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
		 sq.execSQL("create table if not exists userdetail(namedetails varchar2(20),agedetails varchar2(20),sexdetails varchar2(20),heightdetails varchar2(20),weightdetails varchar2(20),usernamedetails varchar2(20),passworddetails varchar2(20),physicalactivitydetails varchar2(20));");
		
		
		
        	
		 radiogroup2 = (RadioGroup) findViewById(R.id.rg2);
	        radiogroup2.clearCheck();
	        radiogroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
	        	
				

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					
					RadioButton rb = (RadioButton) group.findViewById(checkedId);
	                if (null != rb && checkedId > -1){
	                	String checked=rb.getText().toString();
	                	
	                	 Bundle b = getIntent().getExtras();
	                 	String n1=b.getString("name");
	                 	String a1=b.getString("age");
	                 	String s1=b.getString("sex");
	                 	String h1=b.getString("height");
	                 	String w1=b.getString("weight");
	                 	String u1=b.getString("username");
	                 	String p1=b.getString("password");
	                 //	Toast.makeText(MainActivity2.this, n1+p1+u1, Toast.LENGTH_SHORT).show();
	                 	sq.execSQL("insert into userdetail values('"+n1+"','"+a1+"','"+s1+"','"+h1+"','"+w1+"','"+u1+"','"+p1+"','"+checked+"');");
	 	                
	                	
	                   // Toast.makeText(MainActivity2.this,n1+a1,Toast.LENGTH_SHORT).show();
	                   	
	                   	
	           			
	                   
	                /* 	try
	    				{
	    				Cursor c=sq.rawQuery("select * from userdetail",null);
	    				if(c!=null)
	    				{
	    					if(c.moveToFirst())
	    					{
	    						do
	    						{
	    						String valueofcol1 = c.getString(6);
	    		                String valueofcol2 = c.getString(7);
	    		                Toast.makeText(MainActivity2.this, "NAME= "+valueofcol1 +"AGE= " +valueofcol2,Toast.LENGTH_SHORT).show();
	    						}
	    						while(c.moveToNext());
	    					}
	    				}
	    				}
	    				catch(Exception e)
	    				{
	    					Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
	    				} */
	                	 
	             // Toast.makeText(MainActivity2.this,checked,Toast.LENGTH_SHORT).show();
	                }

               	
				}
				
				 
			});
	
	      
        

		bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(MainActivity3.this,MainActivity2.class);
				startActivity(i);
				
			}
		});
		bt5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(MainActivity3.this,MainActivity4.class);
				
				startActivity(i);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity3, menu);
		return true;
	}

}
