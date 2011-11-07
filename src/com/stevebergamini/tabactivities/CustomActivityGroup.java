package com.stevebergamini.tabactivities;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;


public class CustomActivityGroup extends ActivityGroup {
    
    protected ArrayList<View> viewList; // Need this to keep track of the stack.
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        viewList = new ArrayList<View>();
    }
    
    public void replaceContentView(String id, Intent newIntent) {
		View view = getLocalActivityManager()
						.startActivity(id, newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)) 
						.getDecorView();
		viewList.add(view); 
		this.setContentView(view);
	}
  

  /**
   * The primary purpose is to prevent systems before android.os.Build.VERSION_CODES.ECLAIR
   * from calling their default KeyEvent.KEYCODE_BACK during onKeyDown.
   */
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
          //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
          return true;
      }
      return super.onKeyDown(keyCode, event);
  }

  /**
   * Overrides the default implementation for KeyEvent.KEYCODE_BACK 
   * so that all systems call onBackPressed().
   */
  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
          onBackPressed();
          return true;
      }
      return super.onKeyUp(keyCode, event);
  }
  
  /**
   * If a Child Activity handles KeyEvent.KEYCODE_BACK.
   * Simply override and add this method.
   */
  @Override
  public void onBackPressed() {
	  if(viewList.size() > 1) {  
		  viewList.remove(viewList.size()-1);
          setContentView(viewList.get(viewList.size()-1));         
      }else {  
          finish();  
      }  
  }
  
  /**
   * This method finishes all views in the
   * stack except the initial Activity for the given
   * tab
   */
  	public void backToTabInitActivity(){
  		int length = viewList.size();
  		// Need to remove the views in the viewList array
    	for(int i = length; i > 1 ; i-- ){
    		viewList.remove(viewList.size()-1);
    	}
      
    	setContentView(viewList.get(0));  	
  	}
  
}

