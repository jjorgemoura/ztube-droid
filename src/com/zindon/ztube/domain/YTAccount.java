package com.zindon.ztube.domain;

import java.util.List;

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

    private List<YTPlaylist> mPlaylistsList = null;
    private List<YTHistoryVideo> mHistoryVideos = null;




    //-----------------Constructors------------------
    public YTAccount(YTUserCredentials userCredentials) {

        this.mUserCredentials = userCredentials;

    }




    //-----------------Static Methods------------------






    //-----------------Public Methods------------------

    public void myPlaylists() {
    	
    	
    	
    	
    }
    
    






    //-----------------Private------------------







    //-----------------Getters and Setters------------------


}
