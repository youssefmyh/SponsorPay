package com.sponsorpay.engine;

public class OfferRequest {
	
	private String appid;  //AppId 
	private String uid; //UID
	private String device_id; //Device Unique ID
	private String locale;  //Device Locale 
	private String ip;  //IP
	private String offer_types;  //offer Type =112
	private String hashkey;//HashKey LIB
	private String timestamp;//time stamp

	
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getHashkey() {
		return hashkey;
	}
	public void setHashkey(String hashkey) {
		this.hashkey = hashkey;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOffer_types() {
		return offer_types;
	}
	public void setOffer_types(String offer_types) {
		this.offer_types = offer_types;
	}
	
	
	
	
	
}
