package com.IHI.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IHI.productservice.exceptionHandling.ApiException;

@RestController
public class ControllerPrueba {

	@GetMapping
	public ResponseEntity<Object> prueba(){
		try {
			int i = 1/0;
			return new ResponseEntity<>(i,HttpStatus.OK);
		}catch(Exception e){
			throw new ApiException(HttpStatus.BAD_REQUEST,"La division entre cero no es valida!");
		}
		
	}
}
