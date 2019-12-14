package com.fruit.rest.exception;

public class FruitErrorMessage {

	private String code;
	private String message;
	private String description;
	private String url;

	public FruitErrorMessage(String code, String message, String description,
			String url) {
		this.code = code;
		this.message = message;
		this.description = description;
		this.url = url;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FruitErrorMessage [code=" + code + ", message=" + message
				+ ", description=" + description + ", url=" + url + "]";
	}

}
