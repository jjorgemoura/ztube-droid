package com.zindon.ztube;

import com.zindon.ztube.utils.NetworkConnectivity;

import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



/**
 * 
 * Activity responsible with the Main Activity of the software.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @since API 1
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	
	// ----------------------VARS---------------------
	/**
	 * 
	 */
	protected static final String TAG = "Main Activity";
	 		
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//Log.d(TAG, "Start SPLASH");
		startActivity(new Intent(this, SplashActivity.class));
		
		
		
		//Click Listeners
		Button myButton_pl = (Button) findViewById(R.id.button_playlists);
		myButton_pl.setOnClickListener(this);
		
		Button myButton_ht = (Button) findViewById(R.id.button_history);
		myButton_ht.setOnClickListener(this);
		
		Button myButton_stt = (Button) findViewById(R.id.button_settings);
		myButton_stt.setOnClickListener(this);
	}

	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	/**
	 * 
	 */
	@Override
	protected void onStart() {
		
		super.onStart();
		//Log.d(TAG, "method: onStart");
		
	}
    
	@Override
    protected void onRestart() {
		
		super.onRestart();
//		Log.i(TAG, "method: onRestart");
		
//		Log.d(TAG, "Start SPLASH");
//		startActivity(new Intent(this, SplashActivity.class));
//		
	}

	@Override
    protected void onResume() {
		
		super.onResume();
//		Log.d(TAG, "method: onResume");
		
		boolean isNetConnected = NetworkConnectivity.isConnected(getApplicationContext());
		
		if(!isNetConnected) {
			
			// 1. Instantiate an AlertDialog.Builder with its constructor
			AlertDialog.Builder builder = new AlertDialog.Builder(this);

			// 2. Chain together various setter methods to set the dialog characteristics
			builder.setMessage(R.string.alertdialog_msg)
			       .setTitle(R.string.alertdialog_title);

			builder.setPositiveButton(R.string.alertdialog_ok, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			
			builder.setNegativeButton(R.string.alertdialog_settings, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				}
			});
			
			// 3. Get the AlertDialog from create()
			AlertDialog dialog = builder.create();
			dialog.show();
		}
	}

	@Override
    protected void onPause() {
		
		super.onPause();
//		Log.i(TAG, "method: onPause");
	}

	@Override
    protected void onStop() {
		
		super.onStop();
//		Log.i(TAG, "method: onStop");
	}

	@Override
    protected void onDestroy() {
		
		super.onDestroy();
//		Log.i(TAG, "method: onDestroy");
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
