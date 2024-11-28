package com.pj.paying_guest_project.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pj.paying_guest_project.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	ResponseStructure<String> responseStructure = new ResponseStructure<String>();
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFoundException ex){
		responseStructure.setMessage("Id Not Found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFound(EmailNotFoundException ex){
		responseStructure.setMessage("Email Not Found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TypeNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> typeNotFound(TypeNotFoundException ex) {
		responseStructure.setMessage("Type not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AvailabilityNotFoundException.class) 
	public ResponseEntity<ResponseStructure<String>> availabilityNotFound(AvailabilityNotFoundException ex) {
		responseStructure.setMessage("Availability not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> locationNotFound(LocationNotFoundException ex){
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoPropertyFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noPropertyFound(NoPropertyFoundException ex){
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> constrainViolation(ConstraintViolationException ex){
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("This particular field cannot be null or blank");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> list=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for(ObjectError error:list) {
			String fieldName = ((FieldError)error).getField();
			String message = ((FieldError)error).getDefaultMessage();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
}
