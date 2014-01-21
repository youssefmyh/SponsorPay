package com.sponsorpay.ui;

import android.app.Activity;
import android.os.Bundle;

/*
 * Base Activity 
 * */

public abstract class BaseActivity extends Activity  {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
     
		super.onCreate(savedInstanceState);

		// this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
	
	
}
