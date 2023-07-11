package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.CartModel;

@Repository
public interface CartModelRepo extends JpaRepository<CartModel, Long> {
//	String deleteCartItems(String userId);
	
}