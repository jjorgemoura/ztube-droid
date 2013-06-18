package com.zindon.ztube.domain;


/**
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version %I%, %G%
 * @since API 1
 */
public class YTUserCredentials {

    private static final String TAG = "YTUserCredentials";


    private String username = null;
    private String password = null;
    
    private String email = null;




    //-----------------Constructors------------------
    public YTUserCredentials(String username) {

        this.username = username;

    }




	



    //-----------------Static Methods------------------






    //-----------------Public Methods------------------
    public void login() {
    	
    	
    }

    public void logout() {
    	
    	
    }





    //-----------------Private------------------







    //-----------------Getters and Setters------------------
    /**
     * 
     * @return
     */
    public String getUsername() {
		return username;
	}

    /**
     * 
     * @return
     */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

    
}
