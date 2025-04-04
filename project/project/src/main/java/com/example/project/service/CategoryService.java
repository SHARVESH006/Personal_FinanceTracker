package com.example.project.service;

import com.example.project.entity.Category;
import com.example.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    
    public Category updateid(Long id, Category categoryDetails) {
        if (categoryRepository.existsById(id)) {
            Category obj = categoryRepository.findById(id).get();
            obj.setId(id);
            obj.setName(categoryDetails.getName());
            return categoryRepository.save(obj);
        }
        return null;
    }
    
    public List<Category> start(String name) {
    	return categoryRepository.findByNameStartingWith(name);
    	
    }

    public List<Category> end(String name) {
    	return categoryRepository.findByNameEndingWith(name);
    }

    public List<Category> namecontain(String name) {
    	return categoryRepository.findByNameContains(name);
    }

    public List<Category> iscontain(String name) {
    	return categoryRepository.findByNameIsContaining(name);
    }

    public List<Category> notcontains(String name) {
    	return categoryRepository.findByNameNotContains(name);
    }
}
