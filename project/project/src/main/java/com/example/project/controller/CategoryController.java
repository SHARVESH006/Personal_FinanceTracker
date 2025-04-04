package com.example.project.controller;

import com.example.project.entity.Category;
import com.example.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/poste")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
    
    @PutMapping("/updatee/{id}")
    public Category updatebyid(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryService.updateid(id, categoryDetails);
    }
    
    @GetMapping("/start")
	public List<Category> startingwith(@RequestParam String name) {
		return categoryService.start(name);
		
	}
	
	@GetMapping("/end")
	public List<Category> endingwith(@RequestParam String name) {
		return categoryService.end(name);
	}
	
	@GetMapping("/contains")
	public List<Category> namecontains(@RequestParam String name) {
		return categoryService.namecontain(name);
	}
	
	@GetMapping("/iscontains")
	public List<Category> iscontains(@RequestParam String name) {
		return categoryService.iscontain(name);
	}
	
	@GetMapping("/notcontains")
	public List<Category> notcontains(@RequestParam String name) {
		return categoryService.notcontains(name);
	}
	
    
    

}
