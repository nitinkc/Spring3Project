package com.fruit.soap.webservice;

public class Welcome {

	private String mcode;
	private String message;

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Welcome [mcode=" + mcode + ", message=" + message + "]";
	}

}
