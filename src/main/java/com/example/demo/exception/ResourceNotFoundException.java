package com.example.demo.exception;


// we are handling exception cause  sending ugly 500  insted of that  we are sending meassage with id
public class ResourceNotFoundException  extends RuntimeException{
	
	public  ResourceNotFoundException(String message ) {
		super(message);
	}

}
