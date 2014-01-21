
package com.sponsorpay.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import com.sponsorpay.offer.R;

@RunWith(RobolectricTestRunner.class)
public class SponsorPayActivity_Test {

	SponsorPayActivity activity;
	@Test
	@Before
	public void setup()
	{
		activity=Robolectric.buildActivity(SponsorPayActivity.class).create().get();
		String applicationName=activity.getResources().getString(R.string.app_name);
		assert(applicationName.equalsIgnoreCase("SponsorPay"));
		
	}

	@Test
	public void whenClickonSubmitButtonWithNullValues()
	{
		activity.submitOfferRequest(null);
		
	}

	@Test
	public void whenCallingSubmitOfferRequestWithNullValues()
	{
		activity.submitOfferRequest(null, null, null, null);
		
	}
	
	//String uidField,String apiKeyField,String appIdField,String puboField
	@Test
	public void whenCallingSubmitOfferRequestWithUidFieldISNull()
	{
		activity.submitOfferRequest(null, "12132131321", "2070", "welcome");
		
	}

	
	@Test
	public void whenCallingSubmitOfferRequestWithApiKeyFieldISNull()
	{
		activity.submitOfferRequest("spiderman",null, "2070", "welcome");
		
	}
	
	
	@Test
	public void whenCallingSubmitOfferRequestWithAppIdFieldISNull()
	{
		activity.submitOfferRequest("spiderman", "12132131321", null, "welcome");
		
	}
	
	@Test
	public void whenCallingSubmitOfferRequestWithpuboISNull()
	{
		activity.submitOfferRequest("spiderman", "12132131321", "2070", null);
		
	}
}
