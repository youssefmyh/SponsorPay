package com.sponsorpay.controller;

import android.content.Context;
import com.sponsorpay.engine.ApplicationConstant;
import com.sponsorpay.engine.CommonWebServiceInvoker;
import com.sponsorpay.engine.OfferRequest;
import com.sponsorpay.engine.OfferResponse;
import com.sponsorpay.engine.Utilites;

public class OffersCaller {

	LoadingFinish loadingFinish;
	Context context;

	public OffersCaller(Context context, LoadingFinish loading) {
		this.loadingFinish = loading;
		this.context = context;
	}
/*
 * @param uidField User ID Field
 * @param  apiKeyField Hashed LIB Key 
 * @param  appIdField Application ID  
 * 
 * */
	public void submitOfferRequest(String uidField, String apiKeyField,
			String appIdField, String puboField) {
		OfferRequest offerRequest = new OfferRequest();
		offerRequest.setAppid(appIdField);
		offerRequest.setUid(uidField);
		offerRequest.setHashkey(apiKeyField);
		offerRequest.setOffer_types(ApplicationConstant.OFFER_TYPE);
		offerRequest.setTimestamp(""+System.currentTimeMillis());

		//offerRequest.setDevice_id(Utilites.getUDID(context));
		offerRequest.setIp(Utilites.getLocalIpAddress());
		offerRequest.setLocale(Utilites.getCurrentDeviceLocale());

		CommonWebServiceInvoker invoker = new CommonWebServiceInvoker();
		OfferResponse offerResponse = new OfferResponse();

		invoker.doRequest(offerRequest, offerResponse, loadingFinish,
				ApplicationConstant.OFFER);

	}

}
