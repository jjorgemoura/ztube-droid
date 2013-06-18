package com.zindon.ztube.domain.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class provides a set of static methods with dummy data so that the application could function without the API YouTube being operational.
 * 
 * @author jorge
 * @version %I%, %G%
 * @since API 1
 * 
 */
public class DummyDataFactory {

	
	private static Map<Integer, Object> accountsList = null;
	private static Map<Integer, Object> playlistsList = null;
	private static Map<Integer, Object> videosList = null;
	
	
	
	
	public DummyDataFactory() {
		
		
	}
	
	
	static {
		
		accountsList = new HashMap<Integer, Object>();
		playlistsList = new HashMap<Integer, Object>();
		videosList = new HashMap<Integer, Object>();
		
		
		accountsList.put(1, "jorge");
		accountsList.put(2, "toni");
		
		
		//playlistsList.put(key, value)
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static List<Object> dummyAccountsList() {
		
		
		
		return null;
	} 
	
	public static Object dummyAccount() {
		
		
		
		return null;
	} 
	
	
	/**
	 * 
	 * @param accountID
	 * @return
	 */
	public static List<Object> dummyPlaylistsBySubscription(int accountID) {
		
		
		return null;
	}
	
	public static Object dummyPlaylist(int playlistID) {
		
		
		return null;
	}
	
	
	public static List<Object> dummyVideosByPlaylist(int playlistID) {
		
		
		
		return null;
	} 
	
	public static Object dummyVideo(int playlistID) {
		
		
		return null;
	}
	
	
}
