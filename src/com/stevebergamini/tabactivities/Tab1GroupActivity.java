package com.stevebergamini.tabactivities;

import android.content.Intent;
import android.os.Bundle;


/**
 * @author Steve Bergamini 
 *
 */
public class Tab1GroupActivity extends CustomActivityGroup{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        Intent intent = new Intent(this, Tab1FirstActivity.class );		
		this.replaceContentView("one", intent);
    }
}
