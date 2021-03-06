package com.zindon.ztube.domain.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.zindon.ztube.domain.YTAccount;
import com.zindon.ztube.domain.YTHistoryVideo;
import com.zindon.ztube.domain.YTPlaylist;
import com.zindon.ztube.domain.YTUserCredentials;
import com.zindon.ztube.domain.YTVideo;
import com.zindon.ztube.utils.ZDDate;


/**
 * This class provides a set of static methods with dummy data so that the application could function without the API YouTube being operational.
 * 
 * @author jorge
 * @since API 1
 * 
 */
public class DummyDataFactory {

	
	// ----------------------VARS---------------------
	private static Map<String, YTAccount> sAccountsList = null;							//KEY: unique identifier; VALUE: The account
	private static Map<String, Map<String, YTPlaylist>> sPlaylistsList = null;			//KEY: Account identifier; VALUE{KEY: Playlist identifier; VALUE: The Playlist}
	private static Map<String, Map<String, YTVideo>> sVideosList = null;				//KEY: Playlist identifier; VALUE{KEY: Video identifier; VALUE: The Video}
	private static Map<String, Map<String, YTHistoryVideo>> sVideosHistoryList = null;		//KEY: Account identifier; VALUE{KEY: Video identifier; VALUE: The Video}
	
	
 		
	
	// ----------------------CONSTRUCTORS---------------------
	public DummyDataFactory() {
		
		
	}
	
	
 	// ----------------------STATIC METHODS---------------------
	static {
		
		sAccountsList = new HashMap<String, YTAccount>();
		sPlaylistsList = new HashMap<String, Map<String,YTPlaylist>>();
		sVideosList = new HashMap<String, Map<String,YTVideo>>();
		sVideosHistoryList = new HashMap<String, Map<String,YTHistoryVideo>>();
		
		
		
		//ACCOUNTS LIST
		YTUserCredentials userCredentials = new YTUserCredentials("jorge", null);
		YTAccount acc1 = new YTAccount(userCredentials);
		
		sAccountsList.put("acxpt1", acc1);
		
		
		
		//PLAYLIST
		Map<String, YTPlaylist> tempPlayList1 = new HashMap<String, YTPlaylist>();
		Map<String, YTPlaylist> tempPlayList2 = new HashMap<String, YTPlaylist>();
		Map<String, YTPlaylist> tempPlayList3 = new HashMap<String, YTPlaylist>();
		
		YTPlaylist pl1 = new YTPlaylist();
		YTPlaylist pl2 = new YTPlaylist();
		YTPlaylist pl3 = new YTPlaylist();
		
		pl1.setupPlaylist("plpf1sdf5", "Mao Morta Videos Playlist", "Lista com videos dos Mao Morta - A melhor banda Portuguesa.", "http://gdata.youtube.com/feeds/mobile/users/condorouro");
		pl1.setupPlaylistSettings(2, new ZDDate(), new ZDDate());
		
		pl2.setupPlaylist("plhj64hgf", "Pink Floyd Videos Playlist", "Lista com videos dos Pink Floyd - A melhor banda de sempre.", "http://gdata.youtube.com/feeds/mobile/users/condorouro");
		pl2.setupPlaylistSettings(3, new ZDDate(), new ZDDate());
		
		pl3.setupPlaylist("pldlg5eras", "The Mars Volta Videos Playlist", "Lista com videos dos Mars Volta - O melhor projecto musical.", "http://gdata.youtube.com/feeds/mobile/users/condorouro");
		pl3.setupPlaylistSettings(5, new ZDDate(), new ZDDate());
		
		tempPlayList1.put("plpf1sdf5", pl1);
		tempPlayList2.put("plhj64hgf", pl2);
		tempPlayList3.put("pldlg5eras", pl3);
		
		
		sPlaylistsList.put("acxpt1", tempPlayList1);
		sPlaylistsList.put("acxpt1", tempPlayList2);
		sPlaylistsList.put("acxpt1", tempPlayList3);
		
		
		
		//VIDEOS
		Map<String, YTVideo> tempVideoList1 = new HashMap<String, YTVideo>();
		Map<String, YTVideo> tempVideoList2 = new HashMap<String, YTVideo>();
		Map<String, YTVideo> tempVideoList3 = new HashMap<String, YTVideo>();
		
		YTVideo vd1 = new YTVideo();
		YTVideo vd2 = new YTVideo();
		YTVideo vd3 = new YTVideo();
		
		vd1.setupVideo("vdghjfghj", "O divino Marques", "Video da musica O Divino Marques.", "");
		vd1.setupAuthor("fghfghfgh", "jorge", "");
		vd1.setupVideoData(new ZDDate(), new ZDDate(), 600, 6346, 5000, 1);
		
		vd2.setupVideo("vd654fghf", "Money", "Video da musica Money.", "");
		vd2.setupAuthor("fghfg345", "jorge", "");
		vd2.setupVideoData(new ZDDate(), new ZDDate(), 400, 9346, 8000, 3);
		
		vd3.setupVideo("mQIMgfY2pEc", "Eriatarka", "Video da musica Eriatarka.", "");
		vd3.setupAuthor("fghfg23899", "jorge", "");
		vd3.setupVideoData(new ZDDate(), new ZDDate(), 500, 8346, 7000, 2);
		
		tempVideoList1.put("mQIMgfY2pEc", vd1);
		tempVideoList2.put("vd654fghf", vd2);
		tempVideoList3.put("vdfgh6534", vd3);
		
		sVideosList.put("plpf1sdf5", tempVideoList1);
		sVideosList.put("plhj64hgf", tempVideoList2);
		sVideosList.put("pldlg5eras", tempVideoList3);
		
		
		//HISTORY VIDEOS
		Map<String, YTHistoryVideo> tempVideoListh1 = new HashMap<String, YTHistoryVideo>();
		Map<String, YTHistoryVideo> tempVideoListh2 = new HashMap<String, YTHistoryVideo>();
		Map<String, YTHistoryVideo> tempVideoListh3 = new HashMap<String, YTHistoryVideo>();
		
		YTHistoryVideo vdh1 = new YTHistoryVideo(null);
		YTHistoryVideo vdh2 = new YTHistoryVideo(null);
		YTHistoryVideo vdh3 = new YTHistoryVideo(null);
		
		tempVideoListh1.put("vdghjf567", vdh1);
		tempVideoListh2.put("vd654f789", vdh2);
		tempVideoListh3.put("vdfgh6333", vdh3);
		
		
		sVideosHistoryList.put("acxpt1", tempVideoListh1);
		sVideosHistoryList.put("acxpt1", tempVideoListh2);
		sVideosHistoryList.put("acxpt1", tempVideoListh3);
		
		Log.d("DUMMY DATA", sAccountsList.toString());
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
	public static List<YTPlaylist> dummyPlaylistsBySubscription(String accountID) {
		
		List<YTPlaylist> resultList = new ArrayList<YTPlaylist>();
		
		
		Map<String, YTPlaylist> xx = DummyDataFactory.sPlaylistsList.get(accountID);
		
		//List<YTPlaylist> yy = (List<YTPlaylist>) xx.values();
		
		for(Iterator<String> it = xx.keySet().iterator(); it.hasNext();)  {
			
			String plIdentifier = it.next();
			YTPlaylist pl = xx.get(plIdentifier);
						
			resultList.add(pl);
		}
		
		
		
		//To debug
//		List<YTPlaylist> resultList = new ArrayList<YTPlaylist>();
//		YTPlaylist asssss = new YTPlaylist();
//		resultList.add(asssss);
		//--------
		
		return resultList;
	}
	
	public static YTPlaylist dummyPlaylist(String playlistID) {
		
		YTPlaylist result = null;
		
		
		
		for(Iterator<String> it = DummyDataFactory.sPlaylistsList.keySet().iterator(); it.hasNext();) {
			
			String accountID = it.next();																//The Account
			Map<String, YTPlaylist> thePlaylist = DummyDataFactory.sPlaylistsList.get(accountID);		//The Map with playlists by account
			
			if(thePlaylist.containsKey(playlistID)) {
				
				result = thePlaylist.get(playlistID);
			}
			
		}
		
		return result;
	}
	
	
	
	
	
	public static List<YTVideo> dummyVideosByPlaylist(String playlistID) {
				
		//List<YTVideo> resultList = new ArrayList<YTVideo>(DummyDataFactory.sVideosList.get(playlistID).values());		

		List<YTVideo> resultList = new ArrayList<YTVideo>();
		
		
		Map<String, YTVideo> xx = DummyDataFactory.sVideosList.get(playlistID);
		
		//List<YTPlaylist> yy = (List<YTPlaylist>) xx.values();
		
		for(Iterator<String> it = xx.keySet().iterator(); it.hasNext();)  {
			
			String vdIdentifier = it.next();
			YTVideo vd = xx.get(vdIdentifier);
						
			resultList.add(vd);
		}
		
		
		
		return resultList;
	} 
	
	public static YTVideo dummyVideo(String videoTagID) {
		
		YTVideo result = null;
		
		
		for(Iterator<String> it = DummyDataFactory.sVideosList.keySet().iterator(); it.hasNext();) {
			
			String playlistID = it.next();																//The Playlist
			Map<String, YTVideo> theVideolist = DummyDataFactory.sVideosList.get(playlistID);		//The Map with videos by playlist
			
			if(theVideolist.containsKey(videoTagID)) {
				
				result = theVideolist.get(videoTagID);
			}
		}
		
		return result;
	}
	
	
	
	public static List<YTHistoryVideo> dummyHistoryVideosByPlaylist(String uniqueIdentifier) {
		
		List<YTHistoryVideo> resultList = new ArrayList<YTHistoryVideo>(DummyDataFactory.sVideosHistoryList.get(uniqueIdentifier).values());
		
		return resultList;
	} 
	
	public static YTHistoryVideo dummyHistoryVideo(String videoTagID) {
		
		YTHistoryVideo result = null;
		
		for(Iterator<String> it = DummyDataFactory.sVideosHistoryList.keySet().iterator(); it.hasNext();) {
			
			String accountID = it.next();																	//The accountID
			Map<String, YTHistoryVideo> theVideolist = DummyDataFactory.sVideosHistoryList.get(accountID);		//The Map with videos by account
			
			if(theVideolist.containsKey(videoTagID)) {
				
				result = theVideolist.get(videoTagID);
			}
		}
		
		
		return result;
	}
	
	

	
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	 	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

	
}
