package com.sponsorpay.engine;

public class OfferResponse extends BaseResponse {

	String code;  //Error Code
	String message; //Error Message
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
