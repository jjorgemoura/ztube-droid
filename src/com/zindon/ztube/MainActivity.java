package com.zindon.ztube;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



/**
 * 
 * @author jorge
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	
	// ----------------------VARS---------------------
	protected static final String TAG = "Main Activity";
	 		
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Log.d(TAG, "Start SPLASH");
		startActivity(new Intent(this, SplashActivity.class));
		Log.d(TAG, "Resume SPLASH");
		
		
		
		
		//Click Listeners
		Button myButton_pl = (Button) findViewById(R.id.button_playlists);
		myButton_pl.setOnClickListener(this);
		
		Button myButton_ht = (Button) findViewById(R.id.button_history);
		myButton_ht.setOnClickListener(this);
		
		Button myButton_stt = (Button) findViewById(R.id.button_settings);
		myButton_stt.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	protected void onStart() {
		
		super.onStart();
		Log.d(TAG, "method: onStart");
		
		
		
	}
    
	@Override
    protected void onRestart() {
		
		super.onRestart();
		Log.i(TAG, "method: onRestart");
		
//		Log.d(TAG, "Start SPLASH");
//		startActivity(new Intent(this, SplashActivity.class));
//		Log.d(TAG, "Resume SPLASH");
//		
	}

	@Override
    protected void onResume() {
		
		super.onResume();
		Log.i(TAG, "method: onResume");
	}

	@Override
    protected void onPause() {
		
		super.onPause();
		Log.i(TAG, "method: onPause");
	}

	@Override
    protected void onStop() {
		
		super.onStop();
		Log.i(TAG, "method: onStop");
	}

	@Override
    protected void onDestroy() {
		
		super.onDestroy();
		Log.i(TAG, "method: onDestroy");
	}
	
	
	
	
	
	
	
	//-----------Listeners-----------
	@Override
	public void onClick(View v) {
		
		Button btn = (Button)v;
		//String btnStr = (String)btn.getText();
		
		
		//------------------
		if(btn.getId() == R.id.button_playlists) {
			
			startActivity(new Intent(this, PlaylistActivity.class));
		}
		
		if(btn.getId() == R.id.button_history) {
			
			startActivity(new Intent(this, HistoryVideosActivity.class));
		}

		if(btn.getId() == R.id.button_settings) {
			
			startActivity(new Intent(this, SettingsActivity.class));
		}
		
	}

	
	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------
	
	
	
	
	
}
