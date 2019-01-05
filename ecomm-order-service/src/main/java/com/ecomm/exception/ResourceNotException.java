package com.ecomm.exception;

public class ResourceNotException extends RuntimeException {
	
	public ResourceNotException() {
        super();
    }

    public ResourceNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotException(String message) {
        super(message);
    }

    public ResourceNotException(Throwable cause) {
        super(cause);
    }

}
