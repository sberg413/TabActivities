package com.stevebergamini.tabactivities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Tab2SecondActivity extends Activity {
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_content);
        
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText("Tab 2 - Second Activity");
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("2");
        
        Button button = (Button) findViewById(R.id.button1);
        button.setVisibility(View.GONE);        
        
    }
	
}
