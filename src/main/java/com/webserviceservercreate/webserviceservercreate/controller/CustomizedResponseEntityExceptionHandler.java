package com.webserviceservercreate.webserviceservercreate.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.webserviceservercreate.webserviceservercreate.exceptions.NotFoundException;
import com.webserviceservercreate.webserviceservercreate.model.ErroDetails;
import com.webserviceservercreate.webserviceservercreate.model.User;

@ControllerAdvice

public class CustomizedResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity handleNotFoundException()
	{
		ErroDetails ed = new ErroDetails(new Date(), "USer Record not found", "Details given");
		ResponseEntity<ErroDetails> re = new ResponseEntity<ErroDetails>(ed, HttpStatus.UNAUTHORIZED);
		return re;
	}
	
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//	@ExceptionHandler(NotFoundException.class)
//	public ModelAndView handleNotFoundException(Exception ex)
//	{
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
//		mv.addObject(ex);
//		ex.getMessage();
//		return mv;
//	}
	
}
