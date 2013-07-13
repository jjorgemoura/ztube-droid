package com.zindon.ztube;


import java.util.List;

import com.zindon.ztube.application.YTApplication;
import com.zindon.ztube.domain.YTPlaylist;
import com.zindon.ztube.domain.adapters.PlaylistsListBaseAdapter;
import com.zindon.ztube.utils.interfaces.OnAppRequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 
 * Activity responsible with the Playlist Activity. This activity shows a ListView will all playlists for the userID stored in Shared Preferences.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
public class PlaylistActivity extends Activity implements OnItemClickListener, OnAppRequest {

	// ----------------------VARS---------------------
	/**
	 * 
	 */
	protected static final String TAG = "Main Activity";
	
	protected Context mContext; 
	private List<YTPlaylist> mTheItems = null;
	
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//-----------Activity Lifecycle-----------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_playlists);
		
//		Log.d(TAG, "Playlist: Create");
		
		//Buscar contexto da App
		mContext = getApplicationContext(); 
		YTApplication ytApp = (YTApplication)getApplication();
		
		
		//Read UserIdentifier from SharedPreferences
		String userIdentifier;
		
		
		userIdentifier = this.getDataFromSharedPrefs(getString(R.string.sharedpreference_hash_pref1));
		
		if(userIdentifier == null) {
			
			userIdentifier = "condorouro";
		}
		
		
		//List View
		//theItems = YTPlaylist.findByUserId("acxpt1");
		mTheItems = YTPlaylist.findByUserId(userIdentifier, this, ytApp.useDummyData());
		
		
		//Instantiate the Base Adapter
		PlaylistsListBaseAdapter playlistBaseAdapter = new PlaylistsListBaseAdapter(this, mTheItems);

		
		//Setup The ListView
 		ListView theListView = (ListView) findViewById(R.id.listView1);

 		//
 		//LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 		//theListView.addHeaderView(inflater.inflate(R.layout.list_header, null)); 
 		//theListView.addFooterView(inflater.inflate(R.layout.list_footer, null));
 		
 		//
 		theListView.setAdapter(playlistBaseAdapter);
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
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
//		Log.d(TAG, "POSITION: " + position);
		
		if(position > mTheItems.size()) {
			
			Log.d(TAG, "LOADING PRESSED...");
			return;
		}
		
		Context context = getApplicationContext(); 
		YTApplication ytApp = (YTApplication)getApplication();
		
		//CharSequence text = "CLICKED ON: " + theItems.get(position);
		//Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT); toast.show();
		
		
		//Start Activity
		Intent intent = new Intent(context, VideoListActivity.class);
		intent.putExtra(ytApp.playlistKey(), mTheItems.get(position).playlistIdentifier());
		startActivity(intent);
		
	}
	
	
	
	
	//Para o CALLBACK
	public void onRequestCompleted(Object result) {
		
		//List<YTPlaylist> myResultList = null;
		
		if(result instanceof List) {
			
			mTheItems = (List<YTPlaylist>)result; 
//			Log.d(TAG, "List Size: " + theItems.size());
		}
			
		//Instantiate the Base Adapter
		PlaylistsListBaseAdapter playlistBaseAdapter = new PlaylistsListBaseAdapter(this, mTheItems);

		
		//Setup The ListView
 		ListView theListView = (ListView) findViewById(R.id.listView1);
 		theListView.setAdapter(playlistBaseAdapter);
	}
	
	//Para o ASYNC
  	public void onAsyncRequestCompleted(String result) {
  		
//  		Log.d(TAG, "onAsyncRequestCompleted");
  		//CharSequence text = "CALL BACK Async EVENT: " + result;
  		
  		YTPlaylist.buildList(result, this);	
  	}
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
  	private String getDataFromSharedPrefs(String key) {
		
		String result = null;
		
		String spFilename = getString(R.string.sharedpreference_privatefile);
		
		//SharedPreferences myPreferences = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences mySharedPreferences = this.mContext.getSharedPreferences(spFilename, Context.MODE_PRIVATE);
		
		result = mySharedPreferences.getString(key, "");
		
		return result;
	}
	

	// ----------------------GETTERS and SETTERS---------------------

}
