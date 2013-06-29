package com.example.dodhackathon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.java.Query;
import com.kinvey.java.core.KinveyClientCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity);
    	
	}
	static Client kinveyClient;
	static String uname;
	
	private void UpdateTodaysActivityLevel (final Client mKinveyClient, String userId, final String activityLevel){
		//Get Todays date
		
		CalorieEntry qce = new CalorieEntry();
		Query myQuery = mKinveyClient.query();
		myQuery.equals("userId", userId);
		Calendar calendar = Calendar.getInstance();       
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	    sdf.setTimeZone(TimeZone.getTimeZone("America/Boston"));
	    Log.v("", "DATE: " +sdf.format(calendar.getTime()));
	    
		myQuery.equals("date",sdf.format(calendar.getTime()));
		AsyncAppData<CalorieEntry> myEvents = mKinveyClient.appData("CALORIES", CalorieEntry.class);
		
		myEvents.get(new KinveyListCallback<CalorieEntry>() {
			  @Override
			  public void onSuccess(CalorieEntry[] results) { 
			      Log.v("", "received" + results.length);
			      CalorieEntry ceResult = results[0];
			      Log.v("", "Calories UpdateAL" + ceResult.getCalories());
			      ceResult.setActivityLevel(activityLevel);
			      InsertCalories(mKinveyClient, ceResult);
			  }
			  @Override
			  public void onFailure(Throwable error) { 
			      Log.e("", "failed to fetchByFilterCriteria", error);
			  }
			});
	}

	private void InsertCalories(Client mKinveyClient, CalorieEntry ce){
		AsyncAppData<CalorieEntry> myevents = mKinveyClient.appData("CALORIES", CalorieEntry.class);
		myevents.save(ce, new KinveyClientCallback<CalorieEntry>() {
		  @Override
		  public void onFailure(Throwable e) {
		      Log.e("ERROR", "failed to save event data"); 
		  }
		  @Override
		  public void onSuccess(CalorieEntry r) {
			  Log.d("INFO", "Calories (InsertCalories)" + r.getCalories());
			  Log.d("INFO", "saved data for entity "); 
		  }
		});
	}
	

	//3000   2200
	//3250   2300
	//3950   2700
	//4600   3150
	
	static boolean male = true;
	    
	    public void workoutl(View v)
	    {
	    	UpdateTodaysActivityLevel(kinveyClient, uname, "light");
	    	if(male)
	    	{
	    		MainActivity.top = "3000";
	    		MainActivity.bottom = "3000";
	    	}
	    	else
	    	{
	    		MainActivity.top = "2200";
	    		MainActivity.bottom = "2200";
	    	}
	    	Intent i = new Intent(this, MainActivity.class);
	    	startActivity(i);
	    }
	    
	    public void workoutm(View v)
	    {
	    	UpdateTodaysActivityLevel(kinveyClient, uname, "moderate");
	    	if(male)
	    	{
	    		MainActivity.top = "3250";
	    		MainActivity.bottom = "3250";
	    	}
	    	else
	    	{
	    		MainActivity.top = "2300";
	    		MainActivity.bottom = "2300";
	    	}
	    	Intent i = new Intent(this, MainActivity.class);
	    	startActivity(i);
	    }
	    
	    public void workouth(View v)
	    {
	    	UpdateTodaysActivityLevel(kinveyClient, uname, "heavy");
	    	if(male)
	    	{
	    		MainActivity.top = "3950";
	    		MainActivity.bottom = "3950";
	    	}
	    	else
	    	{
	    		MainActivity.top = "2700";
	    		MainActivity.bottom = "2700";
	    	}
	    	Intent i = new Intent(this, MainActivity.class);
	    	startActivity(i);
	    }
	    
	    public void workoute(View v)
	    {
	    	UpdateTodaysActivityLevel(kinveyClient, uname, "extreme");
	    	if(male)
	    	{
	    		MainActivity.top = "4600";
	    		MainActivity.bottom = "4600";
	    	}
	    	else
	    	{
	    		MainActivity.top = "3150";
	    		MainActivity.bottom = "3150";
	    	}
	    	Intent i = new Intent(this, MainActivity.class);
	    	startActivity(i);
	    }

}
