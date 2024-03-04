package com.somoim.app.payment;

public class ClientDTO {
	
	private String keyName;
	private String keyID;
	
	
	@Override
	public String toString() {
		return "ClientDTO [keyName=" + keyName + ", keyID=" + keyID + "]";
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getKeyID() {
		return keyID;
	}
	public void setKeyID(String keyID) {
		this.keyID = keyID;
	}
	
	
	
}
