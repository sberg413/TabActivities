package com.stevebergamini.tabactivities;

import android.content.Intent;
import android.os.Bundle;


/**
 * @author Steve Bergamini
 * 
 */
public class Tab2GroupActivity extends CustomActivityGroup{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        Intent intent = new Intent(this, Tab2FirstActivity.class );		
		this.replaceContentView("two", intent);
    }
}
