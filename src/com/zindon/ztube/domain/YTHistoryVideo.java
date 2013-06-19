package com.zindon.ztube.domain;

import com.zindon.ztube.domain.interfaces.Persistable;

public class YTHistoryVideo extends YTVideo implements Persistable {

	private static final String TAG = "YTHistoryVideo";


    



    //-----------------Constructors------------------
    public YTHistoryVideo() {
		


    }

    public YTHistoryVideo(Object dbobj) {
		

    	this.entityToDomainObject();
    }



    //-----------------Static Methods------------------






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
