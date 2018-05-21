package com.example;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView t1,t2;
	int flag=0;
	EditText e1,e2;
	Button b;
	 String uname[]={"vithiya","divya","uma","siva"};
     String pass[]={"vithu","deepu","nagama","charles"};
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView1);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 String username=e1.getText().toString();
			        String password=e2.getText().toString();
			       for(int i=0;i<4;i++){
			    	  
			    	if((username.equalsIgnoreCase(uname[i]))&&(password.equalsIgnoreCase(pass[i]))){
			    		
			    	 Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();
			    	 flag=1;
			    	 
			    	}
			    	 
			    	 
			       }
			       if(flag==0){
			    	  Toast.makeText(getApplicationContext(),"invalid username and password",Toast.LENGTH_LONG).show();
			       }
			        		
				
			}
		});
       
        }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
