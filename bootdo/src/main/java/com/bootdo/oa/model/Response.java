package com.bootdo.oa.model;

public class Response {
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	private String responseMessage;

	public Response(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
