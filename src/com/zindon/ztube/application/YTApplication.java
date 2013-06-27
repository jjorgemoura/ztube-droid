package com.zindon.ztube.application;

import android.app.Application;

public class YTApplication extends Application {

	// ----------------------VARS---------------------
	protected static final String TAG = "YT Application";
	 
	private boolean mDummyData = true;
	//private int mSplashScreenDuration = 3; 		//secs 
	
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	 	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	public boolean useDummyData() {
		
		return mDummyData;
	}
	
//	public int splashScreenDuration() {
//		
//		return mSplashScreenDuration;
//	}
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------
	
}
