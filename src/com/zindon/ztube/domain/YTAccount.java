package com.zindon.ztube.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version %I%, %G%
 * @since API 1
 */
public class YTAccount {

    private static final String TAG = "YTAccount";


    private YTUserCredentials mUserCredentials = null;

    private Map<Integer, YTPlaylist> mPlaylistsList = null;
    private Map<Integer, YTHistoryVideo> mHistoryVideos = null;




    //-----------------Constructors------------------
    public YTAccount(YTUserCredentials userCredentials) {

        this.mUserCredentials = userCredentials;

        this.mHistoryVideos = new HashMap<Integer, YTHistoryVideo>();
        this.mPlaylistsList = new HashMap<Integer, YTPlaylist>();		
    }




    //-----------------Static Methods------------------
    





    //-----------------Public Methods------------------
    
    public void doSearchVideos(String searchText) {
    	
    	//make the search
    	
    	
    	//store results in temp to allow pagination
    } 
    
    

    public void myPlaylists() {
    	
    }
    
    
    public void myHistoryVideos() {
    	
    	if(this.mHistoryVideos.isEmpty()) {
    		
    		this.lazyLoadHistoryVideos();
    	}
    	
    	
    	//return list
    }



    
    /**
     * 
     * @return
     */
    public YTUserCredentials userInfo() {
    	    	
    	return this.mUserCredentials;
    }



    //-----------------Private------------------
    private void lazyLoadHistoryVideos() {
        
        //from DB
    	
    }






    //-----------------Getters and Setters------------------


}
