package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends Activity {

	Button bt6;
	EditText uname,pass;
	SQLiteDatabase sq;
	String un;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main4);
		bt6=(Button)findViewById(R.id.button6);
		uname=(EditText)findViewById(R.id.editText8);
		

		pass=(EditText)findViewById(R.id.editText9);
		// sq.execSQL("create table if not exists userdetail(namedetails varchar2(20),agedetails varchar2(20),sexdetails varchar2(20),heightdetails varchar2(20),weightdetails varchar2(20),usernamedetails varchar2(20),passworddetails varchar2(20),physicalactivitydetails varchar2(20));");
		
		 sq= MainActivity4.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
		 sq.execSQL("create table if not exists userdetail(namedetails varchar2(20),agedetails varchar2(20),sexdetails varchar2(20),heightdetails varchar2(20),weightdetails varchar2(20),usernamedetails varchar2(20),passworddetails varchar2(20),physicalactivitydetails varchar2(20));");
			

		 sq.execSQL("create table if not exists caloriedetail(age varchar2(20),sex varchar2(20),physicalactivity varchar2(20),calorie varchar2(20));");
		
		  sq.execSQL("insert into caloriedetail values('20 ','female ','MODERATE','1236');");
	 sq.execSQL("insert into caloriedetail values('20 ','female ','ACTIVE','1003');");
		 sq.execSQL("insert into caloriedetail values('20 ','female ','LIGHT','1500');");
		 sq.execSQL("insert into caloriedetail values('21 ','male ','LIGHT','1234');");
		 sq.execSQL("insert into caloriedetail values('21 ','female ','ACTIVE','1234');");
		 sq.execSQL("insert into caloriedetail values('21 ','female ','MODERATE','1230');"); 
			
			 
			 			 
			 
			 
			 
			 	
		
		 
		bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 un=uname.getText().toString();
				String pa=pass.getText().toString();
			/*	SharedPreferences sharedPref = getSharedPreferences("PREFS_NAME", 0);
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		        String currentDate = sdf.format(new Date());
								
		        if (sharedPref.getString("LAST_LAUNCH_DATE","nodate").contains(currentDate)){
		            // Date matches. User has already Launched the app once today. So do nothing.
		        	try
					{
					Cursor  c=sq.rawQuery("select passworddetails from userdetail where usernamedetails='"+un+"';",null);
					if(c!=null)
					{
						String getting=null;
						if(c.moveToFirst())
						{
							do
							{
								
							getting = c.getString(0);
			             //  String valueofcol6 = c.getString(6);
			            // Toast.makeText(MainActivity3.this,getting,Toast.LENGTH_SHORT).show();
			              
							}while(c.moveToNext());
						}
						 if(pa.equals(getting)){
	           	          
		            		   
							 		            	  Toast.makeText(MainActivity3.this,"successful",Toast.LENGTH_SHORT).show();
			                
			                	
						 

		        	Intent i=new Intent(MainActivity3.this,MainActivity5.class);
		        	i.putExtra("username",un);
		        	startActivity(i);
						 }
		        			
					       else
							 {
								 Toast.makeText(MainActivity3.this,"password and username you entered is wrong",Toast.LENGTH_SHORT).show();
							 } 
						}
						else
						{
							Toast.makeText(MainActivity3.this,"fill the above fields completly",Toast.LENGTH_SHORT).show();
						}
						
						}
						catch(Exception e)
						{
							Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
						} */
							
							
		        
		//	Toast.makeText(MainActivity3.this,un + pa,Toast.LENGTH_SHORT).show();
		        
		        
		        
		        	
		        
				try
				{
				Cursor  c1=sq.rawQuery("select passworddetails from userdetail where usernamedetails='"+un+"';",null);
				if(c1!=null)
				{
					String getting1=null;
					if(c1.moveToFirst())
					{
						do
						{
							
						getting1 = c1.getString(0);
		             //  String valueofcol6 = c.getString(6);
		            // Toast.makeText(MainActivity3.this,getting,Toast.LENGTH_SHORT).show();
		              
						}while(c1.moveToNext());
					}
					 if(pa.equals(getting1)){
           	          
	            		   
						 		            	  Toast.makeText(MainActivity4.this,"successful",Toast.LENGTH_SHORT).show();
		                	Intent i=new Intent(MainActivity4.this,MainActivity5.class);
					
					

						
		 
					 

					 
		                	
		                	
		                	  			//1st arg		
		        						
		        				
		        			try
		        			{
		        			Cursor  c4=sq.rawQuery("select agedetails from userdetail where usernamedetails='"+un+"';",null);
		        			if(c4!=null)
		        			{
		        				String age1=null;
		        				if(c4.moveToFirst())
		        				{
		        					do
		        					{
		        						
		        					age1= c4.getString(0);
		        	             //  String valueofcol6 = c.getString(6);
		        	            // Toast.makeText(MainActivity3.this,valueofcol5+valueofcol6,Toast.LENGTH_SHORT).show();
		        	              
		        					}while(c4.moveToNext());
		        				}
		        				i.putExtra("key1",age1);
		        			
		        			
		        				
		        				}
		        			//2nd arg

		        			try
		        			{
		        			Cursor  c2=sq.rawQuery("select sexdetails from userdetail where usernamedetails='"+un+"';",null);
		        			if(c2!=null)
		        			{
		        				String sex1=null;
		        				if(c2.moveToFirst())
		        				{
		        					do
		        					{
		        						
		        					sex1= c2.getString(0);
		        	             //  String valueofcol6 = c.getString(6);
		        	            // Toast.makeText(MainActivity3.this,valueofcol5+valueofcol6,Toast.LENGTH_SHORT).show();
		        	              
		        					}while(c2.moveToNext());
		        				}
		        				i.putExtra("key2",sex1);
		        				}
		        			
	//3rd arg
		        			
		        			try
		        			{
		        			Cursor  c3=sq.rawQuery("select physicalactivitydetails from userdetail where usernamedetails='"+un+"';",null);
		        			if(c3!=null)
		        			{
		        				String phy1=null;
		        				if(c3.moveToFirst())
		        				{
		        					do
		        					{
		        						
		        					phy1= c3.getString(0);
		        	           
		        	            
		        	              
		        					}while(c3.moveToNext());
		        				}
		        				i.putExtra("key3",phy1);
		        				}
		        			}
		        			catch(Exception e)
		        			{
		        				Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
		        			} 

		        			
		        			
		        			}
		        			catch(Exception e)
		        			{
		        				Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
		        			} 
		        			
		        			
		        			
		        			
		        			
		        			
		        			}
		        			catch(Exception e)
		        			{
		        				Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
		        			} 
		        			i.putExtra("key4",un);
		        			startActivity(i);
		        			
		        			
					 }
	        			
				       else
						 {
							 Toast.makeText(MainActivity4.this,"password and username you entered is wrong",Toast.LENGTH_SHORT).show();
						 } 
					}
					else
					{
						Toast.makeText(MainActivity4.this,"fill the above fields completly",Toast.LENGTH_SHORT).show();
					}
					
					}
					catch(Exception e)
					{
						Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
					} 
						
						
					

						
		 
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
