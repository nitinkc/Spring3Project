package com.fruit.soap.webservice;

public class MessageDetail {
	private String ecode;
	private String emessage;

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public String getEmessage() {
		return emessage;
	}

	public void setEmessage(String emessage) {
		this.emessage = emessage;
	}

	@Override
	public String toString() {
		return "MessageDetail [ecode=" + ecode + ", emessage=" + emessage + "]";
	}

}
