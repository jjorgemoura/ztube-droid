package com.zindon.ztube;

import com.zindon.ztube.domain.YTAccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class AccountPlaylistsActivity extends Activity {

	// ----------------------VARS---------------------
	protected static final String TAG = "Main Activity";
	 		
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_playlists);
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
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

}
