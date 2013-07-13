package com.zindon.ztube.application;

import java.io.File;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;
import android.util.Log;

/**
 * 
 * This class extends the Application context class. Use this class to store global static data, such as Google Developer Key, key identifiers for change parameters between activities, indication about use dummy data or not, among others.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
public class YTApplication extends Application {

	// ----------------------VARS---------------------
	protected static final String TAG = "YT Application";
	
	private String mDEVELOPER_KEY = "AIzaSyCzBmY5AIhMYEyjQMXSRo8cM5Ce3UUGZ6M";
	
	private boolean mDummyData = false;
	//private int mSplashScreenDuration = 3; 		//secs 
	
	private String mPlaylistKey = "playlist_key";
	private String mVideoKey = "video_key";
	
	
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
	/**
	 * Indicates if the List will operate will dummy data or real data. 
	 * 
	 * @return boolean indicating if will use dummy data or not.
	 */
	public boolean useDummyData() {
		
		return mDummyData;
	}


	/**
	 * The Playlist Key for use when exchange info between activities.
	 * 
	 * @return A key (String).
	 */
	public String playlistKey() {
		return mPlaylistKey;
	}


	/**
	 * The Video Key for use when exchange info between activities.
	 * 
	 * @return A key (String).
	 */
	public String videoKey() {
		return mVideoKey;
	}
	
	/**
	 * Obtain the Google Developer Key for use with the Youtube API. 
	 * 
	 * @return The Google Developer Key.
	 */
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
