package com.zindon.ztube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

import com.zindon.ztube.application.YTApplication;
import com.zindon.ztube.domain.YTPlaylist;
import com.zindon.ztube.domain.YTVideo;
import com.zindon.ztube.domain.adapters.PlaylistsListBaseAdapter;
import com.zindon.ztube.domain.adapters.VideosListBaseAdapter;
import com.zindon.ztube.utils.interfaces.OnAppRequest;

public class HistoryVideosActivity extends Activity implements OnItemClickListener, OnAppRequest {

	// ----------------------VARS---------------------
	protected static final String TAG = "History Videos Activity";
	
	protected Context context; 
	
	private List<YTVideo> theItems = null;
	 		
	
	// ----------------------CONSTRUCTORS---------------------
	public HistoryVideosActivity() {
		
		
	}
	
 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videohistory);
			
		context = getApplicationContext(); 
			
		Log.d(TAG, "History Videos: Create");
		
		
		Intent intent = getIntent();
		YTApplication ytApp = (YTApplication)getApplication();
		
		
		
		
		
		//List View
		String historyContent = this.readFileFromInternalStorage(getString(R.string.datafile_privatefile));
		
		//String[] splitArray = historyContent.split(";");
		
		theItems = YTVideo.findByVideoHistory(historyContent, this);
		
		
		
		//Instantiate the Base Adapter
		VideosListBaseAdapter videosBaseAdapter = new VideosListBaseAdapter(this, theItems);

		
		//Setup The ListView
 		ListView theListView = (ListView) findViewById(R.id.listView2videos);

 		
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
		
		
		//Start Activity
		Intent intent = new Intent(context, VideoDetailActivity.class);
		intent.putExtra(ytApp.videoKey(), theItems.get(position).videoIdentifier());
		startActivity(intent);
		
	}
	
	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	//Para o CALLBACK
	public void onRequestCompleted(Object result) {
		
		List<YTVideo> myResultList = null;
		
		if(result instanceof List) {
			
			myResultList = (List<YTVideo>)result; 
			Log.d(TAG, "List Size: " + myResultList.size());
		}
		

		//adiciona aos j‡ existentes.
		theItems.addAll(myResultList);
		
	
		//Instantiate the Base Adapter
		VideosListBaseAdapter videosBaseAdapter = new VideosListBaseAdapter(this, theItems);

		
		//Setup The ListView
 		ListView theListView = (ListView) findViewById(R.id.listViewhvideos);
 		theListView.setAdapter(videosBaseAdapter);
	}
	
	//Para o ASYNC
  	public void onAsyncRequestCompleted(String result) {
  		
  		Log.d(TAG, "onAsyncRequestCompleted");
  		
  		YTVideo.buildList(result, this);	
  	}
	  	
	  	
	
	// ----------------------PRIVATE METHODS---------------------
	private String readFileFromInternalStorage(String fileName) {
		
		String result = "";
		
		try {
			File file = new File(context.getFilesDir(), fileName);
			
			if(!file.isFile()) {
				
				return "FILE NOT AVAILABLE";
			}
			
			FileInputStream inStream = openFileInput(fileName); 
			inStream.read(result.getBytes());
			
			int content;
			while ((content = inStream.read()) != -1) {
				// convert to char and display it
				//System.out.print((char) content);
				result = result + (char) content;
				
			}
			
			Log.d(TAG, result);
			
			inStream.close();
		}
		catch(FileNotFoundException ex) {
			
			throw new RuntimeException(ex);
		}
		catch(IOException ex) {
			
			throw new RuntimeException(ex);
		}
		catch(Exception ex) {
			
			throw new RuntimeException(ex);
		}
		
		return result;
	}

	// ----------------------GETTERS and SETTERS---------------------

}
