package com.zindon.ztube.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkConnectivity {

	// ----------------------VARS---------------------
	protected static final String TAG = "Network Connectivity";
 	
	
	
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	public static boolean isConnected(Context context) {
		
		ConnectivityManager connMgr = null;
		NetworkInfo networkInfo = null;
		
		boolean result = false;
		
		
		//--------
		connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		
		boolean isWifiConn = networkInfo.isConnected();
		
		if(isWifiConn) {
			
			result = true;
			Log.d(TAG, "Wifi Connected.");
		}
		
		//Se ainda nao esta ligado por Wifi, vou testar por 3G
		if(!result) {
			
			networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			
			boolean is3GConn = networkInfo.isConnected();
			
			if(is3GConn) {
				
				result = true;
				Log.d(TAG, "3G Connected.");
			}
		}
		
		
		return result;
	}
	
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	 	
	
	
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------

	// ----------------------PRIVATE METHODS---------------------
		

	// ----------------------GETTERS and SETTERS---------------------

}
