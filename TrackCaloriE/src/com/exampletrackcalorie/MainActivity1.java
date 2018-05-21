package com.exampletrackcalorie;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity1 extends Activity {

	Button bt3;
	EditText name,age,sex,height,weight,username,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		
		bt3=(Button)findViewById(R.id.button3);
		name=(EditText)findViewById(R.id.editText1);
		age=(EditText)findViewById(R.id.editText2);
		sex=(EditText)findViewById(R.id.editText3);
		height=(EditText)findViewById(R.id.editText4);
		weight=(EditText)findViewById(R.id.editText5);
		username=(EditText)findViewById(R.id.editText6);
		password=(EditText)findViewById(R.id.editText7);
		
		// sq= MainActivity1.this.openOrCreateDatabase("details",MODE_PRIVATE,null);
	//	 sq.execSQL("create table if not exists userdetails(name varchar2(20),age varchar2(20),sex varchar2(20),height varchar2(20),weight varchar2(20),username varchar2(20),password varchar2(20),physicalactivity varchar2(20));");
         		
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
							
				
				//sq.execSQL("insert into userdetails values('"+n+"','"+a+"','"+s+"','"+h+"','"+w+"','"+u+"','"+p+"');");
                
			/*	try
				{
				Cursor c=sq.rawQuery("select * from userdetails",null);
				if(c!=null)
				{
					if(c.moveToFirst())
					{
						do
						{
						String valueofcol1 = c.getString(5);
		                String valueofcol2 = c.getString(6);
		                Toast.makeText(MainActivity1.this, "NAME= "+valueofcol1 +"AGE= " +valueofcol2,Toast.LENGTH_SHORT).show();
						}
						while(c.moveToNext());
					}
				}
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "error="+e,Toast.LENGTH_SHORT).show();					
				} 
                       */
				String n=name.getText().toString();
				String a=age.getText().toString();
				String s=sex.getText().toString();
				String h=height.getText().toString();
				String w=weight.getText().toString();
				String u=username.getText().toString();
				String p=password.getText().toString();
				
				Intent i=new Intent(getApplicationContext(),MainActivity2.class);
				
				 i.putExtra("name", n);
			        i.putExtra("age",a);
                    i.putExtra("sex",s);
			        i.putExtra("height",h);
			        i.putExtra("weight",w);
			        i.putExtra("username",u);
			        i.putExtra("password",p);
			        startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
	}

}
