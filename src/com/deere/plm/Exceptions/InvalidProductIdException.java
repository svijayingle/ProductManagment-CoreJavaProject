package com.deere.plm.Exceptions;

public class InvalidProductIdException extends Exception {
	String msg;
	
	public InvalidProductIdException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
}
