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
 * This class models a Youtube Video. 
 * 
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @since API 1
 */
public class YTVideo {

    private static final String TAG = "YTVideo";

    //
    private String mVideoIdentifier = null;
    private String mYoutubeUri = null;
    
    private String mTitle = null;
    private String mDescription = null;
    
    
    
    //author
    private String mAuthor = null;
    private String mAuthorUniqueIdentifier = null;
    private String mAuthorUri = null;
    
    

    //
    private String mVideoThumbnail = null;
    private String mVideoThumbnailAlt = null;
    
    
    //video
    private int mDurationInSeconds = 0;
    private ZDDate mPublishDate = null;
    private ZDDate mUpdatedDate = null;
    
    private int mPlayTimesQuantity = 0;
    private int mLikesQuantity = 0;
    private int mDislikesQuantity = 0;
    
    


    //-----------------Constructors------------------
    /**
     * Default Constructor.
     */
    public YTVideo() {


    }




    //-----------------Static Methods------------------
    public static List<YTVideo> findByPlaylistId(String playlistIdentifier, OnAppRequest activity, boolean dummyData) {
    	
    	List<YTVideo> resultList = new ArrayList<YTVideo>();
    	
    	if(dummyData) {
    		
    		resultList = DummyDataFactory.dummyVideosByPlaylist(playlistIdentifier);
    	}
    	else {
    		
    		String uri = YouTubeApi.videosURI(playlistIdentifier);
    		
    		RequestAsyncTask requestAsync = new RequestAsyncTask(activity);
			requestAsync.execute(uri);
    	}
    	
    	
//    	Log.d(TAG, "YTVideo: Size = " + resultList.size());
    	
    	return resultList;
    }
    
    public static List<YTVideo> findByVideoHistory(String videoHistory, OnAppRequest activity) {
    	
    	List<YTVideo> resultList = new ArrayList<YTVideo>();
    	
    	
    	String[] splitArray =  videoHistory.split(";");
    	
    	for(int i = 0; i < splitArray.length; i++) {
    		
    		String theVideoId = splitArray[i];
    		
    		
    		String uri = YouTubeApi.videoURI(theVideoId);
    		
    		RequestAsyncTask requestAsync = new RequestAsyncTask(activity);
    		requestAsync.execute(uri);
    	}
    	
    	return resultList;
    }


    public static YTVideo findByIdentifier(String videoIdentifier, OnAppRequest activity, boolean dummyData) {
    	
    	YTVideo result = new YTVideo();
    	
    	if(dummyData) {
    		
    		result = DummyDataFactory.dummyVideo(videoIdentifier);
    	}
    	else {
    		
    		
    		String uri = YouTubeApi.videoURI(videoIdentifier);
    		
    		RequestAsyncTask requestAsync = new RequestAsyncTask(activity);
			requestAsync.execute(uri);
    	}
    	
    	
    	return result;
    }
    
    
    public static void buildList(String json, OnAppRequest activity) {
    	
    	List<YTVideo> resultList = new ArrayList<YTVideo>();
    	YTVideo xVideo;
    	
    	try {
    	
	    	JSONObject jsonParser = new JSONObject(json);
	    	
	    	JSONObject mainObject = jsonParser.getJSONObject("feed");
	    	
	    	
	    	
	    	
	    	JSONArray jsonArrayEntry = jsonParser.getJSONObject("feed").getJSONArray("entry");
	    	
	    	for(int i = 0; i < jsonArrayEntry.length(); i++) {
	    		
	    		JSONObject eachEntry = jsonArrayEntry.getJSONObject(i);
	    		
	    		xVideo = new YTVideo();
	    		
	    		
	    		
	    		//AUTHOR
		    	//JSONArray authorJsonArray = eachEntry.getJSONArray("author");
		    	
//		    	String xUniqueIdentifier = authorJsonArray.getJSONObject(0).getJSONObject("yt$userId").getString("$t");
//				String xAuthor = authorJsonArray.getJSONObject(0).getJSONObject("name").getString("$t");
//				String xAuthorUri = authorJsonArray.getJSONObject(0).getJSONObject("uri").getString("$t");
		    	
	    		
	    		JSONArray originalAuthorJsonArray = eachEntry.getJSONObject("media$group").getJSONArray("media$credit");
	    		
				String xUniqueIdentifier = "";
				String xAuthor = originalAuthorJsonArray.getJSONObject(0).getString("$t");
				String xAuthorUri = "";
		    	
		    	
	    		
	    		
	    		//VIDEO
	    		String xVideoIdentifier = eachEntry.getJSONObject("media$group").getJSONObject("yt$videoid").getString("$t");
	    		String xTitle = eachEntry.getJSONObject("title").getString("$t");
	    		String xDescription = "";
	    		String xVideoUri = eachEntry.getJSONObject("content").getString("src");
	    		
	    		    		
	    		//VIDEO MORE DATA
	    		ZDDate publishDate = new ZDDate(ZDDate.BuildYouTubeDate(eachEntry.getJSONObject("published").getString("$t")), ZDDate.FORMAT_DATE_HOUR_MIN_SS);
	    		ZDDate updatedDate = new ZDDate(ZDDate.BuildYouTubeDate(eachEntry.getJSONObject("updated").getString("$t")), ZDDate.FORMAT_DATE_HOUR_MIN_SS);
	    		
	    		int durationInSeconds = eachEntry.getJSONObject("media$group").getJSONObject("yt$duration").getInt("seconds");
	    		int playQt = eachEntry.getJSONObject("yt$statistics").getInt("viewCount");
	    		int likesQt = eachEntry.getJSONObject("yt$rating").getInt("numLikes");
	    		int dislikesQt = eachEntry.getJSONObject("yt$rating").getInt("numDislikes");
	    		
	    		
	    		//
	    		JSONArray thumbnailsArray = eachEntry.getJSONObject("media$group").getJSONArray("media$thumbnail");
	    		String thumbnail = "";
	    		String thumbnailAlt = "";
	    		
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
	    		
//	    		Log.d(TAG, thumbnail);
//	    		Log.d(TAG, thumbnailAlt);
	    		
	    		xVideo.setupVideo(xVideoIdentifier, xTitle, xDescription, xVideoUri);
	    		xVideo.setupVideoData(publishDate, updatedDate, durationInSeconds, playQt, likesQt, dislikesQt);
	    		xVideo.setupAuthor(xUniqueIdentifier, xAuthor, xAuthorUri);
	    		xVideo.setupThumbnails(thumbnail, thumbnailAlt);
	    		
		    	resultList.add(xVideo);
	    	}
	    	
	    	
	    	
//	    	Log.d(TAG, "YTVideoList: Size = " + resultList.size());
	    	activity.onRequestCompleted(resultList);
    	
    	}
    	catch(JSONException ex) {
    		ex.printStackTrace();
    	}
    	catch(Exception ex) {
    		
    		throw new RuntimeException(ex);
    	}
    }

    public static void buildVideo(String json, OnAppRequest activity) {
    	
    	//List<YTVideo> resultList = new ArrayList<YTVideo>();
    	YTVideo xVideo = new YTVideo();;
    	
    	try {
    	
	    	JSONObject jsonParser = new JSONObject(json);
	    	
	    	JSONObject eachEntry = jsonParser.getJSONObject("entry");
	    	
	    	//AUTHOR
	    	JSONArray authorJsonArray = eachEntry.getJSONArray("author");
	    	
	    	String xUniqueIdentifier = authorJsonArray.getJSONObject(0).getJSONObject("yt$userId").getString("$t");
			String xAuthor = authorJsonArray.getJSONObject(0).getJSONObject("name").getString("$t");
			String xAuthorUri = authorJsonArray.getJSONObject(0).getJSONObject("uri").getString("$t");
	    	
	    		
    		
    		//VIDEO
    		String xVideoIdentifier = eachEntry.getJSONObject("media$group").getJSONObject("yt$videoid").getString("$t");
    		String xTitle = eachEntry.getJSONObject("title").getString("$t");
    		String xDescription = "";
    		String xVideoUri = eachEntry.getJSONObject("content").getString("src");
    		
    		    		
    		//VIDEO MORE DATA
    		ZDDate publishDate = new ZDDate(ZDDate.BuildYouTubeDate(eachEntry.getJSONObject("published").getString("$t")), ZDDate.FORMAT_DATE_HOUR_MIN_SS);
    		ZDDate updatedDate = new ZDDate(ZDDate.BuildYouTubeDate(eachEntry.getJSONObject("updated").getString("$t")), ZDDate.FORMAT_DATE_HOUR_MIN_SS);
    		
    		int durationInSeconds = eachEntry.getJSONObject("media$group").getJSONObject("yt$duration").getInt("seconds");
    		int playQt = eachEntry.getJSONObject("yt$statistics").getInt("viewCount");
    		int likesQt = eachEntry.getJSONObject("yt$rating").getInt("numLikes");
    		int dislikesQt = eachEntry.getJSONObject("yt$rating").getInt("numDislikes");
    		
    		
    		
    		//
    		JSONArray thumbnailsArray = eachEntry.getJSONObject("media$group").getJSONArray("media$thumbnail");
    		String thumbnail = "";
    		String thumbnailAlt = "";
    		
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
    		
//    		Log.d(TAG, thumbnail);
//    		Log.d(TAG, thumbnailAlt);
    		
    		xVideo.setupVideo(xVideoIdentifier, xTitle, xDescription, xVideoUri);
    		xVideo.setupVideoData(publishDate, updatedDate, durationInSeconds, playQt, likesQt, dislikesQt);
    		xVideo.setupAuthor(xUniqueIdentifier, xAuthor, xAuthorUri);
    		xVideo.setupThumbnails(thumbnail, thumbnailAlt);
	    	
    	
	    	
	    	//
	    	activity.onRequestCompleted(xVideo);
    	
    	}
    	catch(JSONException ex) {
    		ex.printStackTrace();
    	}
    	catch(Exception ex) {
    		
    		throw new RuntimeException(ex);
    	}
    }

    //-----------------Public Methods------------------
    public void setupVideo(String videoIdentifier, String title, String description, String videoUri) {
    	
    	this.mVideoIdentifier = videoIdentifier;
    	this.mTitle = title;
    	this.mDescription = description;
    	this.mYoutubeUri = videoUri;
    }
    
    public void setupAuthor(String uniqueIdentifier, String author, String authorUri) {
    	
    	this.mAuthorUniqueIdentifier = uniqueIdentifier;
    	this.mAuthorUri = authorUri;
    	this.mAuthor = author;
    }
    
    public void setupVideoData(ZDDate publishDate, ZDDate updateDate, int durationInSeconds, int playQt, int likesQt, int dislikesQt) {
    
    	this.mDurationInSeconds = durationInSeconds;
    	this.mPublishDate = publishDate;
    	this.mUpdatedDate = updateDate;
        
    	this.mPlayTimesQuantity = playQt;
    	this.mLikesQuantity = likesQt;
    	this.mDislikesQuantity = dislikesQt;
    }

    public void setupThumbnails(String thumbnail, String thumbnailAlt) {
    	
    	if(thumbnail != null) {
    		
    		this.mVideoThumbnail = thumbnail;
    	}
    	
    	if(thumbnailAlt != null) {
    		
    		this.mVideoThumbnailAlt = thumbnailAlt;
    	}
    }
    

	public String videoIdentifier() {
		return mVideoIdentifier;
	}

	public String title() {
		return mTitle;
	}

	public String description() {
		return mDescription;
	}

	public String author() {
		return mAuthor;
	}

	public int durationInSeconds() {
		return mDurationInSeconds;
	}

	public String youtubeUri() {
		return mYoutubeUri;
	}

	public String authorUniqueIdentifier() {
		return mAuthorUniqueIdentifier;
	}

	public String authorUri() {
		return mAuthorUri;
	}

	public ZDDate publishDate() {
		return mPublishDate;
	}

	public ZDDate updatedDate() {
		return mUpdatedDate;
	}

	public int playTimesQuantity() {
		return mPlayTimesQuantity;
	}

	public int likesQuantity() {
		return mLikesQuantity;
	}

	public int dislikesQuantity() {
		return mDislikesQuantity;
	}

	public String videoThumbnail() {
		return mVideoThumbnail;
	}

	public String videoThumbnailAlt() {
		return mVideoThumbnailAlt;
	}


    //-----------------Private------------------







    //-----------------Getters and Setters------------------
    
    
}
