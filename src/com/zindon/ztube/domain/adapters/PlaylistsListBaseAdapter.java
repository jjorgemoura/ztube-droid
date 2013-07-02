package com.zindon.ztube.domain.adapters;

import java.util.List;

import com.zindon.ztube.R;
import com.zindon.ztube.domain.YTPlaylist;
import com.zindon.ztube.domain.uidto.PlaylistDTO;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
		
		Log.d(TAG, "getCount> " + this.theItems.size());
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
		
		PlaylistDTO itemPlaylist;
		
		Log.d(TAG, "getVIew");
		
		if(convertView == null) {
			
			itemPlaylist = new PlaylistDTO();
			
			//injeccao do layout (o schema do layout) no meu objecto PlaylistDTO
			convertView = inflater.inflate(R.layout.lvitem_playlist, null);
			
			//Preset do meu objecto PlaylistDTO com os textos por defeito do schema do layout
			itemPlaylist.setmPlaylistTitle((TextView)convertView.findViewById(R.id.textView_pl_title));
			itemPlaylist.setmPlaylistSummary((TextView)convertView.findViewById(R.id.textView_pl_sumary));
			itemPlaylist.setmPlaylistThumbnail((ImageView)convertView.findViewById(R.id.imageView_pl_thumbnail));
			itemPlaylist.setmPlaylistQt((TextView)convertView.findViewById(R.id.textView_pl_qt));
						
			convertView.setTag(itemPlaylist);
		}
		else {
			
			itemPlaylist = (PlaylistDTO) convertView.getTag();
		}
		
		
		//Agora sim, meto os textos correctos
		itemPlaylist.getmPlaylistTitle().setText(this.theItems.get(position).title());
		itemPlaylist.getmPlaylistSummary().setText(this.theItems.get(position).summary());
		//itemPlaylist.getmPlaylistThumbnail();
		
		String videoQT = "";
		if(this.theItems.get(position).videoQuantity() == 1) {
			
			videoQT = "1 video";
		}
		else {
			
			videoQT = this.theItems.get(position).videoQuantity() + " videos";
		}
		
		itemPlaylist.getmPlaylistQt().setText(videoQT);;
		
		
 
		return convertView;
	}
	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

}