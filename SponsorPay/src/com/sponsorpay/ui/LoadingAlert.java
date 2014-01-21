package com.sponsorpay.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.sponsorpay.offer.R;

public class LoadingAlert {

	public static Dialog logindialog; // static Dialog to show and hide it 


	/*
	 * @param BaseActivity baseActivity 
	 * 
	 * Brief showing loading alert
	 * */
	public static void showLoadingAlert( BaseActivity baseActivity) {

						// TODO Auto-generated method stub
				if (logindialog == null) {
					logindialog = new Dialog(baseActivity,
							android.R.style.Theme_Translucent_NoTitleBar);
					logindialog.setContentView(R.layout.loadingfragment);
					Window window = logindialog.getWindow();
					window.setBackgroundDrawable(new ColorDrawable(
							android.graphics.Color.TRANSPARENT));
					window.setLayout(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);
					window.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

					logindialog.setCancelable(true);

					logindialog.show();
				} else {
					if (!logindialog.isShowing())
						logindialog.show();
				}
		
	}
	/*
	 * @param BaseActivity baseActivity 
	 * 
	 * Brief removing loading alert
	 * */

	public static void removeLoadingAlert(BaseActivity baseActivity) {


			if (logindialog != null && logindialog.isShowing()) {
				logindialog.dismiss();
				logindialog = null;
			}

	}

	
}
