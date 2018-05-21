package com.exampletrackcalorie;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity5 extends Activity {

	Button bt8,bf;
	 RadioGroup radiogroup1;
	 SQLiteDatabase sq;
	 String fn,cal;
	 static String remaincal;
	String qn,key51;
	  String  remainingcalorie,remainingcalorie1;
	 String key6,uname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main5);
		SharedPreferences sharedPref = getSharedPreferences("PREFS_NAME", 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDate = sdf.format(new Date());
        if (sharedPref.getString("LAST_LAUNCH_DATE","nodate").contains(currentDate)){
        	
        	 Bundle b = getIntent().getExtras();
     		key51=b.getString("key56");
     		sq= MainActivity5.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
   		 //sq.execSQL("create table if not exists userdetail(namedetails varchar2(20),agedetails varchar2(20),sexdetails varchar2(20),heightdetails varchar2(20),weightdetails varchar2(20),usernamedetails varchar2(20),passworddetails varchar2(20),physicalactivitydetails varchar2(20));");
   			 sq.execSQL("create table if not exists food(foodname varchar2(20),calories varchar2(20));");
   		sq.execSQL("insert into food values('idly','35');");
   		sq.execSQL("insert into food values('bread slice','45');");
		sq.execSQL("insert into food values('puri','75');");
		sq.execSQL("insert into food values('chapati','60');");
		sq.execSQL("insert into food values('dosa','35');");
		sq.execSQL("insert into food values('tea','45');");
		sq.execSQL("insert into food values('coffee','45');");
		sq.execSQL("insert into food values('soft drinks','90');");
		sq.execSQL("insert into food values('butter','50');");
		sq.execSQL("insert into food values('ghee','50');");
		sq.execSQL("insert into food values('ice cream','200');");
		sq.execSQL("insert into food values('friedchicken','200');");
		sq.execSQL("insert into food values('chinesenoodles','450');");
		sq.execSQL("insert into food values('hamburger','250');");
		sq.execSQL("insert into food values('spaghetti','450');");
		sq.execSQL("insert into food values('pizza','400');");
		sq.execSQL("insert into food values('friedrice','450');");
		sq.execSQL("insert into food values('tomato','18');");
		sq.execSQL("insert into food values('onion','40');");
		sq.execSQL("insert into food values('carrot','41');");
		sq.execSQL("insert into food values('banana','89');");
		sq.execSQL("insert into food values('apple','52');");
		sq.execSQL("insert into food values('mango','60');");
		sq.execSQL("insert into food values('orange','47');");
   		
   	/* sq.execSQL("insert into caloriedetail values('20 ','female ','active','1003');");
   		 sq.execSQL("insert into caloriedetail values('20 ','female ','light','1500');");
   		 sq.execSQL("insert into caloriedetail values('21 ','male ','light','1234');");
   		 sq.execSQL("insert into caloriedetail values('21 ','female ','active','1234');");
   		 sq.execSQL("insert into caloriedetail values('21 ','female ','moderate','1230');"); */
   			radiogroup1 = (RadioGroup) findViewById(R.id.rg1);
   	        radiogroup1.clearCheck();
   	        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
   				@Override
   				public void onCheckedChanged(RadioGroup group, int checkedId) {
   					// TODO Auto-generated method stub
   					 RadioButton rb = (RadioButton) group.findViewById(checkedId);
   		                if (null != rb && checkedId > -1){
   		                	AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
   		                    alert.setMessage("FOODNAME:");
   		                	final EditText foodname= new EditText(MainActivity5.this);
   		                	alert.setView(foodname);
   		                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
   								@Override
   								public void onClick(DialogInterface dialog, int which) {
   									// TODO Auto-generated method stub
   							      fn=foodname.getText().toString();
   									//Toast.makeText(MainActivity5.this,fn,Toast.LENGTH_SHORT).show();
   							        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
   									alert.setMessage("QUANTITY:");
   				                	final EditText quantity=new EditText(MainActivity5.this);
   				                	alert.setView(quantity);
   				                	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
   									@Override
   										public void onClick(DialogInterface dialog, int which) {
   											// TODO Auto-generated method stub
   											qn=quantity.getText().toString();
   									//Toast.makeText(MainActivity5.this,qn,Toast.LENGTH_SHORT).show();
   						                
   											Cursor c=sq.rawQuery("select calories from food where foodname='"+fn+"'",null);
   											int x = c.getCount(); //this will return number of records in current cursor
   											if ( x == 0 ) {
   											     // there are no records
   												Toast.makeText(MainActivity5.this,"sorry no such food exist create your own food",Toast.LENGTH_SHORT).show();

   											}
   									     else {
   												if(c!=null)
   											{
   											if(c.moveToFirst())
   												{
   													do
   													{
   													 cal= c.getString(0);
   									             
   									                //Toast.makeText(MainActivity5.this,cal,Toast.LENGTH_SHORT).show();
   													}
   													while(c.moveToNext());
   												}
   											//Toast.makeText(MainActivity5.this,remaincal,Toast.LENGTH_SHORT).show();
   											
   											}
   											String zero="0";
   											
   			                               String calorieintake=	String.valueOf(Float.valueOf(qn) * Float.valueOf(cal));
   			                            //Toast.makeText(MainActivity5.this,remaincal,Toast.LENGTH_SHORT).show();
   								  remaincal=String.valueOf(Float.valueOf(remaincal) - Float.valueOf(calorieintake));
   								String str= String.valueOf(Float.valueOf(remaincal) < Float.valueOf(zero));	
   								 if(str.equals("true")) 
   								remaincal=zero;
   								 if(remaincal.equals(zero)){
   										
   										Toast.makeText(MainActivity5.this,"you have reached your calorie limit today",Toast.LENGTH_SHORT).show();
   										}	
   											}
   						                	
   						                	
   				                	}
   						                	
   						  
   									});
   				               alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
   								@Override
   										public void onClick(DialogInterface arg0, int arg1) {
   											// TODO Auto-generated method stub
   											
   										}
   									});
   				                	alert.show();
   				              }
   							});
   		                	
   		                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
   								
   								@Override
   								public void onClick(DialogInterface dialog, int which) {
   									// TODO Auto-generated method stub
   									
   									
   								}
   							});	 
   		                	
   		                	alert.show();
   		                 }
   					
   					
   				}

   	        });
   	        
   		bt8=(Button)findViewById(R.id.button8);
   	bt8.setOnClickListener(new OnClickListener() {
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   			Intent i=new Intent(MainActivity5.this,MainActivity6.class);
   				i.putExtra("key6",remaincal);
   				i.putExtra("key52",key51);
   				startActivity(i);
   			}
   			});
   	bf=(Button)findViewById(R.id.buttonF);
    bf.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity5.this,MainActivity9.class);
			i.putExtra("trial1",key51);
			startActivity(i);
			
		}
	});	        
	
    
        	
        }
        else{
        	SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("LAST_LAUNCH_DATE", currentDate);
            editor.commit();
           // final String remainingcalorie;
       Bundle b = getIntent().getExtras();
		key51=b.getString("key56");
		remainingcalorie=b.getString("rc2");
		remainingcalorie1=remainingcalorie;
		
		
		sq= MainActivity5.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
		 //sq.execSQL("create table if not exists userdetail(namedetails varchar2(20),agedetails varchar2(20),sexdetails varchar2(20),heightdetails varchar2(20),weightdetails varchar2(20),usernamedetails varchar2(20),passworddetails varchar2(20),physicalactivitydetails varchar2(20));");
			 sq.execSQL("create table if not exists food(foodname varchar2(20),calories varchar2(20));");
		sq.execSQL("insert into food values('idly','35');");
		sq.execSQL("insert into food values('bread slice','45');");
		sq.execSQL("insert into food values('puri','75');");
		sq.execSQL("insert into food values('chapati','60');");
		sq.execSQL("insert into food values('dosa','35');");
		sq.execSQL("insert into food values('tea','45');");
		sq.execSQL("insert into food values('coffee','45');");
		sq.execSQL("insert into food values('soft drinks','90');");
		sq.execSQL("insert into food values('butter','50');");
		sq.execSQL("insert into food values('ghee','50');");
		sq.execSQL("insert into food values('ice cream','200');");
		sq.execSQL("insert into food values('friedchicken','200');");
		sq.execSQL("insert into food values('chinesenoodles','450');");
		sq.execSQL("insert into food values('hamburger','250');");
		sq.execSQL("insert into food values('spaghetti','450');");
		sq.execSQL("insert into food values('pizza','400');");
		sq.execSQL("insert into food values('friedrice','450');");
		sq.execSQL("insert into food values('tomato','18');");
		sq.execSQL("insert into food values('onion','40');");
		sq.execSQL("insert into food values('carrot','41');");
		sq.execSQL("insert into food values('banana','89');");
		sq.execSQL("insert into food values('apple','52');");
		sq.execSQL("insert into food values('mango','60');");
		sq.execSQL("insert into food values('orange','47');");
		
		
	/* sq.execSQL("insert into caloriedetail values('20 ','female ','active','1003');");
		 sq.execSQL("insert into caloriedetail values('20 ','female ','light','1500');");
		 sq.execSQL("insert into caloriedetail values('21 ','male ','light','1234');");
		 sq.execSQL("insert into caloriedetail values('21 ','female ','active','1234');");
		 sq.execSQL("insert into caloriedetail values('21 ','female ','moderate','1230');"); */
			radiogroup1 = (RadioGroup) findViewById(R.id.rg1);
	        radiogroup1.clearCheck();
	        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					 RadioButton rb = (RadioButton) group.findViewById(checkedId);
		                if (null != rb && checkedId > -1){
		                	AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
		                    alert.setMessage("FOODNAME:");
		                	final EditText foodname= new EditText(MainActivity5.this);
		                	alert.setView(foodname);
		                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
							      fn=foodname.getText().toString();
							        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity5.this);
									alert.setMessage("QUANTITY:");
				                	final EditText quantity=new EditText(MainActivity5.this);
				                	alert.setView(quantity);
				                	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
									@Override
										public void onClick(DialogInterface dialog, int which) {
											// TODO Auto-generated method stub
											qn=quantity.getText().toString();
									//Toast.makeText(MainActivity5.this,qn,Toast.LENGTH_SHORT).show();
						                
											
											Cursor c=sq.rawQuery("select calories from food where foodname='"+fn+"'",null);
											
												if(c!=null)
											{
											if(c.moveToFirst())
												{
													do
													{
													 cal= c.getString(0);
									             
													}
													while(c.moveToNext());
												}
											 String calorieintake=	String.valueOf(Float.valueOf(qn) * Float.valueOf(cal));
												remainingcalorie=String.valueOf(Float.valueOf(remainingcalorie) - Float.valueOf(calorieintake));
												remaincal=remainingcalorie;
											}
												else
												{
													Toast.makeText(MainActivity5.this,"sorry",Toast.LENGTH_SHORT).show();
												}
						                
											
											
											
			                              
									}
										//Toast.makeText(MainActivity5.this,remainingcalorie,Toast.LENGTH_SHORT).show();
											
											
										/*catch(Exception e)
											{
												Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_LONG).show();					
											}*/
											     	
						  
									});
				               alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								@Override
										public void onClick(DialogInterface arg0, int arg1) {
											// TODO Auto-generated method stub
											
										}
									});
				                	alert.show();
				              }
							});
		                	
		                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									
									
								}
							});	 
		                	
		                	alert.show();
		                 }
					
					
				}

	        });
	        bt8=(Button)findViewById(R.id.button8);
	    	bt8.setOnClickListener(new OnClickListener() {
	    			@Override
	    			public void onClick(View arg0) {
	    				// TODO Auto-generated method stub
	    			Intent i=new Intent(MainActivity5.this,MainActivity6.class);
	    				i.putExtra("key6",remainingcalorie);
	    				i.putExtra("key52",key51);
	    				startActivity(i);
	    				}
	    			});
	    	bf=(Button)findViewById(R.id.buttonF);
        bf.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity5.this,MainActivity9.class);
				i.putExtra("trial3",remainingcalorie1);
				i.putExtra("trial4",key51);
				startActivity(i);
				
			}
		});	        
		
        }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity5, menu);
		return true;
	}

}
