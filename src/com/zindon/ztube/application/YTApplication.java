package com.zindon.ztube.application;

import java.io.File;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;
import android.util.Log;

public class YTApplication extends Application {

	// ----------------------VARS---------------------
	protected static final String TAG = "YT Application";
	
	private String mDEVELOPER_KEY = "AIzaSyCzBmY5AIhMYEyjQMXSRo8cM5Ce3UUGZ6M";
	
	private boolean mDummyData = false;
	//private int mSplashScreenDuration = 3; 		//secs 
	
	private String mPlaylistKey = "playlist_key";
	private String mVideoKey = "playlist_key";
	
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	@Override
	public void onCreate() {
		
		super.onCreate();
		
		
		File fileCacheUtils = StorageUtils.getCacheDirectory(getApplicationContext());
		Log.d(TAG, "FILECACHE" + fileCacheUtils.getAbsolutePath());
		
		
		// Create global configuration and initialize ImageLoader with this configuration
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
            .build();
        
        ImageLoader.getInstance().init(config);
		
	}
		
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
