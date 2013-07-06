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

public class VideoDetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

	// ----------------------VARS---------------------
		protected static final String TAG = "Video Detail Activity";
				
		private String videoIdentifier = null;
		private YouTubePlayerView playerView;
		private YouTubePlayer player;
		
		
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
					
				
			Log.d(TAG, "Video: Create");
			
			
			Intent intent = getIntent();
			YTApplication ytApp = (YTApplication)getApplication();
			
			this.videoIdentifier = intent.getStringExtra(ytApp.videoKey());
		
			
			playerView = (YouTubePlayerView) findViewById(R.id.youtubeplayer);
			playerView.initialize(ytApp.developerKey(), this);
			
			
			if(YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(getApplicationContext()).equals(YouTubeInitializationResult.SUCCESS)) {
			   //This means that your device has the Youtube API Service (the app) and you are safe to launch it. 
				Log.d(TAG, "Service available");
			}else{
			   // Log the outcome, take necessary measure, like playing the video in webview :) 
				Log.d(TAG, "Service not available");
			}
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

		@Override
		protected void onStart() {
			
			super.onStart();
			Log.d(TAG, "method: onStart");
		
		}
	    
		@Override
	    protected void onRestart() {
			
			super.onRestart();
			Log.i(TAG, "method: onRestart");
		}

		@Override
	    protected void onResume() {
			
			super.onResume();
			Log.i(TAG, "method: onResume");
			
			YTVideo theVideo = YTVideo.findByIdentifier(this.videoIdentifier);
			
			
			TextView viewTitle = (TextView) findViewById(R.id.textView_vdetail_title);
			viewTitle.setText(theVideo.title());
			
			TextView viewAuthor= (TextView) findViewById(R.id.textView_vdetail_author);
			viewAuthor.setText(theVideo.author());
			
			TextView viewPublishDate = (TextView) findViewById(R.id.textView_vdetail_date);
			viewPublishDate.setText(theVideo.publishDate().toString());
		}

		@Override
	    protected void onPause() {
			
			super.onPause();
			Log.i(TAG, "method: onPause");
		}

		@Override
	    protected void onStop() {
			
			super.onStop();
			Log.i(TAG, "method: onStop");
		}

		@Override
	    protected void onDestroy() {
			
			super.onDestroy();
			Log.i(TAG, "method: onDestroy");
		}
		
		
		
		
		@Override
		public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
			Log.d(TAG, result.toString());
		}

		@Override
		public void onInitializationSuccess(Provider provider, YouTubePlayer vPlayer, boolean wasRestored) {
			
			this.player = vPlayer;
			this.player.cueVideo(videoIdentifier);
		}
		
		// ----------------------PUBLIC METHODS - NORMAL---------------------
		
		// ----------------------PRIVATE METHODS---------------------
		

		// ----------------------GETTERS and SETTERS---------------------

}
