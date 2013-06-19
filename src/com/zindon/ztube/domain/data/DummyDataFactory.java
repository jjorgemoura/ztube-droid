package com.zindon.ztube.domain.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zindon.ztube.domain.YTAccount;
import com.zindon.ztube.domain.YTHistoryVideo;
import com.zindon.ztube.domain.YTPlaylist;
import com.zindon.ztube.domain.YTUserCredentials;
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

	
	private static Map<String, YTAccount> sAccountsList = null;				//A key e o unique identifier
	private static Map<String, YTPlaylist> sPlaylistsList = null;
	private static Map<String, YTVideo> sVideosList = null;
	private static Map<String, YTHistoryVideo> sVideosHistoryList = null;
	
	
	
	
	public DummyDataFactory() {
		
		
	}
	
	
	static {
		
		sAccountsList = new HashMap<String, YTAccount>();
		sPlaylistsList = new HashMap<String, YTPlaylist>();
		sVideosList = new HashMap<String, YTVideo>();
		sVideosHistoryList = new HashMap<String, YTHistoryVideo>();
		
		
		//ACCOUNTS LIST
		YTUserCredentials userCredentials = new YTUserCredentials("jorge", null);
		YTAccount acc1 = new YTAccount(userCredentials);
		
		sAccountsList.put("xpt1", acc1);
		
		
		//PLAYLIST
		YTPlaylist pl1 = new YTPlaylist();
		YTPlaylist pl2 = new YTPlaylist();
		YTPlaylist pl3 = new YTPlaylist();
		
		sPlaylistsList.put("spf1sdf5", pl1);
		sPlaylistsList.put("ghj64hg", pl2);
		sPlaylistsList.put("dfg5er", pl3);
		
		
		
		//VIDEOS
		YTVideo vd1 = new YTVideo();
		YTVideo vd2 = new YTVideo();
		YTVideo vd3 = new YTVideo();
		
		sVideosList.put("fghjfghj", vd1);
		sVideosList.put("f654fghf", vd2);
		sVideosList.put("fggh6534", vd3);
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static List<YTAccount> dummyAccountsList() {
		
		List<YTAccount> resultList = new ArrayList<YTAccount>(DummyDataFactory.sAccountsList.values());
		
		return resultList;
	} 
	
	public static YTAccount dummyAccount(String uniqueIdentifier) {
				
		return DummyDataFactory.sAccountsList.get(uniqueIdentifier);
	} 
	
	
	/**
	 * 
	 * @param accountID
	 * @return
	 */
	public static List<YTPlaylist> dummyPlaylistsBySubscription(int accountID) {
		
		List<YTPlaylist> resultList = new ArrayList<YTPlaylist>(DummyDataFactory.sPlaylistsList.values());
		
		return resultList;
	}
	
	public static YTPlaylist dummyPlaylist(int playlistID) {
		
		
		return DummyDataFactory.sPlaylistsList.get(playlistID);
	}
	
	
	
	
	public static List<YTVideo> dummyVideosByPlaylist(int playlistID) {
		
		List<YTVideo> resultList = new ArrayList<YTVideo>(DummyDataFactory.sVideosList.values());
		
		return resultList;
	} 
	
	public static YTVideo dummyVideo(int videoTagID) {
		
		
		return DummyDataFactory.sVideosList.get(videoTagID);
	}
	
	
	
	public static List<YTHistoryVideo> dummyHistoryVideosByPlaylist() {
		
		List<YTHistoryVideo> resultList = new ArrayList<YTHistoryVideo>(DummyDataFactory.sVideosHistoryList.values());
		
		return resultList;
	} 
	
	public static YTHistoryVideo dummyHistoryVideo(int videoTagID) {
		
		
		return DummyDataFactory.sVideosHistoryList.get(videoTagID);
	}
}
