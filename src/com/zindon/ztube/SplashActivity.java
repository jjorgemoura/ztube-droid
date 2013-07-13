package com.zindon.ztube;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;


/**
 * 
 * Activity responsible with the History Video Activity.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @since API 1
 *
 */
public class SplashActivity extends Activity {

	// ----------------------VARS---------------------
	protected static final String TAG = "Splash Activity";
	protected static final int SPLASH_DURATION = 3;
		 		
		
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	
		Log.d(TAG, "SPLASH FINISH");
		this.finishAfterX(SplashActivity.SPLASH_DURATION);
	} 	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	private void finishAfterX(int seconds) {
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				
				finish();
			}
		}, seconds*1000);
		
	}

	// ----------------------GETTERS and SETTERS---------------------

}
