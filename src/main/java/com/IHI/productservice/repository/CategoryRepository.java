package com.IHI.productservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.IHI.productservice.dto.Category;

@Repository
public class CategoryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Category> getCategorys() throws Exception{
		try {
			return jdbcTemplate.query("SELECT * FROM category;", new BeanPropertyRowMapper<Category>(Category.class));
		}catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		
	}
	
	public Category getCategory(int id) throws Exception{
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM category WHERE id="+id+";", new BeanPropertyRowMapper<Category>(Category.class));
		}catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public void createCategory(Category category) throws Exception{
		try {
			jdbcTemplate.update("{CALL st_create_category(?)}",category.getCategoria());
		}catch(UncategorizedSQLException e) {
			throw new Exception(e.getSQLException().getMessage());
		}
	}
	
	public void updateCategory(Category category, int id) throws Exception{
		try {
			jdbcTemplate.update("{CALL st_update_category(?,?)}",category.getCategoria(),id);
		}catch(UncategorizedSQLException  e) {
			throw new Exception(e.getSQLException().getMessage());
		}
	}
	
	public void deleteRegion(int id) throws Exception{
		try {
			jdbcTemplate.update("DELETE FROM category WHERE id="+id+";");
			System.out.println("PASS");
		}catch(Exception e) {
			System.out.println("Execpcion");
			throw new Exception(e.getLocalizedMessage());
		}
		
	}
}
