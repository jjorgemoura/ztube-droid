package com.zindon.ztube.domain;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.zindon.ztube.domain.data.DummyDataFactory;
import com.zindon.ztube.utils.ZDDate;

/**
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version %I%, %G%
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
    
    
    //
    private List<YTVideo> mVideosList = null;





    //-----------------Constructors------------------
    public YTPlaylist() {

        mVideosList = new ArrayList<YTVideo>();
    }




    //-----------------Static Methods------------------
    public static List<YTPlaylist> findByUserId(String userId) {
    	
    	List<YTPlaylist> resultList = new ArrayList<YTPlaylist>();
    	
    	if(true) {
    		
    		resultList = DummyDataFactory.dummyPlaylistsBySubscription(userId);
    	}
    	else {
    		
    		
    	}
    	
    	
    	Log.d(TAG, "YTPlaylist: Size = " + resultList.size());
    	
    	return resultList;
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



    //-----------------Private------------------







    //-----------------Getters and Setters------------------


}
