package com.movingaverage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidInput extends Exception {

	private static final long serialVersionUID = 277244128554678767L;
	
	public InvalidInput(String message) {
		super(message);	
	}

}
