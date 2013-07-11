package com.zindon.ztube.domain.adapters;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zindon.ztube.R;
import com.zindon.ztube.domain.YTVideo;
import com.zindon.ztube.domain.uidto.VideoDTO;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VideosListBaseAdapter extends BaseAdapter {

	// ----------------------VARS---------------------
	protected static final String TAG = "Videos List BaseAdapter";
	 
	private List<YTVideo> theItems;
	private LayoutInflater inflater;
	
	// ----------------------CONSTRUCTORS---------------------
	public VideosListBaseAdapter(Activity activity, List<YTVideo>theItems) {
		
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
		
		VideoDTO itemVideo;
		
		Log.d(TAG, "getVIew");
		
		if(convertView == null) {
			
			itemVideo = new VideoDTO();
			
			//injeccao do layout (o schema do layout) no meu objecto PlaylistDTO
			convertView = inflater.inflate(R.layout.lvitem_video, null);
			
			//Preset do meu objecto PlaylistDTO com os textos por defeito do schema do layout
			itemVideo.setmVideoTitle((TextView)convertView.findViewById(R.id.textView_vd_title));
			itemVideo.setmVideoAuthor((TextView)convertView.findViewById(R.id.textView_vd_author));
			itemVideo.setmVideoThumbnail((ImageView)convertView.findViewById(R.id.imageView_vd_thumbnail));
			//itemVideo.setmVideoTime((TextView)convertView.findViewById(R.id.textView_pl_qt));
						
			convertView.setTag(itemVideo);
		}
		else {
			
			itemVideo = (VideoDTO) convertView.getTag();
		}
		
		
		//Agora sim, meto os textos correctos
		itemVideo.getmVideoTitle().setText(this.theItems.get(position).title());
		itemVideo.getmVideoAuthor().setText(this.theItems.get(position).author());
		//itemPlaylist.getmPlaylistThumbnail();
		
		
		//Load da imagem
 		DisplayImageOptions options = new DisplayImageOptions.Builder()
 			.build();
 		
 		ImageLoader.getInstance().displayImage(theItems.get(position).videoThumbnail(), itemVideo.getmVideoThumbnail(), options);
 		
		return convertView;
	}
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

}
