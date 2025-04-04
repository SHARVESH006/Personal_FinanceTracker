package com.example.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entity.emailentity;


public interface emailrepository extends JpaRepository<emailentity, Integer>{

}
