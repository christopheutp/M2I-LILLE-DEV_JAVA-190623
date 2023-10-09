package com.crni99.CovidData.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler(value = { NoDataException.class })
	public ResponseEntity<String> handleEmptyInputException(NoDataException noDataException) {

		return new ResponseEntity<String>(noDataException.getMessage(), HttpStatus.NOT_FOUND);
	}

}
