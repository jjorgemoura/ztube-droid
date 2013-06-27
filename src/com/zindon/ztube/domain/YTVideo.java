package com.zindon.ztube.domain;

import com.zindon.ztube.utils.ZDDate;



/**
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version %I%, %G%
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
    
    
    //video
    private int mDurationInSeconds = 0;
    private ZDDate mPublishDate = null;
    private ZDDate mUpdatedDate = null;
    
    private int mPlayTimesQuantity = 0;
    private int mLikesQuantity = 0;
    private int mDislikesQuantity = 0;
    
    


    //-----------------Constructors------------------
    public YTVideo() {


    }




    //-----------------Static Methods------------------






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


    //-----------------Private------------------







    //-----------------Getters and Setters------------------
    
    
}
