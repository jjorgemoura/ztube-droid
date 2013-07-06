package com.zindon.ztube.utils;

import android.os.Message;
import android.os.SystemClock;

import com.zindon.ztube.utils.interfaces.OnAppRequest;

public class YouTubeApi {

	// ----------------------VARS---------------------
	protected static final String TAG = "Requests";
	 	
		
		
		
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	public static String playlistsURI(String user) {
		
		StringBuilder sb = new StringBuilder();
		
		//"http://gdata.youtube.com/feeds/api/users/condorouro/playlists?alt=json"
		//"https://gdata.youtube.com/feeds/api/users/fcporto/playlists?v=2&alt=json"
		
		sb.append("https://gdata.youtube.com/feeds/api/users/");
		sb.append(user);
		sb.append("/playlists?v=2&alt=json");
	
		return sb.toString();
	}
	
	public static String videosURI(String playlistIdentifier) {
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("https://gdata.youtube.com/feeds/api/users/");
		sb.append(playlistIdentifier);
		sb.append("/playlists?v=2&alt=json");
	
		return sb.toString();
	}
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
		 	
		
		
		
	// ----------------------PUBLIC METHODS - NORMAL---------------------

	// ----------------------PRIVATE METHODS---------------------
		

	// ----------------------GETTERS and SETTERS---------------------

}
