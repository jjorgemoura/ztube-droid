package com.zindon.ztube;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.zindon.ztube.application.YTApplication;
import com.zindon.ztube.domain.YTVideo;
import com.zindon.ztube.utils.ZDDate;
import com.zindon.ztube.utils.interfaces.OnAppRequest;

/**
 * 
 * Activity responsible with the Video Detail Activity. This activity plays the video selected and shows some informations.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @since API 1
 *
 */
public class VideoDetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, OnAppRequest {

	// ----------------------VARS---------------------
	protected static final String TAG = "Video Detail Activity";
	
	private String mPlaylistIdentifier = null;
	private String mVideoIdentifier = null;
	private YouTubePlayerView mPlayerView;
	private YouTubePlayer mPlayer;
	
	
	// ----------------------CONSTRUCTORS---------------------
	public VideoDetailActivity() {
		
		
	}
	
 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videodetail);
			
//		Log.d(TAG, "Video: Create");
		
		Intent intent = getIntent();
		YTApplication ytApp = (YTApplication)getApplication();
		
		this.mVideoIdentifier = intent.getStringExtra(ytApp.videoKey());
		this.mPlaylistIdentifier = intent.getStringExtra(ytApp.playlistKey());
		
		Log.d(TAG, "VIDEO IDENTIFIER" + mVideoIdentifier);
		
		
		
		YTVideo theVideo = YTVideo.findByIdentifier(this.mVideoIdentifier, this, ytApp.useDummyData());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
//		//UpNavigation
//		this.getActionBar().setDisplayHomeAsUpEnabled(true);
		
		return true;
	}

	@Override
	protected void onStart() {
		
		super.onStart();
//		Log.d(TAG, "method: onStart");
	}
    
	@Override
    protected void onRestart() {
		
		super.onRestart();
//		Log.i(TAG, "method: onRestart");
	}

	@Override
    protected void onResume() {
		
		super.onResume();
//		Log.i(TAG, "method: onResume");
	}

	@Override
    protected void onPause() {
		
		super.onPause();
//		Log.i(TAG, "method: onPause");
	}

	@Override
    protected void onStop() {
		
		super.onStop();
//		Log.i(TAG, "method: onStop");
	}

	@Override
    protected void onDestroy() {
		
		super.onDestroy();
//		Log.i(TAG, "method: onDestroy");
	}
	
	
	
	
	
	//---------------------
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//	    
//		Log.d(TAG, "onOptionsItemSelected: itemID: " + item.getItemId());
//		
//		switch (item.getItemId()) {
//	    
//	    case android.R.id.home:
//	        
//	    	
//	    	YTApplication ytApp = (YTApplication)getApplication();
//			
//	    	Intent intent = new Intent(getApplicationContext(), VideoListActivity.class);
//	    	intent.putExtra(ytApp.playlistKey(), this.mPlaylistIdentifier);
//	    	
//	    	NavUtils.navigateUpFromSameTask(this);
//	    	//NavUtils.navigateUpTo(this, VideoListActivity.class);
//	    	Log.d(TAG, "PARENT: " + NavUtils.getParentActivityName(this));
//	        Log.d(TAG, "onOptionsItemSelected: R HOME");
//	        return true;
//	    }
//	    return super.onOptionsItemSelected(item);
//	}
	
	
	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
//		Log.d(TAG, result.toString());
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer vPlayer, boolean wasRestored) {
		
		this.mPlayer = vPlayer;
		this.mPlayer.cueVideo(this.mVideoIdentifier);
		//this.player.
	}
	
	
	
	//Para o CALLBACK
	public void onRequestCompleted(Object result) {
		
		YTVideo theVideo = null;
		
		
		if(result instanceof YTVideo) {
			
			theVideo = (YTVideo)result; 
		}
			
		
 		YTApplication ytApp = (YTApplication)getApplication();
 		
		mPlayerView = (YouTubePlayerView) findViewById(R.id.youtubeplayer);
		mPlayerView.initialize(ytApp.developerKey(), this);
		
		
		if(YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(getApplicationContext()).equals(YouTubeInitializationResult.SUCCESS)) {
		   //This means that your device has the Youtube API Service (the app) and you are safe to launch it. 
			Log.d(TAG, "Service available");
		}else{
		   // Log the outcome, take necessary measure, like playing the video in webview :) 
			Log.d(TAG, "Service not available");
		}
		
		
 		

		TextView viewTitle = (TextView) findViewById(R.id.textView_vdetail_title);
		viewTitle.setText(theVideo.title());
		
		TextView viewAuthor= (TextView) findViewById(R.id.textView_vdetail_author);
		viewAuthor.setText(theVideo.author());
		
		TextView viewPublishDate = (TextView) findViewById(R.id.textView_vdetail_date);
		viewPublishDate.setText("Data Criação: " + theVideo.publishDate().toString(ZDDate.FORMAT_ONLY_DATE));
		
		TextView viewDescription = (TextView) findViewById(R.id.textView_vdetail_description);
		viewDescription.setText(theVideo.description());
		
		TextView viewQT = (TextView) findViewById(R.id.textView_vdetail_qt);
		viewQT.setText("" + theVideo.playTimesQuantity());
		
		TextView viewLike = (TextView) findViewById(R.id.textView_vdetail_like);
		viewLike.setText("" + theVideo.likesQuantity());
		
		TextView viewDislike = (TextView) findViewById(R.id.textView_vdetail_dislike);
		viewDislike.setText("" + theVideo.dislikesQuantity());
		
		TextView viewVideoDuration = (TextView) findViewById(R.id.textView_vdetail_videoduration);
		viewVideoDuration.setText("Duração: " + ZDDate.printSecondsAsTime(theVideo.durationInSeconds()));
	}
	
	//Para o ASYNC
  	public void onAsyncRequestCompleted(String result) {
  		
  		Log.d(TAG, "onAsyncRequestCompleted");
  		
  		//CharSequence text = "CALL BACK Async EVENT: " + result;
  		
  		YTVideo.buildVideo(result, this);	
  	}
		// ----------------------PUBLIC METHODS - NORMAL---------------------
		
		// ----------------------PRIVATE METHODS---------------------
		

		// ----------------------GETTERS and SETTERS---------------------

}
