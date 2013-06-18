package com.zindon.ztube.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge on 6/17/13.
 */
public class YTPlaylist {

    private static final String TAG = "YTPlaylist";


    private int plIdentifier = 0;
    private String name = null;
    private String description = null;

    private List<YTVideo> videosList = null;





    //-----------------Constructors------------------
    public YTPlaylist() {

        videosList = new ArrayList<YTVideo>();
    }




    //-----------------Static Methods------------------






    //-----------------Public Methods------------------







    //-----------------Private------------------







    //-----------------Getters and Setters------------------


}
