package com.zindon.ztube;


import java.util.List;

import com.zindon.ztube.application.YTApplication;
import com.zindon.ztube.domain.YTVideo;
import com.zindon.ztube.domain.adapters.VideosListBaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;


public class VideoListActivity extends Activity implements OnItemClickListener {

	// ----------------------VARS---------------------
	protected static final String TAG = "Video List Activity";
	
	private List<YTVideo> theItems = null;
	private String playlistIdentifier = null;
	 		
	
	// ----------------------CONSTRUCTORS---------------------
	public VideoListActivity() {
		
		
	}
	
 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos);
				
			
		Log.d(TAG, "Videos: Create");
		
		
		Intent intent = getIntent();
		YTApplication ytApp = (YTApplication)getApplication();
		
		this.playlistIdentifier = intent.getStringExtra(ytApp.playlistKey());
		
		
		
		//List View
		theItems = YTVideo.findByPlaylistId(this.playlistIdentifier);
		
		
		//Instantiate the Base Adapter
		VideosListBaseAdapter videosBaseAdapter = new VideosListBaseAdapter(this, theItems);

		
		//Setup The ListView
 		ListView theListView = (ListView) findViewById(R.id.listView2videos);

 		//
 		//LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 		//theListView.addHeaderView(inflater.inflate(R.layout.list_header, null)); 
 		//theListView.addFooterView(inflater.inflate(R.layout.list_footer, null));
 		
 		//
 		theListView.setAdapter(videosBaseAdapter);
 		theListView.setTextFilterEnabled(true);
 		theListView.setOnItemClickListener(this);
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
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		
		Log.d(TAG, "POSITION: " + position);
		
		if(position > theItems.size()) {
			
			Log.d(TAG, "LOADING PRESSED...");
			return;
		}
		
		Context context = getApplicationContext(); 
		YTApplication ytApp = (YTApplication)getApplication();
		
//		CharSequence text = "CLICKED ON: " + theItems.get(position);
//		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT); toast.show();
		
		
		//Start Activity
		Intent intent = new Intent(context, VideoDetailActivity.class);
		intent.putExtra(ytApp.videoKey(), theItems.get(position).videoIdentifier());
		startActivity(intent);
		
	}
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

}
