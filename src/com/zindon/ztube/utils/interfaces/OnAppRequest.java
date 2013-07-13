package com.zindon.ztube.utils.interfaces;

/**
 * 
 * This interface  is used to declare the Async Requests.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
public interface OnAppRequest {

	//
	public void onRequestCompleted(Object result);
	
	public void onAsyncRequestCompleted(String result);
	
}
