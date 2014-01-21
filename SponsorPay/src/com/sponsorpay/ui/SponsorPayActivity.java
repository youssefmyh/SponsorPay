package com.sponsorpay.ui;

import android.os.Bundle;
import android.view.View;

import com.sponsorpay.controller.LoadingFinish;
import com.sponsorpay.controller.OffersCaller;
import com.sponsorpay.engine.OfferResponse;
import com.sponsorpay.engine.Utilites;
import com.sponsorpay.offer.R;

public class SponsorPayActivity extends BaseActivity implements LoadingFinish{

	EditFieldFragment uidField;  // UID Input Fragment 
	EditFieldFragment apiKeyField;  //API Key Input Fragment
	EditFieldFragment appIdField;	//APPID Input Fragment 
	EditFieldFragment puboField;    //PUB0 Input Fragment 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sponsor_pay);
		uidField=new EditFieldFragment(true, getString(R.string.uid));
		apiKeyField=new EditFieldFragment(true, getString(R.string.apikey));
		appIdField=new EditFieldFragment(true, getString(R.string.appid));
		puboField=new EditFieldFragment(true, getString(R.string.pub0));

		//Add Fragments
		android.app.FragmentTransaction transaction=getFragmentManager().beginTransaction();
		transaction.add(R.id.inputslayout, uidField);
		transaction.add(R.id.inputslayout, apiKeyField);
		transaction.add(R.id.inputslayout, appIdField);
		transaction.add(R.id.inputslayout, puboField);
		transaction.commit();

		
		
	}

	
	/*
	 * @param View view
	 * Brief called when click on submit to call Offer web service 
	 * */
	public void submitOfferRequest(View view)
	{
		if(uidField!=null&&apiKeyField!=null&&appIdField!=null&&puboField!=null)
		if(uidField.isValid()&&apiKeyField.isValid()&&appIdField.isValid()&&puboField.isValid())
		{
			submitOfferRequest(uidField.getValue(), apiKeyField.getValue(), appIdField.getValue(), puboField.getValue());
		}
		
	}
	
	/*
	 * @param String uidField
	 * @param  String apiKeyField
	 * @param String appIdField
	 * @param String puboField
	 * Brief perform call of web service  
	 * */

	public void submitOfferRequest(String uidField,String apiKeyField,String appIdField,String puboField)
	{
		LoadingAlert.showLoadingAlert(this);
		OffersCaller offerCaller=new OffersCaller(this,this);
		offerCaller.submitOfferRequest(uidField, apiKeyField, appIdField, puboField);

		
	}

	/*
	 * @param Object parsedObject 
	 * 
	 * Brief LoadingFinish fired when Response back and parsed from CommonWebServiceInvoker
	 * */

	@Override
	public void loadingFinish(Object parsedObject) {
		// TODO Auto-generated method stub
		LoadingAlert.removeLoadingAlert(this);
		if(parsedObject==null)
			return ;
		
			if(parsedObject instanceof OfferResponse)
			{
				OfferResponse offerRespone=(OfferResponse)parsedObject;
				if(offerRespone.getMessage()!=null)
				{
					Utilites.showToast(offerRespone.getMessage(), SponsorPayActivity.this);
					
				}
				
				
				
			}
			
		
	}

	/*
	 * @param Object parsedObject 
	 * 
	 * Brief LoadingFinish fired when Response back and parsed from CommonWebServiceInvoker
	 * */

	@Override
	public void loadingFail(Object parsedObject) {
		// TODO Auto-generated method stub
		LoadingAlert.removeLoadingAlert(this);
	}
	
	
}
