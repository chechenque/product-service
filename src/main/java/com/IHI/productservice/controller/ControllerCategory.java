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

import com.IHI.productservice.dto.Category;
import com.IHI.productservice.exceptionHandling.ApiException;
import com.IHI.productservice.service.ServiceCategory;

@RestController 
@RequestMapping("/category")
public class ControllerCategory {

  @Autowired
  ServiceCategory serviceCategory;
  
  @GetMapping
  public ResponseEntity<Object> getCategorys() throws Exception{
    try {
      return new ResponseEntity<>(serviceCategory.getCategorys(),HttpStatus.OK);
    }catch(Exception e) {
      throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
    }
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Object> getCategory(@PathVariable("id") int id) throws Exception{
    try {
      return new ResponseEntity<>(serviceCategory.getCategory(id), HttpStatus.OK);
    }catch(Exception e){
      throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
    }
    
  }
  
  @PostMapping
  public ResponseEntity<Object> createCategory(@RequestBody Category category) throws Exception{
    try {
      serviceCategory.createCategory(category);
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(Exception e) {
      throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
    }
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateCategory(@RequestBody Category category, @PathVariable("id") int id) throws Exception{
    try {
      serviceCategory.updateCategory(category, id);
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(Exception e) {
      System.out.println(e.getLocalizedMessage());
      if(e.getLocalizedMessage().equals("La categoria No existe")) {
        throw new ApiException(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
      }else {
        throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
      }
    }
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCategory(@PathVariable("id") int id) throws Exception{
    try {
      serviceCategory.deleteCategory(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(Exception e) {
      throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }
  }
}