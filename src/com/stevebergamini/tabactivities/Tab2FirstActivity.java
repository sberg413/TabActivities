package com.stevebergamini.tabactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Tab2FirstActivity extends Activity {
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_content);   
        
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Tab 2 - First Activity.");
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("1");
        
        Button button = (Button) findViewById(R.id.button1);        
        button.setOnClickListener( new OnClickListener(){

			public void onClick(View v) {
				
				Intent intent = new Intent(Tab2FirstActivity.this, Tab2SecondActivity.class);	            
	            CustomActivityGroup parentActivity = (CustomActivityGroup)getParent();
				parentActivity.replaceContentView("one", intent);
				
				
			}
		});
        
    }
	
}
