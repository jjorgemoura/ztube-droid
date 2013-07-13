package com.zindon.ztube.domain.uidto;

import android.widget.ImageView;
import android.widget.TextView;


/**
 * 
 * This class is the Datasource for the Base Adapter of Playlists List View.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
public class PlaylistDTO {

	// ----------------------VARS---------------------
	protected static final String TAG = "Playlist DTO";
	 	
	private ImageView mPlaylistThumbnail = null;
	private TextView mPlaylistTitle = null;
	private TextView mPlaylistSummary = null;
	private TextView mPlaylistQt = null;
	
	
	// ----------------------CONSTRUCTORS---------------------
	public PlaylistDTO() {
		
		
	}


	
	
 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	 	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------
	public ImageView getmPlaylistThumbnail() {
		return mPlaylistThumbnail;
	}


	public void setmPlaylistThumbnail(ImageView mPlaylistThumbnail) {
		this.mPlaylistThumbnail = mPlaylistThumbnail;
	}


	public TextView getmPlaylistTitle() {
		return mPlaylistTitle;
	}


	public void setmPlaylistTitle(TextView mPlaylistTitle) {
		this.mPlaylistTitle = mPlaylistTitle;
	}


	public TextView getmPlaylistSummary() {
		return mPlaylistSummary;
	}


	public void setmPlaylistSummary(TextView mPlaylistSummary) {
		this.mPlaylistSummary = mPlaylistSummary;
	}




	public TextView getmPlaylistQt() {
		return mPlaylistQt;
	}




	public void setmPlaylistQt(TextView mPlaylistQt) {
		this.mPlaylistQt = mPlaylistQt;
	}
	
	
}
