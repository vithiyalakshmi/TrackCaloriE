package com.exampletrackcalorie;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity7 extends Activity {

	EditText ex;
	String key55;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main7);
		ex=(EditText)findViewById(R.id.editTextex);
		Bundle b = getIntent().getExtras();
		
		 key55=b.getString("key54");
		ex.setText(key55);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity7, menu);
		return true;
	}

}
