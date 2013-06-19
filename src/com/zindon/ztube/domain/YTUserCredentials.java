package com.zindon.ztube.domain;

import com.zindon.ztube.domain.interfaces.Persistable;


/**
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version %I%, %G%
 * @since API 1
 */
public class YTUserCredentials implements Persistable {

    private static final String TAG = "YTUserCredentials";

    private Object mDbManager = null;
    private Object mDbEntity = null;
    

    private String mUsername = null;
    private String mPassword = null;
    
    private String mEmail = null;




    //-----------------Constructors------------------
    /**
     * 
     * @param username
     */
    public YTUserCredentials(String username, Object dbManager) {

        this.mUsername = username;

    }

    /**
     * 
     * @param dbobj
     */
    public YTUserCredentials(Object dbobj, Object dbManager) {
        
        this.entityToDomainObject();
    }



	



    //-----------------Static Methods------------------
    /**
     * 
     * @param id
     * @param dbManager
     * @return
     */
    public static YTUserCredentials retrive(long id, Object dbManager) {

    	YTUserCredentials result = null;

        //load from DB
        //
    	
    	//


        return result;
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
	
	
	
	//--------------------------------
    public void login() {
    	
    	
    }

    public void logout() {
    	
    	
    }

    public boolean isLogon() {
    	
    	boolean result = true;
    	
    	
    	return result;
    }



    //-----------------Private------------------
    private void entityToDomainObject() {
    	
    	this.mUsername = "zsd";
    	this.mEmail = "";
    }






    //-----------------Getters and Setters------------------
    /**
     * 
     * @return
     */
    public String getUsername() {
		return mUsername;
	}

   
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return mEmail;
	}

	

    
}
