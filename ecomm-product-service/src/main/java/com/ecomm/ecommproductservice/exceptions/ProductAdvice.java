	package com.ecomm.ecommproductservice.exceptions;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.ecomm.ecommproductservice.model.ResponseMessage;

@ControllerAdvice
public class ProductAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EcommException.class)
    public
    @ResponseBody
    ResponseMessage handleDataStoreException(EcommException ex, WebRequest request, HttpServletResponse response) {

		ResponseMessage rm = new ResponseMessage();
		rm.setResponeStatus("Error");
		rm.setResponseCode("Err.");
		rm.setResponseDesc(ex.getMessage());
		
        return rm;
    }
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotException.class)
	public
    @ResponseBody
    ResponseMessage handleDataStoreException(ResourceNotException ex, WebRequest request, HttpServletResponse response) {

		ResponseMessage rm = new ResponseMessage();
		rm.setResponeStatus("101");
		rm.setResponseCode("Err.");
		rm.setResponseDesc(ex.getMessage());
		
        return rm;
    }
	
}