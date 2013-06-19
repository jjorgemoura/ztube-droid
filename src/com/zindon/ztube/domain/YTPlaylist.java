package com.zindon.ztube.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version %I%, %G%
 * @since API 1
 */
public class YTPlaylist {

    private static final String TAG = "YTPlaylist";


    private int mPlaylistIdentifier = 0;
    private String mName = null;
    private String mDescription = null;

    private List<YTVideo> mVideosList = null;





    //-----------------Constructors------------------
    public YTPlaylist() {

        mVideosList = new ArrayList<YTVideo>();
    }




    //-----------------Static Methods------------------






    //-----------------Public Methods------------------

    public void myVideos() {
    	
    	
    }






    //-----------------Private------------------







    //-----------------Getters and Setters------------------


}
