package com.tianhongguoji.test.config.exception;

import lombok.Getter;

@Getter
public final class CustomException extends RuntimeException {

	private int errorCode;
	private String message;

	public CustomException(int errorCode,String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
}
