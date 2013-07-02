package com.zindon.ztube.application;

import android.app.Application;

public class YTApplication extends Application {

	// ----------------------VARS---------------------
	protected static final String TAG = "YT Application";
	
	private String mDEVELOPER_KEY = "AIzaSyCzBmY5AIhMYEyjQMXSRo8cM5Ce3UUGZ6M";
	
	private boolean mDummyData = true;
	//private int mSplashScreenDuration = 3; 		//secs 
	
	private String mPlaylistKey = "playlist_key";
	private String mVideoKey = "playlist_key";
	
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	 	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	public boolean useDummyData() {
		
		return mDummyData;
	}


	public String playlistKey() {
		return mPlaylistKey;
	}


	public String videoKey() {
		return mVideoKey;
	}
	
	public String developerKey() {
		return mDEVELOPER_KEY;
	}
	
//	public int splashScreenDuration() {
//		
//		return mSplashScreenDuration;
//	}
	
	
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------
	
}
