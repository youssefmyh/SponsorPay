package com.sponsorpay.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.sponsorpay.ui.SponsorPayActivity;

@RunWith(RobolectricTestRunner.class)
public class CommonWebServiceInvoker_Test {

	CommonWebServiceInvoker commonService;
	SponsorPayActivity activity;

	@Test
	@Before
	public void setup() {
		commonService=new CommonWebServiceInvoker();
		activity=Robolectric.buildActivity(SponsorPayActivity.class).create().get();

	}
	
	
	@Test
	public void whenCallingCommonServiceInvoker()
	{
		OfferRequest offer=new OfferRequest();
		offer.setAppid("help");
		offer.setDevice_id("help");
		offer.setHashkey("help");
		offer.setLocale("help");
		offer.setIp("help");
		offer.setOffer_types("112");
		offer.setUid("112");

		
		commonService.doRequest(offer,new OfferResponse(), activity, ApplicationConstant.OFFER);
		
	}
	
	@Test
	public void whenCallingCommonServiceInvokerWithNullRequest()
	{
		commonService.doRequest(null,new OfferResponse(), activity, ApplicationConstant.OFFER);
		
	}

	@Test
	public void whenCallingCommonServiceInvokerWithNullResponse()
	{
		commonService.doRequest(new OfferRequest(), new OfferResponse(), activity, ApplicationConstant.OFFER);
		
	}
	
	
	
	@Test
	public void whenCallingCommonServiceInvokerWithNullLoadingFinish()
	{
		commonService.doRequest(new OfferRequest(), new OfferResponse(), null, ApplicationConstant.OFFER);
		
	}
	
	@Test
	public void whenCallingCommonServiceInvokerWithNullMethodName()
	{
		commonService.doRequest(new OfferRequest(), new OfferResponse(), null, null);
		
	}
	
}
