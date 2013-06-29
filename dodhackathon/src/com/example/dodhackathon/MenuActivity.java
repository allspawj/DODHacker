package com.example.dodhackathon;

import java.util.ArrayList;
import java.util.List;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.java.Query;
import com.kinvey.java.core.KinveyClientCallback;

import android.R.color;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MenuActivity extends Activity{
	static EventEntity[] res;
	static Client kinveyClient;	
	List<Spinner> spinList = new ArrayList<Spinner>();
	List<Button> buttonList = new ArrayList<Button>();
		
	int width = 0;
	int height = -140;
	
	
	
String[] str = new String[]{"MRE2012", "MRE2013",
							"FSR2008", "FSR2012", "MC2008"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
    	setContentView(R.layout.menus);
    	RelativeLayout linearLayout = (RelativeLayout)findViewById(R.id.menusRel);
    	final EditText e = (EditText)findViewById(R.id.editT);
    	final TextView t = (TextView)findViewById(R.id.TV);
    	e.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
            	t.setText("");
            	Query myQuery = kinveyClient.query();
            	//final EditText t = (EditText)s;
            	Log.v("", "WHAT THE FUCK: " +  t.getText().toString().length());
            	if( e.getText().toString().length() >=4)
            	{
            	myQuery.startsWith("ITEM", e.getText().toString());
            	Log.v("", "ITEM SCAN YO: " +  e.getText().toString());
            	for(int i = 0; i < 5; i++)
            	{
            		AsyncAppData<EventEntity> myEvents = kinveyClient.appData(str[i], EventEntity.class);
            	
            	myEvents.get(myQuery ,new KinveyListCallback<EventEntity>() {
            		  @Override
            		  public void onSuccess(EventEntity[] results) { 
            			  Log.v("", "RESULTS YO: "+ results.length );
            		      for(int j = 0; j < results.length; j++)
            		      {
            		    	  //if(results[j] != null && results[j].ITEM.length() > 0)
            		    	  try
            		    	  {
            		    		  t.append(" :" + results[j].ITEM + "\n");
            		    	  }catch(Exception e)
            		    	  {
            		    		  
            		    	  }
            		      }
            		  }
            		  @Override
            		  public void onFailure(Throwable error) { 
            		      Log.e("", "failed to fetchByFilterCriteria", error);
            		  }
            		});     
            	}
            }}
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        }); 
    	
    	width = 0;
    	height = -140;
    	
    	
    	
    	for(int i = 1	; i < res.length; i++)
    	{
    		Spinner s = new Spinner(this);
    		spinList.add(s);
    		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
    		        R.array.options, android.R.layout.simple_spinner_item);
    		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    		s.setAdapter(adapter);
    		
    		s.setY(height+ 160);
    		linearLayout.addView(s);
    		
    		Button v = new Button(this);
    		buttonList.add(v);
    		v.setTextAlignment(6);
    		v.setGravity(Gravity.LEFT);
    		v.setText( res[i].ITEM);
    		v.setHeight(140);
    		v.setWidth(600);
    		v.setX(width + 100);
    		v.setY(height += 140);
    		v.setBackgroundColor(color.white);
    		v.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					RelativeLayout rl = (RelativeLayout)findViewById(R.id.news);
					rl.setVisibility(View.VISIBLE);
					ScrollView sc = (ScrollView)findViewById(R.id.olds);
					sc.setVisibility(View.GONE);
					
					Query myQuery = kinveyClient.query();
					
					Button b = (Button) v;
					myQuery.equals("ITEM", b.getText() );
					
					for(int i = 0; i < 5; i++)
					{
						Log.v("", "QUERY QUERY QUERY QUERRY" );
	AsyncAppData<EventEntity> myEvents = kinveyClient.appData(str[i], EventEntity.class);
	            	
	            	myEvents.get(myQuery ,new KinveyListCallback<EventEntity>() {
	            		  @Override
	            		  public void onSuccess(EventEntity[] results) { 
	            			  Log.v("", "RESULTS YO: "+ results.length );
	            		      for(int j = 0; j < results.length; j++)
	            		      {
	            		    	  //if(results[j] != null && results[j].ITEM.length() > 0)
	            		    	  try
	            		    	  {
	            		    		  
	            		    		  t.append("ITEM:" + results[j].ITEM + "\n");
	            		    		  t.append("ITEMTYPE:" + results[j].ITEMTYPE + "\n");
	            		    		  t.append("CALCIUM_DV:" + results[j].CALCIUM_DV + "\n");
	            		    		  t.append("CALCIUM_MG:" + results[j].CALCIUM_MG + "\n");
	            		    		  t.append("CALORIES:" + results[j].CALORIES + "\n");
	            		    		  t.append("CARBOHYDRATES_DV:" + results[j].CARBOHYDRATES_DV + "\n");
	            		    		  t.append("CARBOHYDRATES_G:" + results[j].CARBOHYDRATES_G + "\n");
	            		    		  t.append("CHOLESTEROL_DV:" + results[j].CHOLESTEROL_DV + "\n");
	            		    		  t.append("CHOLESTEROL_MG:" + results[j].CHOLESTEROL_MG + "\n");
	            		    		  t.append("DIETARYFIBER_DV:" + results[j].DIETARYFIBER_DV + "\n");
	            		    		  t.append("DIETARYFIBER_G:" + results[j].DIETARYFIBER_G + "\n");
	            		    		  t.append("FOLICACID_MCG:" + results[j].FOLICACID_MCG + "\n");
	            		    		  t.append("IRON_DV:" + results[j].IRON_DV + "\n");
	            		    		  t.append("IRON_MG:" + results[j].IRON_MG + "\n");
	            		    		  
	            		    		  
	            		    		  t.append("MAGNESIUM_MG:" + results[j].MAGNESIUM_MG + "\n");
	            		    		  t.append("NIACIN_MG:" + results[j].NIACIN_MG + "\n");
	            		    		  t.append("PHOSPHOROUS_MG:" + results[j].PHOSPHOROUS_MG + "\n");
	            		    		  
	            		    		  t.append("POTASSIUM_MG:" + results[j].POTASSIUM_MG + "\n");
	            		    		  t.append("PROTEIN_G:" + results[j].PROTEIN_G + "\n");
	            		    		  t.append("RATION:" + results[j].RATION + "\n");
	            		    		  t.append("RIBOFLAVIN_MG:" + results[j].RIBOFLAVIN_MG + "\n");
	            		    		  t.append("SATURATEDFAT_DV:" + results[j].SATURATEDFAT_DV + "\n");
	            		    		  t.append("SATURATEDFAT_G:" + results[j].SATURATEDFAT_G + "\n");
	            		    		  t.append("SELENIUM_MCG:" + results[j].SELENIUM_MCG + "\n");
	            		    		  
	            		    		  t.append("SODIUM_DV:" + results[j].SODIUM_DV + "\n");
	            		    		  t.append("SODIUM_MG:" + results[j].SODIUM_MG + "\n");
	            		    		  t.append("SUGARS_G:" + results[j].SUGARS_G + "\n");
	            		    		  t.append("THIAMIN_MG:" + results[j].THIAMIN_MG + "\n");
	            		    		  t.append("TOTALFAT_DV:" + results[j].TOTALFAT_DV + "\n");
	            		    		  t.append("TOTALFAT_G:" + results[j].TOTALFAT_G + "\n");
	            		    		  t.append("TRANSFAT_G:" + results[j].TRANSFAT_G + "\n");
	            		    		  t.append("VITAMINA_DV:" + results[j].VITAMINA_DV + "\n");
	            		    		  t.append("VITAMINA_IU:" + results[j].VITAMINA_IU+ "\n");
	            		    		  t.append("VITAMINB12_MCG:" + results[j].VITAMINB12_MCG + "\n");
	            		    		  t.append("VITAMINB6_MG:" + results[j].VITAMINB6_MG + "\n");
	            		    		  t.append("VITAMINC_DV:" + results[j].VITAMINC_DV + "\n");
	            		    		  t.append("VITAMINC_DV:" + results[j].VITAMINC_DV + "\n");
	            		    		  t.append("VITAMINC_MG:" + results[j].VITAMINC_MG + "\n");
	            		    		  t.append("VITAMINE_MG:" + results[j].VITAMINE_MG + "\n");
	            		    		  t.append("WEIGHT:" + results[j].WEIGHT + "\n");
	            		    		  t.append("ZINC_MG:" + results[j].ZINC_MG + "\n");
	            		    	  }catch(Exception e)
	            		    	  {
	            		    		  
	            		    	  }
	            		      }
	            		  }
	            		  @Override
	            		  public void onFailure(Throwable error) { 
	            		      Log.e("", "failed to fetchByFilterCriteria", error);
	            		  }
	            		});
	            	
					
					//((RelativeLayout)( (Button)v).getParent() ).getLayoutParams().height += 100;
				}
					
					
				}
    		});
    		linearLayout.addView(v);
    		linearLayout.getLayoutParams().height += 140;
    	}
    	
    	Button extra = new Button(this);
    	extra.setGravity(Gravity.LEFT);
    	extra.setTextAlignment(6);
    	buttonList.add(extra);
		extra.setText( "ADD NEW ITEM");
		extra.setGravity(Gravity.LEFT);
		extra.setBackgroundColor(color.white);
		extra.setHeight(140);
		extra.setWidth(600);
		extra.setX(width + 100);
		extra.setY(height += 140);
		extra.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				addSpinner(v.getY() + 20);
				addButton(v.getY());
				v.setY(v.getY() + 140);
				
				RelativeLayout rl = (RelativeLayout)findViewById(R.id.news);
						rl.setVisibility(View.VISIBLE);
				ScrollView sc = (ScrollView)findViewById(R.id.olds);
				sc.setVisibility(View.GONE);
				
				
			}});
		
		linearLayout.addView(extra);
		
		
    	
enter = new Button(this);
enter.setGravity(Gravity.LEFT);
enter.setTextAlignment(6);
enter.setBackgroundColor(color.white);
    	enter.setText("Confirm");
		enter.setHeight(140);
		enter.setWidth(400);
		enter.setX(width+100);
		enter.setY(height+=140);
		//enter.setBackgroundColor(color.holo_red_dark);
		enter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calcCal();
				
			}
		});
		linearLayout.addView(enter);
		linearLayout.getLayoutParams().height += 280;
		
	}
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void newclicky(View v)
    {
    	RelativeLayout rl = (RelativeLayout)findViewById(R.id.news);
		rl.setVisibility(View.GONE);
		ScrollView sc = (ScrollView)findViewById(R.id.olds);
		sc.setVisibility(View.VISIBLE);
		final TextView t = (TextView)findViewById(R.id.TV);
		final EditText q = (EditText)findViewById(R.id.editT);
		t.setText("");
		q.setText("");
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Resources res = getResources();
        res.getString(R.string.cal);
    	menu.add(Float.toString(total));
        super.onPrepareOptionsMenu(menu);
        return true;
    }
    
    
    private void UpdateTodaysCalories (final Client mKinveyClient, String userId, final double calories){
		//Get Todays date    
    
    CalorieEntry qce = new CalorieEntry();
	Query myQuery = mKinveyClient.query();
	myQuery.equals("userId", userId);
	myQuery.equals("date","1/12/2013");
	AsyncAppData<CalorieEntry> myEvents = mKinveyClient.appData("CALORIES", CalorieEntry.class);
	
	myEvents.get(new KinveyListCallback<CalorieEntry>() {
		  @Override
		  public void onSuccess(CalorieEntry[] results) { 
		      Log.v("", "received" + results.length);
		      CalorieEntry ceResult = results[0];
		      Log.v("", "Calories UpdateC" + calories);
		      ceResult.setCalories(calories);
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
	
	Button enter;
	
	float total = 0.0f;
	static String uname = "";
	static Client kc;
	public void calcCal()
	{
		Log.v("", "SPIN SIZE: " + spinList.size() + " CAL SIZE: " + res.length );
		for(int i = 0; i < res.length - 1; i++)
		{
			Log.v("", "i: " + i+" TOTAL CALS: " + total );
			if(res[i].CALORIES != null)
				total += Float.parseFloat(res[i].CALORIES) * spinList.get(i).getSelectedItemPosition();
			ActionBar actionBar = getActionBar();
			actionBar.setTitle(Float.toString(total));
			UpdateTodaysCalories(kc, uname, total);
			 //v.setTitle(Float.toString(total));
		}
		//MainActivity.top = Float.toString(total);

		
		if(MainActivity.thresh - total > 0 )
			MainActivity.bottom = Integer.toString((int)MainActivity.thresh - (int)total);
		else
			MainActivity.bottom = "";
		
		Intent i = new Intent(this, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    	startActivity(i);
	}
	
	public void addSpinner(float x)
	{
		RelativeLayout linearLayout = (RelativeLayout)findViewById(R.id.menusRel);
		
		Spinner s = new Spinner(this);
		spinList.add(s);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.options, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
		
		s.setY(x);
		linearLayout.addView(s);
		
	}
	
	public void addButton(float x)
	{
		RelativeLayout linearLayout = (RelativeLayout)findViewById(R.id.menusRel);
		Button v = new Button(this);
		v.setBackgroundColor(color.white);
		v.setGravity(Gravity.LEFT);
		buttonList.add(v);
		//v.setText( res[i].ITEM);
		v.setTextAlignment(6);
		v.setHeight(140);
		v.setWidth(600);
		v.setX(width + 100);
		v.setY(x);
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		enter.setY(enter.getY() + 140);
		linearLayout.addView(v);
		linearLayout.getLayoutParams().height += 140;
	}
	
	public void addItem(View view)
	{
		
	}
	

}
