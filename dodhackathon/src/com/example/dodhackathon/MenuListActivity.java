package com.example.dodhackathon;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.callback.KinveyPingCallback;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.Query;
import com.kinvey.java.User;

import android.R.color;
import android.view.*;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuListActivity extends ListActivity {

	static final String[] s = new String[] {
	"Menu 1", "Menu 2", "Menu 3", "Menu 4", "Menu 5",
	"Menu 6", "Menu 7", "Menu 8", "Menu 9", "Menu 10",
	"Menu 11", "Menu 12", "Menu 13", "Menu 14", "Menu 15",
	"Menu 16", "Menu 17", "Menu 18", "Menu 19", "Menu 20",
	"Menu 21", "Menu 22", "Menu 23", "Menu 24", "Menu 25",
	"Menu 26", "Menu 27", "Menu 28", "Menu 29", "Menu 30",
	};
	
	static int c = 0;
	static String database = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    	//setContentView(R.layout.meal);

		String[] t = new String[c];
		System.arraycopy(s, 0, t, 0, c);
setListAdapter( new ArrayAdapter<String>(this,R.layout.meal, t) );
    	
    	ListView listView = getListView();
    	listView.setBackgroundColor(color.white);
		listView.setTextFilterEnabled(true);
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
				
				load(((TextView)view).getText().toString());
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	
	
	public void load(String s)
	{
		final Client kinveyClient = 
    			new Client.Builder(this.getApplicationContext()).build();	
    	
         kinveyClient.user().login(new KinveyUserCallback() {

    	    @Override
    	    public void onFailure(Throwable error) {
    	    	String TAG = "";
    	        Log.e(TAG, "Login Failure", error);
    	    }

    	    @Override
    	    public void onSuccess(User result) {
    	    	String TAG = "";
    	        Log.i(TAG,"Logged in successfully as " + result.getId());
    	        kinveyClient.ping(new KinveyPingCallback() {

    	            public void onFailure(Throwable t) {
    	            	String TAG = "";
    	                Log.e(TAG, "Kinvey Ping Failed", t);
    	            }

    	            public void onSuccess(Boolean b) {
    	            	String TAG = "";
    	                Log.d(TAG, "Kinvey Ping Success");
    	            }
    	        });
    	    }
    	});
                 
         Query myQuery = kinveyClient.query();
         //myQuery.startsWith("MENU", "MENU 1");
         myQuery.equals("MENU", s.toUpperCase());
         Log.v("", "Checking " + s.toUpperCase());
         
         AsyncAppData<EventEntity> myotherEvents = kinveyClient.appData(database, EventEntity.class);
         
         myotherEvents.get(myQuery, new KinveyListCallback<EventEntity>() {
           @Override
           public void onSuccess(EventEntity[] results) { 
               Log.v("", "received "+ results.length + " events");
               MenuActivity.res = results;
               go();
           }
           @Override
           public void onFailure(Throwable error) { 
               Log.e("", "failed to fetchByFilterCriteria", error);
           }
         });

	}

	static Client kc;
	static String uname;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	public void go()
	{
		MenuActivity.uname = uname;
		MenuActivity.kc = kc;
		Intent i = new Intent( this ,MenuActivity.class);
    	startActivity(i);
	}
	
}
