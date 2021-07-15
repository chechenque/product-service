package com.IHI.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IHI.productservice.dto.Product;
import com.IHI.productservice.exceptionHandling.ApiException;
import com.IHI.productservice.service.ServiceProduct;

@RestController
@RequestMapping("/product")
public class ControllerProduct {

	@Autowired
	ServiceProduct serviceProduct;
	
	@GetMapping
	public ResponseEntity<Object> getProducts() throws Exception{
		try {
			return new ResponseEntity<>(serviceProduct.getProducts(),HttpStatus.OK);
		}catch(Exception e){
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Object> getProduct(@PathVariable("codigo") String codigo) throws Exception{
		try {
			return new ResponseEntity<>(serviceProduct.getProduct(codigo),HttpStatus.OK);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody Product producto) throws Exception{
		try {
			serviceProduct.createProduct(producto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		}
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Object> updateStockProduct(@PathVariable("codigo") String codigo, @RequestBody Product producto) throws Exception{
		try {
			serviceProduct.updateStockProduct(codigo, producto.getCantidad());
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e){
			if(e.getLocalizedMessage().equals("No pueden haber valores negativos en stock")) {
				throw new ApiException(HttpStatus.BAD_REQUEST,e.getLocalizedMessage());
			}else {
				throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
			}
		}
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("codigo") String codigo) throws Exception{
		try {
			serviceProduct.deleteProduct(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
