package com.zindon.ztube.domain.uidto;

import android.widget.ImageView;
import android.widget.TextView;

public class VideoDTO {

	// ----------------------VARS---------------------
	protected static final String TAG = "Video DTO";
	 		
	private ImageView mVideoThumbnail = null;
	private TextView mVideoTitle = null;
	private TextView mVideoAuthor = null;
	private TextView mVideoTime = null;
	
	// ----------------------CONSTRUCTORS---------------------
	public VideoDTO() {
		
		
	}

	
	
 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	 	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------
	public ImageView getmVideoThumbnail() {
		return mVideoThumbnail;
	}

	public void setmVideoThumbnail(ImageView mVideoThumbnail) {
		this.mVideoThumbnail = mVideoThumbnail;
	}

	public TextView getmVideoTitle() {
		return mVideoTitle;
	}

	public void setmVideoTitle(TextView mVideoTitle) {
		this.mVideoTitle = mVideoTitle;
	}

	public TextView getmVideoAuthor() {
		return mVideoAuthor;
	}

	public void setmVideoAuthor(TextView mVideoAuthor) {
		this.mVideoAuthor = mVideoAuthor;
	}

	public TextView getmVideoTime() {
		return mVideoTime;
	}

	public void setmVideoTime(TextView mVideoTime) {
		this.mVideoTime = mVideoTime;
	}
}
