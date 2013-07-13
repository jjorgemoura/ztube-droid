package com.zindon.ztube.utils;

import com.zindon.ztube.utils.interfaces.OnAppRequest;

import android.os.AsyncTask;


/**
 * 
 * This class is the AsyncTask Manager. Used to communicate with the Yuotube API
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
public class RequestAsyncTask extends AsyncTask<String, Void, String> {
	
	
	//Vars
	private static final String TAG = "RequestAsyncTask";
	
	private OnAppRequest mOnAppRequest;

	
	//Constructor
	public RequestAsyncTask(OnAppRequest onAppRequest) {
		super();

		this.mOnAppRequest = onAppRequest;
	}

	
	//-------------------------
	@Override
	public void onPreExecute() {
		
		
	}
	
	@Override
	protected String doInBackground(String... args) {
		
		String url = null;
		
		//int count = arg0.length;
		for(String s : args) {
			
			url = s;
		} 
		
//		Log.d(TAG, url);
		String result = RestHttpClient.getRequest(url, null);

		return result;
	}

	@Override
	public void onPostExecute(String str) {
		
//		Log.d(TAG, "onPostExecute: " + str);
		
		mOnAppRequest.onAsyncRequestCompleted(str);
	}

}
