package com.model;

import javax.xml.bind.annotation.XmlRootElement;

//Used to define the components of response sent to server
@XmlRootElement
public class Response {

	public Response(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;

	}
	public Response() {	
	}
	private boolean status;
	private String message;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
