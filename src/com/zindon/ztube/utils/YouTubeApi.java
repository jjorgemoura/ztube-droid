package com.zindon.ztube.utils;



/**
 * 
 * This class is the YuoTube API Manager, where is build the Uri that will be call.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
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
		
		
		sb.append("https://gdata.youtube.com/feeds/api/playlists/");
		sb.append(playlistIdentifier);
		sb.append("?v=2&alt=json");
	
		return sb.toString();
	}
	
	
	public static String videoURI(String videoIdentifier) {
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("https://gdata.youtube.com/feeds/api/videos/");
		sb.append(videoIdentifier);
		sb.append("?v=2&alt=json");
	
		return sb.toString();
	}
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
		 	
		
		
		
	// ----------------------PUBLIC METHODS - NORMAL---------------------

	// ----------------------PRIVATE METHODS---------------------
		

	// ----------------------GETTERS and SETTERS---------------------

}
