package com.zindon.ztube.utils;

import com.zindon.ztube.utils.interfaces.OnAppRequest;

import android.os.AsyncTask;
import android.util.Log;


public class RequestAsyncTask extends AsyncTask<String, Void, String> {
	
	
	//Vars
	private static final String TAG = "RequestAsyncTask";
	
	private OnAppRequest onAppRequest;

	
	//Constructor
	public RequestAsyncTask(OnAppRequest onAppRequest) {
		super();

		this.onAppRequest = onAppRequest;
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
		
		String result = RestHttpClient.getRequest(url, null);

		return result;
	}

	@Override
	public void onPostExecute(String str) {
		
		Log.d(TAG, "onPostExecute: " + str);
		
		onAppRequest.onAsyncRequestCompleted(str);
	}

}
