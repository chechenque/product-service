package com.IHI.productservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.IHI.productservice.dto.Product;

@Repository
public class ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Product> getProducts() throws Exception{
		try {
			return jdbcTemplate.query("SELECT * FROM product;", new BeanPropertyRowMapper<Product>(Product.class));
		}catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public Product getProduct(String codigo) throws Exception{
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM product WHERE codigo = " + codigo + ";", new BeanPropertyRowMapper<Product>(Product.class));
		}catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public void createProduct(Product product) throws Exception{
		try {
			jdbcTemplate.update("{CALL st_create_product(?,?,?,?,?,?)}",
					product.getCodigo(),
					product.getProducto(),
					product.getDescripcion(),
					product.getPrecio(),
					product.getCantidad(),
					product.getIdCategoria());
		}catch(UncategorizedSQLException e) {
			throw new Exception(e.getSQLException().getLocalizedMessage());
		}
	}
	
	public void updateStockProduct(String codigo, int cantidad) throws Exception{
		try {
			jdbcTemplate.update("{CALL st_update_stock(?,?)}",codigo,cantidad);
		}catch(UncategorizedSQLException e) {
			throw new Exception(e.getSQLException().getLocalizedMessage());
		}
	}
	
	public void deleteProduct(String codigo) throws Exception{
		try {
			jdbcTemplate.update("DELETE FROM product WHERE codigo = "+codigo+";");
		}catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
