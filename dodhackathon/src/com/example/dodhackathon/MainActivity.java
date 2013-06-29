package com.example.dodhackathon;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.callback.KinveyPingCallback;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.Query;
import com.kinvey.java.User;
import com.kinvey.java.core.KinveyClientCallback;
import com.kinvey.java.model.KinveyMetaData;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class MainActivity extends Activity {
	//3000   2200
	//3250   2300
	//3950   2700
	//4600   3150

	static String top = "", bottom="";
	static float thresh = 3000.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	setContentView(R.layout.home);
        
    	//TextView c1 = (TextView)findViewById(R.id.Display);
    	//TextView c2 = (TextView)findViewById(R.id.Display2);
    	
    	//c1.setText(top);
    	//c2.setText(bottom);


    	//kinveyClient
    	
    	
        //int weee = this;
        
       // ListView myListView = (ListView)findViewById(R.id.myListView);

       
        //"kid_PeLlxhoN1J", "d8cdfff42e084f9e8eb5ec60fef82562", 
        /*final Client kinveyClient = 
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
         
         EventEntity event = new EventEntity();
         AsyncAppData<EventEntity> myEvents = kinveyClient.appData("FirstStrikeRationMenus2012", EventEntity.class);
         String eventID = "51ce1ed974ccc32f600003e0";
         
         myEvents.getEntity(eventID, new KinveyClientCallback<EventEntity>() {
        	  @Override
        	  public void onSuccess(EventEntity result) { 
        	      Log.v("", "received "+ result.getId() );
        	      Log.v("", "received "+ result.CALORIES );
        	  }
        	  @Override
        	  public void onFailure(Throwable error) { 
        	      Log.e("", "failed to fetchByFilterCriteria", error);
        	  }
        	});
        
         Query myQuery = kinveyClient.query();
         //myQuery.startsWith("MENU", "MENU 1");
         myQuery.equals("MENU", "MENU 1");
         
         AsyncAppData<EventEntity> myotherEvents = kinveyClient.appData("FirstStrikeRationMenus2012", EventEntity.class);
         
         myotherEvents.get(myQuery, new KinveyListCallback<EventEntity>() {
           @Override
           public void onSuccess(EventEntity[] results) { 
               Log.v("", "received "+ results.length + " events");
               //
               String[] ma = new String[100];
               for (int i = 0; i < results.length; i++)
               {
            	   ma[i] = results[i].MENU;   
               }
               //setListAdapter(new ArrayAdapter<String>(R.layou, ma));
//               myFunc(ma);
           }
           @Override
           public void onFailure(Throwable error) { 
               Log.e("", "failed to fetchByFilterCriteria", error);
           }
         });
         
         */
    }
    

    @Override
    protected void onResume() {
        super.onResume();
        
        setContentView(R.layout.home);
        
    	TextView c1 = (TextView)findViewById(R.id.Display);
    	TextView c2 = (TextView)findViewById(R.id.Display2);
    	
    	c1.setText(top);
    	c2.setText(bottom);
    	ImageView f3 = (ImageView)findViewById(R.id.imageView1);
    	
    	float f1 = Float.parseFloat(top);
    	float f2 = Float.parseFloat(bottom);
    	
    	float diff = f1 / 6;
    	
    	if(f2 == f1)
    		f3.setImageResource(R.drawable.level06);
    	else if(f2 < diff)
    		f3.setImageResource(R.drawable.level05);
    	else if(f2 < 2* diff)
    		f3.setImageResource(R.drawable.level04);
    	else if(f2 < 3 * diff)
    		f3.setImageResource(R.drawable.level03);
    	else if(f2 < 4 * diff)
    		f3.setImageResource(R.drawable.level02);
    	else if(f2 < 5 * diff)
    		f3.setImageResource(R.drawable.level01);
    	else if(f2 >= 6 * diff )
    		f3.setImageResource(R.drawable.level00);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
        
    static Client kinveyClient;
    static String uname;
    
	
    public void mealclick(View view)
    {
    	Intent i = new Intent(this, mealActivity.class);
    	startActivity(i);
    }
    
    public void chartclick(View view)
    {
    	setContentView(R.layout.chart);
    }
    
    public void rchartclick(View view)
    {
    	setContentView(R.layout.home);
    	Bundle tempBundle = new Bundle();
    	onCreate(tempBundle);
    }
    
    public void reload()
    {
    	Bundle tempBundle = new Bundle();
    	onCreate(tempBundle);
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.squad1:
            	sq1click(findViewById(R.id.squad1));
                return true;
            case R.id.squad2:
            	sq2click(findViewById(R.id.squad2));
                return true;
            case R.id.platoon:
            	plclick(findViewById(R.id.platoon));
            	return true;
            case R.id.data:
            	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nutritiondata.self.com"));
            	startActivity(browserIntent);
            	return true;
            case R.id.facts:
            	Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nutri-facts.com"));
            	startActivity(browserIntent2);
            	return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    
    public void sq1click(View v)
    {
    	final ImageView i = new ImageView(this);
    	i.setImageResource(R.drawable.squad01);

    	((RelativeLayout)findViewById(R.id.fake)).setVisibility(View.GONE);
    	((RelativeLayout)findViewById(R.id.dad)).addView(i);
    	
    	final Button b = new Button(this);
    	b.setText("Go Back");
    	b.setWidth(200);
    	b.setHeight(200);
    	b.setX(300);
    	b.setY(600);
    	b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				b.setVisibility(View.GONE);
				i.setVisibility(View.GONE);
				((RelativeLayout)findViewById(R.id.fake)).setVisibility(View.VISIBLE);
			}
    	});
    	
    	((RelativeLayout)findViewById(R.id.dad)).addView(b);
    }
    
    public void sq2click(View v)
    {
    	final ImageView i = new ImageView(this);
    	i.setImageResource(R.drawable.squad02);

    	((RelativeLayout)findViewById(R.id.fake)).setVisibility(View.GONE);
    	((RelativeLayout)findViewById(R.id.dad)).addView(i);
    	
    	final Button b = new Button(this);
    	b.setText("Go Back");
    	b.setWidth(200);
    	b.setHeight(200);
    	b.setX(300);
    	b.setY(600);
    	b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				b.setVisibility(View.GONE);
				i.setVisibility(View.GONE);
				((RelativeLayout)findViewById(R.id.fake)).setVisibility(View.VISIBLE);
			}
    	});
    	
    	((RelativeLayout)findViewById(R.id.dad)).addView(b);
    }
    
    public void plclick(View v)
    {
    	final ImageView i = new ImageView(this);
    	 
    	 
    	i.setImageResource(R.drawable.platoonview);
    	((RelativeLayout)findViewById(R.id.fake)).setVisibility(View.GONE);
    	((RelativeLayout)findViewById(R.id.dad)).addView(i);
    	
    	final Button b = new Button(this);
    	b.setText("Go Back");
    	b.setWidth(200);
    	b.setHeight(200);
    	b.setX(300);
    	b.setY(600);
    	b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				b.setVisibility(View.GONE);
				i.setVisibility(View.GONE);
				((RelativeLayout)findViewById(R.id.fake)).setVisibility(View.VISIBLE);
			}
    	});
    	
    	((RelativeLayout)findViewById(R.id.dad)).addView(b);
    }
}
