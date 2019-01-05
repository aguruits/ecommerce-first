package com.ecomm.exception;

public class EcommException extends RuntimeException {
	
	public EcommException() {
        super();
    }

    public EcommException(String message, Throwable cause) {
        super(message, cause);
    }

    public EcommException(String message) {
        super(message);
    }

    public EcommException(Throwable cause) {
        super(cause);
    }

}
