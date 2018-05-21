package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity9 extends Activity {

	EditText et1,et2,et3,et4,et5,et6;
	String bmi1,rc1,key50;
	String uw="18.5",no="25";
	Button bt8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main9);
		 Bundle b = getIntent().getExtras();
	  		bmi1=b.getString("bmi");
	  		rc1=b.getString("rc");
	  		key50=b.getString("key5");
	  		Toast.makeText(MainActivity9.this,bmi1,Toast.LENGTH_SHORT).show();
	  		bt8=(Button)findViewById(R.id.button80);
	  		et1=(EditText)findViewById(R.id.editText1);
	  		et2=(EditText)findViewById(R.id.editText2);
	  		et3=(EditText)findViewById(R.id.editText3);
	  		et4=(EditText)findViewById(R.id.editText4);
	  		et5=(EditText)findViewById(R.id.editText5);
	  		et6=(EditText)findViewById(R.id.editText6);
	  		String str= String.valueOf(Float.valueOf(bmi1) < Float.valueOf(uw));	
	  		if(str.equals("true")) 
	  		{
	  	  		Toast.makeText(MainActivity9.this,"underweight",Toast.LENGTH_SHORT).show();
	  	  		et1.setText("fruit salad");
	  	  		et3.setText("2 cup of rice");
	  	  		et5.setText("2 cup of rice");
	  		}
	  		String str1= String.valueOf(Float.valueOf(bmi1) > Float.valueOf(uw));
	  		String str2= String.valueOf(Float.valueOf(bmi1) <Float.valueOf(no));
	  		if(str1.equals("true")&& str2.equals("true"))
	  		{
	  			Toast.makeText(MainActivity9.this,"normal",Toast.LENGTH_SHORT).show();
	  			et1.setText("fruit salad");
	  	  		et3.setText("1 1/2 cup of rice");
	  	  		et5.setText("1 cup of rice");

	  		}
	  		String str3=String.valueOf(Float.valueOf(bmi1) > Float.valueOf(no));
	  		if(str3.equals("true"))
	  		{
	  			Toast.makeText(MainActivity9.this,"overweight",Toast.LENGTH_SHORT).show();
	  			et1.setText("fruit salad");
	  	  		et3.setText("1 cup of rice");
	  	  		et5.setText("chapattti");
	  		}
	  		
	  		bt8.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(MainActivity9.this,MainActivity6.class);
					i.putExtra("key56",key50);
					i.putExtra("rc2",rc1);
					startActivity(i);
					
				}
			});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity9, menu);
		return true;
	}

}
