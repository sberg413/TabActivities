package com.stevebergamini.tabactivities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Resources res = getResources(); // Resource object to get Drawables
        final TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        intent = new Intent().setClass(this, Tab1GroupActivity.class);
        spec = tabHost.newTabSpec("one").setIndicator("One").setContent(intent);
		tabHost.addTab(spec);
		
        intent = new Intent().setClass(this, Tab2GroupActivity.class);
        spec = tabHost.newTabSpec("two").setIndicator("Two").setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
    }
}