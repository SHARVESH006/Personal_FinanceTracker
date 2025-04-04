package com.example.project.repository;

import com.example.project.entity.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByNameStartingWith(String name);
	
	List<Category> findByNameEndingWith(String name);

	List<Category>findByNameContains(String name);
	
	List<Category>findByNameIsContaining(String name);
	
	List<Category>findByNameNotContains(String name);
}
