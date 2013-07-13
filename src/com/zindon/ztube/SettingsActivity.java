package com.zindon.ztube;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.zindon.ztube.domain.YTHistoryVideo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * Activity responsible with the Settings Activity.
 *  
 * Created by jorge on 6/17/13.
 * 
 * @author jorge
 * @version 1
 * @target API 1
 *
 */
public class SettingsActivity extends Activity implements OnClickListener {

	// ----------------------VARS---------------------
	/**
	 * 
	 */
	protected static final String TAG = "Settings Activity";
	 	
	/**
	 * 
	 */
	protected Context mContext; 
	
	// ----------------------CONSTRUCTORS---------------------

 	// ----------------------STATIC METHODS---------------------
	
		
 	// ----------------------PUBLIC METHODS - INTERFACE--------------------
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		
		
		Button myButtonAddUser = (Button) findViewById(R.id.button_saveuser);
		myButtonAddUser.setOnClickListener(this);
		
		
		Button myButtonAddDummyData = (Button) findViewById(R.id.button_adddummyhist);
		myButtonAddDummyData.setOnClickListener(this);
		
		Button myButtonDelHistory = (Button) findViewById(R.id.button_deletehistory);
		myButtonDelHistory.setOnClickListener(this);
		
		//to Static method
		mContext = getApplicationContext(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	//OnClickListener INTERFACE
	@Override
	public void onClick(View v) {
			
		//Button btn = (Button)v;
		//String btnStr = (String)btn.getText();
		
		
		String spText = "";
		
		
		
		
		
		int id = v.getId();
		
		switch (id) {
		case R.id.button_saveuser:
		
			EditText editViewUser = (EditText) findViewById(R.id.editText_user);
			
			String userIdToSave = editViewUser.getText().toString();
			
			//this.saveDataOnSharedPrefs(getString(R.string.sharedpreference_hash_pref1), "condorouro");
			this.saveDataOnSharedPrefs(getString(R.string.sharedpreference_hash_pref1), userIdToSave);
			spText = "user saved";
			
			break;
		
		case R.id.button_adddummyhist:
			
			String videoHist = YTHistoryVideo.dummyData();
			
			this.writeFileToInternalStorage(getString(R.string.datafile_privatefile), videoHist);
			
			if(spText == null || spText.equals("")) {
				
				spText = "file saved";
			}
			
			break;
			
		case R.id.button_deletehistory:
			
			this.deleteInternalFile(getString(R.string.datafile_privatefile));
			spText = "File deleted";
			break;
			
		}
		
		
		CharSequence textSP = "SETTINGS : " + spText;
		
		Toast toast = Toast.makeText(mContext, textSP, Toast.LENGTH_SHORT); 
		toast.show();
	}
	
	// ----------------------PUBLIC METHODS - NORMAL---------------------
	//--------------By SHARED PREFERENCES---------------
	public void saveDataOnSharedPrefs(String key, String value) {
		
		String spFilename = getString(R.string.sharedpreference_privatefile);
		SharedPreferences mySharedPreferences = this.mContext.getSharedPreferences(spFilename, Context.MODE_PRIVATE);
		
		Editor spEditor = mySharedPreferences.edit();
		spEditor.putString(key, value);
		spEditor.commit();
	}
	
	public String getDataFromSharedPrefs(String key) {
		
		String result = null;
		
		String spFilename = getString(R.string.sharedpreference_privatefile);
		
		//SharedPreferences myPreferences = this.getPreferences(Context.MODE_PRIVATE);
		SharedPreferences mySharedPreferences = this.mContext.getSharedPreferences(spFilename, Context.MODE_PRIVATE);
		
		result = mySharedPreferences.getString(key, "");
		
		return result;
	}
	
	public void deleteDataOnSharedPrefs(String key) {
		
		String spFilename = getString(R.string.sharedpreference_privatefile);
		
		SharedPreferences mySharedPreferences = this.mContext.getSharedPreferences(spFilename, Context.MODE_PRIVATE);
		
		Editor spEditor = mySharedPreferences.edit();
		
		spEditor.remove(key);
		spEditor.commit();
	}
	
	
	
	
	//--------------By File---------------
	public void writeFileToInternalStorage(String fileName, String content) {
		
		try {
			File file = new File(mContext.getFilesDir(), fileName);
			
			if(file.exists()) {
				
				return;
			}
			
			FileOutputStream outStream = new FileOutputStream(file);
			//outStream = openFileOutput(fileName, MODE_PRIVATE); 
			
			outStream.write(content.getBytes());
			outStream.close();
		
		}
		catch(FileNotFoundException ex) {
			
			throw new RuntimeException(ex);
		}
		catch(IOException ex) {
			
			throw new RuntimeException(ex);
		}
		catch(Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	
	public String readFileFromInternalStorage(String fileName) {
		
		String result = "";
		
		try {
			File file = new File(mContext.getFilesDir(), fileName);
			
			if(!file.isFile()) {
				
				return "FILE NOT AVAILABLE";
			}
			
			FileInputStream inStream = openFileInput(fileName); 
			inStream.read(result.getBytes());
			
			int content;
			while ((content = inStream.read()) != -1) {
				// convert to char and display it
				//System.out.print((char) content);
				result = result + (char) content;
				
			}
			
			Log.d(TAG, result);
			
			inStream.close();
		}
		catch(FileNotFoundException ex) {
			
			throw new RuntimeException(ex);
		}
		catch(IOException ex) {
			
			throw new RuntimeException(ex);
		}
		catch(Exception ex) {
			
			throw new RuntimeException(ex);
		}
		
		return result;
	}

	public void deleteInternalFile(String fileName){
	
		if(mContext.deleteFile(fileName)) {
			
			Log.d(TAG, "File deleted with success.");
		} else {
			
			Log.d(TAG, "File delete FAILURE.");
		}
	}
	// ----------------------PRIVATE METHODS---------------------
	

	// ----------------------GETTERS and SETTERS---------------------

}
