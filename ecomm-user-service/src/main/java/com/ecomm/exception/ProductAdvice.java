package com.ecomm.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.ecomm.model.UserResponse;

@ControllerAdvice
public class ProductAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EcommException.class)
    public
    @ResponseBody
    UserResponse ecommException(EcommException ex, WebRequest request, HttpServletResponse response) {

		UserResponse res = new UserResponse();
		res.setResponeStatus("Bad Request");
		res.setResponseCode("ERR_BAD");
		res.setResponseDesc(ex.getMessage());
		
        return res;
    }
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotException.class)
	public
    @ResponseBody
    UserResponse handleDataStoreException(ResourceNotException ex, WebRequest request, HttpServletResponse response) {

		UserResponse res = new UserResponse();
		res.setResponeStatus("Resource Not Found");
		res.setResponseCode("ERR_NOT_FOUND");
		res.setResponseDesc(ex.getMessage());
		
        return res;
    }
	
}