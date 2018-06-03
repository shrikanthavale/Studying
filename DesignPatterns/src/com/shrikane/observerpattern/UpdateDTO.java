package com.shrikane.observerpattern;

public class UpdateDTO {
	
	private String message;

	public UpdateDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
