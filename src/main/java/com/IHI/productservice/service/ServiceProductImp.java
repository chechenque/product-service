package com.IHI.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IHI.productservice.dto.Product;
import com.IHI.productservice.repository.ProductRepository;

@Service
public class ServiceProductImp implements ServiceProduct {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() throws Exception {
		return productRepository.getProducts();
	}

	@Override
	public Product getProduct(String codigo) throws Exception {
		try {
			return productRepository.getProduct(codigo);
		}catch(Exception e) {
			throw new Exception("El producto no existe");
		}
	}

	@Override
	public void createProduct(Product producto) throws Exception {
		productRepository.createProduct(producto);
		
	}

	@Override
	public void updateStockProduct(String codigo, int cantidad) throws Exception {
		productRepository.updateStockProduct(codigo, cantidad);
	}

	@Override
	public void deleteProduct(String codigo) throws Exception {
		try {
			productRepository.deleteProduct(codigo);
		}catch(Exception e) {
			throw new Exception("El producto no existe");
		}
		
	}



}
