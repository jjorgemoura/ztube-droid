package com.zindon.ztube.domain.adapters;

import java.util.ArrayList;
import java.util.List;

import com.zindon.ztube.domain.YTPlaylist;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PlaylistsListBaseAdapter extends BaseAdapter {

	// ----------------------VARS---------------------
	protected static final String TAG = "Playlists List BaseAdapter";
	 	
	private List<YTPlaylist> theItems;
	private LayoutInflater inflater;
	
	
	// ----------------------CONSTRUCTORS---------------------
	public PlaylistsListBaseAdapter(Activity activity, List<YTPlaylist>theItems) {
		
		Log.d(TAG, "INSTANCIATE StandardListBaseAdapter");
		
		//this.setupArrayString(itensQT);
		this.theItems = theItems;
		this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	//---------------List Data Source-------------
	@Override
	public int getCount() {
		
		Log.d(TAG, "getCount");
		return theItems.size();
	}

	@Override
	public Object getItem(int index) {

		Log.d(TAG, "getItem");
		return theItems.get(index);
	}

	@Override
	public long getItemId(int indexID) {
		
		Log.d(TAG, "getItemID");
		
		//o index que vou utilizar e a posicao do array
		return indexID;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		Log.d(TAG, "getVIew");
 
		return convertView;
	}
	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

}
