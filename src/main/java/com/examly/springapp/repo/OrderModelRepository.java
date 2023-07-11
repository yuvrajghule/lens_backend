package com.examly.springapp.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.examly.springapp.model.OrderModel;


@Repository
public interface OrderModelRepository extends JpaRepository<OrderModel,String> {
	 
	List<OrderModel> findByUserId(String userid);

}
