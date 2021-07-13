package com.IHI.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IHI.productservice.dto.Category;
import com.IHI.productservice.repository.CategoryRepository;

@Service
public class ServiceCategoryImp implements ServiceCategory {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getCategorys() throws Exception{
		return categoryRepository.getCategorys();
	}

	@Override
	public Category getCategory(int id) throws Exception{
		try {
			return categoryRepository.getCategory(id);
		}catch(Exception e) {
			throw new Exception("La categoria no existe"); 
		}
	}

	@Override
	public void createCategory(Category category) throws Exception{
			categoryRepository.createCategory(category);
	}

	@Override
	public void updateCategory(Category category, int id) throws Exception{
		categoryRepository.updateCategory(category, id);
	}

	@Override
	public void deleteCategory(int id) throws Exception{
		categoryRepository.deleteRegion(id);
	}
}
