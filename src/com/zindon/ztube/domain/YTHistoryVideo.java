package com.zindon.ztube.domain;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.zindon.ztube.domain.interfaces.Persistable;
import com.zindon.ztube.utils.ZDDate;

public class YTHistoryVideo extends YTVideo implements Persistable {

	private static final String TAG = "YTHistoryVideo";


	private ZDDate mLastDatePlayed = null;



    //-----------------Constructors------------------
    public YTHistoryVideo(Object dbManager) {
		
    	super();

    	mLastDatePlayed = new ZDDate();
    }

    public YTHistoryVideo(Object dbobj, Object dbManager) {
		
    	super();

    	this.entityToDomainObject();
    }



    //-----------------Static Methods------------------
    public static List<YTHistoryVideo> findAll(Object dbManager) {

        List<YTHistoryVideo> resultList = new ArrayList<YTHistoryVideo>(25);
        //YTHistoryVideo historyVideo = null;

        //Load DB


        return resultList;
    }


    public static String dummyData() {

    	StringBuilder sb = new StringBuilder();
    	
        sb.append("AlhKf7FM7qs");
        sb.append(";");
        sb.append("h33I93LAkAk");
        sb.append(";");
        sb.append("e3eD9v2KG6Q");
        sb.append(";");
        sb.append("0VM2kRrCBb8");
        sb.append(";");
        sb.append("JOKn33-q4Ao");
        sb.append(";");
        sb.append("hdrVKKsCIFI");
        sb.append(";");
        sb.append("yn0omuqUnIg");
        sb.append(";");
        sb.append("sHfVXAlz-e4");
        sb.append(";");
        sb.append("kPk_XadXs6Q");
        sb.append(";");
        sb.append("on6KBN7x3IM");
        
        return sb.toString();
    }




    //-----------------Public Methods------------------
    @Override
	public void enablePersistance() {
		// TODO Auto-generated method stub
    	Log.d(TAG, "YTHistoryVideo: Saved");
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		Log.d(TAG, "YTHistoryVideo: Refreshed");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Log.d(TAG, "YTHistoryVideo: Updated");
	}

	@Override
	public void disablePersistance() {
		// TODO Auto-generated method stub
		Log.d(TAG, "YTHistoryVideo: Deleted");
	}


	//
	public ZDDate lastDatePlayed() {
		return mLastDatePlayed;
	}





    //-----------------Private------------------
	private void entityToDomainObject() {
    	
    	
    	
    	
    }

	





    //-----------------Getters and Setters------------------


}
