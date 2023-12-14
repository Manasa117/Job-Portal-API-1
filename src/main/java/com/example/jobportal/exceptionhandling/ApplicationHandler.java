package com.example.jobportal.exceptionhandling;

import java.util.HashMap;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.jobportal.utility.ErrorStructure;


@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request){
		List<ObjectError> list = ex.getAllErrors();
		HashMap<String, String> hashmap = new HashMap<>();
		for (ObjectError error : list)
		{
			FieldError fielderror = (FieldError) error;
			String fieldname = fielderror.getField();
			String message = error.getDefaultMessage();
			hashmap.put(fieldname, message);
		}
		return new ResponseEntity<Object> (hashmap, HttpStatus.BAD_REQUEST);
	}


	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<com.example.jobportal.utility.ErrorStructure<String>> UserNotFoundById(UserNotFoundException cnf)
	{     ErrorStructure<String> es = new ErrorStructure<String>();
	               es.setStatusCode(HttpStatus.NOT_FOUND.value());
	               es.setMessage(cnf.getMess()); // message what we threw in service 
	               es.setErrordata(" USER WITH GIVEN ID NOT PRESENT ");
	               
	               return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);

	}
	

}