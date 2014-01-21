package com.sponsorpay.engine;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.apache.http.conn.util.InetAddressUtils;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.Toast;

public class Utilites {


/*
 * @param Android.content.Context
 * Brief return the Unique identifier of Device
 * */
	
public static final String getUDID(Context context)
{
	String udid= Settings.Secure.getString(context.getContentResolver(),
			Settings.Secure.ANDROID_ID);
	return udid;
}
 

/*
 * @param Object offerRequestObject //Request object need to be parsed
 * Brief return the string request based on parameters inside the Class
 * */


public static String getOfferGETRequest(Object offerRequestObject) 
{
	try{
	StringBuilder requestBuilder=new StringBuilder();
	if(offerRequestObject==null)
		throw new NullPointerException();
	Class<? extends Object> requestClass=offerRequestObject.getClass();
	  Field[] valueObjFields = requestClass.getDeclaredFields();

	  // compare values now
	  for (int i = 0; i< valueObjFields.length; i++)
	  {
	     String fieldName = valueObjFields[i].getName();
	     valueObjFields[i].setAccessible(true);
	     Object newObj = valueObjFields[i].get(offerRequestObject);
	     
	     if(fieldName!=null&&newObj!=null)
	     {
	    	 requestBuilder.append(fieldName+"="+newObj.toString());
	    	 if(i!=valueObjFields.length-1)
	    	 {
	    		 requestBuilder.append("&");
	    	 }
	     }
	     
	  }
	
	  return requestBuilder.toString();
	}catch(Exception ee)
	{
		ee.printStackTrace();
		return null;
	}
}


/*
 * 
 * Brief return Local Device IP
 * */
public static String getLocalIpAddress() {
	try {
		for (Enumeration<NetworkInterface> en = NetworkInterface
				.getNetworkInterfaces(); en.hasMoreElements();) {
			NetworkInterface intf = en.nextElement();
			for (Enumeration<InetAddress> enumIpAddr = intf
					.getInetAddresses(); enumIpAddr.hasMoreElements();) {
				InetAddress inetAddress = enumIpAddr.nextElement();
				if (!inetAddress.isLoopbackAddress()
						&& InetAddressUtils.isIPv4Address(inetAddress
								.getHostAddress())) {
					String ip = inetAddress.getHostAddress().toString();
					return ip;
				}
			}
		}
	} catch (SocketException ex) {
		ex.printStackTrace();
	}
	return "127.0.0.1";
}



/*
 * Breif return current device Locale
 * */
public static String getCurrentDeviceLocale()
{
	//return Locale.getDefault().getISO3Language();
	return "DE"; //return DE for Test
}


public static void showToast(final String text, final Activity context) {
	context.runOnUiThread(new Runnable() {

		public void run() {
			// TODO Auto-generated method stub
			Toast toast = Toast.makeText(context, text, 60000);
			toast.setDuration(120000);
			toast.setGravity(Gravity.CENTER_VERTICAL
					| Gravity.CENTER_HORIZONTAL, 0, 0);
			toast.show();

		}
	});
}
}
