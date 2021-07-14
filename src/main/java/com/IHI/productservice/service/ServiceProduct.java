package com.IHI.productservice.service;

import java.util.List;

import com.IHI.productservice.dto.Product;

public interface ServiceProduct {

	public List<Product> getProducts() throws Exception;
	
	public Product getProduct(String codigo) throws Exception;
	
	public void createProduct(Product producto) throws Exception;
	
	public void updateStockProduct(String codigo, int cantidad) throws Exception;
	
	public void deleteProduct(String codigo) throws Exception;
}
