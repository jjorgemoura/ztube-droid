package com.zindon.ztube.domain;

import java.util.ArrayList;
import java.util.List;

import com.zindon.ztube.domain.interfaces.Persistable;
import com.zindon.ztube.utils.ZDDate;

public class YTHistoryVideo extends YTVideo implements Persistable {

	private static final String TAG = "YTHistoryVideo";


	private ZDDate mLastDatePlayed = null;



    //-----------------Constructors------------------
    public YTHistoryVideo(Object dbManager) {
		


    }

    public YTHistoryVideo(Object dbobj, Object dbManager) {
		

    	this.entityToDomainObject();
    }



    //-----------------Static Methods------------------
    public static List<YTHistoryVideo> findAll(Object dbManager) {

        List<YTHistoryVideo> resultList = new ArrayList<YTHistoryVideo>(25);
        YTHistoryVideo historyVideo = null;

        //Load DB


        return resultList;
    }





    //-----------------Public Methods------------------
    @Override
	public void enablePersistance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disablePersistance() {
		// TODO Auto-generated method stub
		
	}






    //-----------------Private------------------
	private void entityToDomainObject() {
    	
    	
    	
    	
    }






    //-----------------Getters and Setters------------------


}
