package com.example.dodhackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mealActivity extends Activity {
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   	    setContentView(R.layout.main);
	}

    
    public void mre12_click(View view) {
    	//setContentView(R.layout.meal);
    	MenuListActivity.c = 24;
    	MenuListActivity.database = "MRE2012";
    	Intent i = new Intent(this, MenuListActivity.class);
    	startActivity(i);
    }
    
    
    public void mre13_click(View view) {
    	MenuListActivity.c = 24;
    	MenuListActivity.database = "MRE2013";
    	Intent i = new Intent(this, MenuListActivity.class);
    	startActivity(i);
    }
    
    
    public void fsr08_click(View view) {
    	MenuListActivity.c = 3;
    	MenuListActivity.database = "FSR2008";
        Intent i = new Intent(this, MenuListActivity.class);
    	startActivity(i);
    }
    
    
    public void fsr12_click(View view) {
    	MenuListActivity.c = 9;
    	MenuListActivity.database = "FSR2012";
    	Intent i = new Intent(this, MenuListActivity.class);
    	startActivity(i);
    }
    
    public void mc08_click(View view) {
    	MenuListActivity.c = 12;
    	MenuListActivity.database = "MC2008";
    	Intent i = new Intent(this, MenuListActivity.class);
    	startActivity(i);
    }

}
