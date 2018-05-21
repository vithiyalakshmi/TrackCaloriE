package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity7 extends Activity {

	Button bt9;
	EditText rc;
	String key53,key6,zero="0";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main7);
		bt9=(Button)findViewById(R.id.button9);
		rc=(EditText)findViewById(R.id.editTextre);
		Bundle b = getIntent().getExtras();
		
		key53=b.getString("key52");
		key6=b.getString("key6"); 
		String str= String.valueOf(Float.valueOf(key6) < Float.valueOf(zero));
		//Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();	
		if((key6.equals(zero))||(str.equals("true")))
		{
		
			Intent i=new Intent(MainActivity7.this,MainActivity8.class);
			i.putExtra("key54",key53);
			startActivity(i);
			
		}
			 
		else
		{
		
			rc.setText(key6);
		
		}
		 
	
			
	
		bt9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		
				Intent homeIntent = new Intent(Intent.ACTION_MAIN);
			    homeIntent.addCategory( Intent.CATEGORY_HOME );
			    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
			    startActivity(homeIntent); 
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity7, menu);
		return true;
	}

}
