package com.zindon.ztube.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zindon.ztube.domain.data.DummyDataFactory;
import com.zindon.ztube.utils.RequestAsyncTask;
import com.zindon.ztube.utils.YouTubeApi;
import com.zindon.ztube.utils.ZDDate;
import com.zindon.ztube.utils.interfaces.OnAppRequest;

/**
 * This class models a Youtube Playlist. 
 * 
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @since API 1
 */
public class YTPlaylist {

    private static final String TAG = "YTPlaylist";

    //
    private String mPlaylistIdentifier = null;
    private String mYoutubeUri = null;
    
    private String mTitle = null;
    private String mSummary = null;

    
    //
    private int mVideoQuantity = 0;
    private ZDDate mPublishDate = null;
    private ZDDate mUpdatedDate = null;
    
    
    private String mPlaylistThumbnail = null;
    private String mPlaylistThumbnailAlt = null;
    
    //
    private List<YTVideo> mVideosList = null;





    //-----------------Constructors------------------
    public YTPlaylist() {

        mVideosList = new ArrayList<YTVideo>();
    }




    //-----------------Static Methods------------------
    public static List<YTPlaylist> findByUserId(String userId, OnAppRequest activity, boolean dummyData) {
    	
    	List<YTPlaylist> resultList = new ArrayList<YTPlaylist>();
    	
    	if(dummyData) {
    		
    		resultList = DummyDataFactory.dummyPlaylistsBySubscription(userId);
    	}
    	else {
    		
    		//"https://gdata.youtube.com/feeds/api/users/fcporto/playlists?v=2&alt=json"
    		
    		String uri = YouTubeApi.playlistsURI(userId);
    		
    		RequestAsyncTask requestAsync = new RequestAsyncTask(activity);
			requestAsync.execute(uri);
    	}
    	
    	
//    	Log.d(TAG, "YTPlaylist: Size = " + resultList.size());
    	
    	return resultList;
    }

    public static void buildList(String json, OnAppRequest activity) {
    	
    	List<YTPlaylist> resultList = new ArrayList<YTPlaylist>();
    	YTPlaylist xPlayList;
    	
    	try {
    	
	    	JSONObject jsonParser = new JSONObject(json);
	    	JSONArray jsonArrayEntry = jsonParser.getJSONObject("feed").getJSONArray("entry");
	    	
	    	for(int i = 0; i < jsonArrayEntry.length(); i++) {
	    		
	    		JSONObject eachEntry = jsonArrayEntry.getJSONObject(i);
	    		
	    		xPlayList = new YTPlaylist();
	    		
	    		//String xAuthor = 
				String xTitle = eachEntry.getJSONObject("title").getString("$t");
				String xUri = eachEntry.getJSONObject("id").getString("$t");
				String xIdentifier = eachEntry.getJSONObject("yt$playlistId").getString("$t");
				String xSummary = eachEntry.getJSONObject("summary").getString("$t");
	    		//String xSummary = "sdfsdfsdf s";
	    		
//	    		Log.d(TAG, eachEntry.getString("published"));
	    		
	    		JSONObject tmpCountHint = eachEntry.getJSONObject("yt$countHint");
	    		int videoQuantity = tmpCountHint.getInt("$t");
	    		//int videoQuantity = eachEntry.getJSONArray("gd$feedLink").getJSONObject(0).getInt("countHint");
	    		
	    		ZDDate publishDate = new ZDDate(ZDDate.BuildYouTubeDate(eachEntry.getJSONObject("published").getString("$t")), ZDDate.FORMAT_DATE_HOUR_MIN_SS);
	    		//ZDDate publishDate = new ZDDate(eachEntry.getJSONObject("published").getString("$t"), "yyyy-MM-dd HH:mm:ss.SSS ");
	    		ZDDate updatedDate = new ZDDate(ZDDate.BuildYouTubeDate(eachEntry.getJSONObject("updated").getString("$t")), ZDDate.FORMAT_DATE_HOUR_MIN_SS);
	    		//ZDDate updatedDate = new ZDDate(eachEntry.getJSONObject("updated").getString("$t"), "yyyy-MM-dd HH:mm:ss.SSS ");
	    		
	    		
	    		//
	    		JSONObject mg = eachEntry.getJSONObject("media$group");
	    		String thumbnail = "";
	    		String thumbnailAlt = "";
	    		
	    		if(mg.names().length() == 1) {
	    			
	    			//do nothing
	    		}
	    		else {
	    		
		    		JSONArray thumbnailsArray = mg.getJSONArray("media$thumbnail");
		    		
		    		
		    		for(int j = 0; j < thumbnailsArray.length(); j++) {
		    			
		    			JSONObject xThumbnail= thumbnailsArray.getJSONObject(j);
		    			
		    			int theHeight = xThumbnail.getInt("height");
		    			int theWidth = xThumbnail.getInt("width");
		    			
		    			if(j == 0) {
		    				
		    				thumbnail = xThumbnail.getString("url");
		    			}
		    			
		    			if(theHeight == 90 && theWidth == 120) {
		    				
		    				thumbnailAlt = xThumbnail.getString("url");
		    			}
		    		}
		    		
		    		
//		    		Log.d(TAG, thumbnail);
//		    		Log.d(TAG, thumbnailAlt);
	    		}
	    		
	    		xPlayList.setupPlaylist(xIdentifier, xTitle, xSummary, xUri);
	    		xPlayList.setupPlaylistSettings(videoQuantity, publishDate, updatedDate);
	    		xPlayList.setupThumbnails(thumbnail, thumbnailAlt);
	    		
		    	resultList.add(xPlayList);
	    	}
	    	
	    	
	    		    	
	    	
	    	
//	    	Log.d(TAG, "YTPlaylist: Size = " + resultList.size());
	    	activity.onRequestCompleted(resultList);
    	
    	}
    	catch(JSONException ex) {
    		ex.printStackTrace();
    	}
    	catch(Exception ex) {
    		
    		throw new RuntimeException(ex);
    	}
    }




    //-----------------Public Methods------------------
  
    
    public void setupPlaylist(String identifier, String title, String summary, String youtubeUri) {
    	
    	this.mTitle = title;
    	this.mSummary = summary;
    	this.mPlaylistIdentifier = identifier;
    	this.mYoutubeUri = youtubeUri;
    }
    
    public void setupPlaylistSettings(int videoQuantity, ZDDate publishDate, ZDDate updatedDate) {
    	
    	this.mVideoQuantity = videoQuantity;
    	this.mPublishDate = publishDate;
    	this.mUpdatedDate = updatedDate;
    }
    
    public void setupThumbnails(String thumbnail, String thumbnailAlt) {
    	
    	if(thumbnail != null) {
    		
    		this.mPlaylistThumbnail = thumbnail;
    	}
    	
    	if(thumbnailAlt != null) {
    		
    		this.mPlaylistThumbnailAlt = thumbnailAlt;
    	}
    }
    
    public void addVideo(YTVideo video) {
    	
    	if(video != null) {
    		
    		this.mVideosList.add(video);
    	}
    }

    public List<YTVideo> myVideos() {
    	
    	return new ArrayList<YTVideo>(this.mVideosList);
    }




	public String playlistIdentifier() {
		return mPlaylistIdentifier;
	}

	public String title() {
		return mTitle;
	}

	public String summary() {
		return mSummary;
	}

	public String youtubeUri() {
		return mYoutubeUri;
	}

	public int videoQuantity() {
		return mVideoQuantity;
	}

	public ZDDate publishDate() {
		return mPublishDate;
	}

	public ZDDate updatedDate() {
		return mUpdatedDate;
	}

	public String playlistThumbnail() {
		return mPlaylistThumbnail;
	}

	public String playlistThumbnailAlt() {
		return mPlaylistThumbnailAlt;
	}

	


    //-----------------Private------------------







    //-----------------Getters and Setters------------------


}
