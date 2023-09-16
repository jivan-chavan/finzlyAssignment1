package com.finzly.fxtradingwithdatabase.exception;


	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;

	@ControllerAdvice
	public class FxTradingExceptionHandler {

	    @ExceptionHandler(FxTradingException.class)
	    public ResponseEntity<Object> handleNotFoundException(FxTradingException ex) {

	        FxTradingErrorResponse errorResponse = new FxTradingErrorResponse(
	            HttpStatus.NOT_FOUND.value(),
	            ex.getMessage(),
	            System.currentTimeMillis()
	        );
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }


	}
