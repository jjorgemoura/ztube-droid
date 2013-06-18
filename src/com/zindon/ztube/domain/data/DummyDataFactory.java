package com.zindon.ztube.domain.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zindon.ztube.domain.YTAccount;
import com.zindon.ztube.domain.YTPlaylist;
import com.zindon.ztube.domain.YTVideo;


/**
 * This class provides a set of static methods with dummy data so that the application could function without the API YouTube being operational.
 * 
 * @author jorge
 * @version %I%, %G%
 * @since API 1
 * 
 */
public class DummyDataFactory {

	
	private static Map<Integer, YTAccount> accountsList = null;
	private static Map<Integer, YTPlaylist> playlistsList = null;
	private static Map<Integer, YTVideo> videosList = null;
	
	
	
	
	public DummyDataFactory() {
		
		
	}
	
	
	static {
		
		accountsList = new HashMap<Integer, YTAccount>();
		playlistsList = new HashMap<Integer, YTPlaylist>();
		videosList = new HashMap<Integer, YTVideo>();
		
		
		//accountsList.put(1, "jorge");
		//accountsList.put(2, "toni");
		
		
		//playlistsList.put(key, value)
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static List<YTAccount> dummyAccountsList() {
		
		
		
		return null;
	} 
	
	public static YTAccount dummyAccount() {
		
		
		
		return null;
	} 
	
	
	/**
	 * 
	 * @param accountID
	 * @return
	 */
	public static List<YTPlaylist> dummyPlaylistsBySubscription(int accountID) {
		
		
		return null;
	}
	
	public static YTPlaylist dummyPlaylist(int playlistID) {
		
		
		return null;
	}
	
	
	public static List<YTVideo> dummyVideosByPlaylist(int playlistID) {
		
		
		
		return null;
	} 
	
	public static YTVideo dummyVideo(int playlistID) {
		
		
		return null;
	}
	
	
}
