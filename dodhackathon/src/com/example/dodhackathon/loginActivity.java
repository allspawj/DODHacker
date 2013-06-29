package com.example.dodhackathon;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.Query;
import com.kinvey.java.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class loginActivity extends Activity {

	Client kinveyClient;	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
            
            kinveyClient = 
        			new Client.Builder(this.getApplicationContext()).build();
        }


public void enter(View v)
{
	TextView t1 = (TextView)findViewById(R.id.username);
	TextView t2 = (TextView)findViewById(R.id.password);
	
	LogInUser( kinveyClient, t1.getText().toString(), t2.getText().toString());
	
	MainActivity.kinveyClient = kinveyClient;
	MainActivity.uname = uname;
	MenuActivity.kinveyClient = kinveyClient;
	

	ActivityActivity.kinveyClient = kinveyClient;
	ActivityActivity.uname = uname;
	if(sex.contains("fe"))
		ActivityActivity.male = false;
	else
		ActivityActivity.male = true;
	Intent i = new Intent(this, ActivityActivity.class);
	startActivity(i);
}

String uname = "";
String pw = "";
static String sex = "";
private void LogInUser(Client mKinveyClient, String userName, String password){
	uname = userName;
	pw = password;
	MenuListActivity.	uname = uname;
	MenuListActivity.kc = mKinveyClient;
	mKinveyClient.user().login(userName, password,
             new KinveyUserCallback() {
        public void onFailure(Throwable t) {
        	Log.d("INFO", "Kinvey cannot login user");
        }
        public void onSuccess(User u) {
        	Log.d("INFO", "Kinvey logged in User");
        	sex = (String) u.get("sex");
        	Log.d("INFO", "USER IS SEXY: "+ sex);
        }
    });
		
}

}
