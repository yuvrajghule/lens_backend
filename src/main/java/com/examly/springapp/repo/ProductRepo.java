package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, String>{

}
