package com.examly.springapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.OrderItems;
import com.examly.springapp.model.OrderModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.repo.OrderModelRepository;

@CrossOrigin("*")
@RestController
public class OrderController { 
    @Autowired
	public OrderModelRepository orderModelRepository;


@GetMapping("/orders")
	public List<OrderModel> getUserProducts(@RequestParam("userId") String userId) {
      List<OrderModel> orders=orderModelRepository.findByUserId(userId);
       return orders; 
   }

@GetMapping("/admin/orders")
public List<OrderModel> getProducts() {
  List<OrderModel> orders=orderModelRepository.findAll();
   return orders;
}

@PostMapping("/saveOrder")
 public String placeOrder(@RequestBody OrderModel order)
 {
	double tPrice=0.0;
	for(OrderItems orderItems: order.getOrderItems()) {
		tPrice+=Double.valueOf(orderItems.getPrice());
	}
	order.setTotalPrice(String.valueOf(tPrice));
	OrderModel savedOrder = orderModelRepository.save(order); // Save the order to generate orderId

    if (order.getOrderItems() != null) {
        for (OrderItems orderItem : order.getOrderItems()) {
            orderItem.setOrder(savedOrder); // Set the saved order as the reference in each order item
        }
    }
    orderModelRepository.save(savedOrder);

    return "cart items sent to orders" ;
}

@PostMapping("/placeOrder")
public String placeOrderDirect(@RequestBody OrderModel order)
{
	double tPrice=0.0;
	for(OrderItems orderItems: order.getOrderItems()) {
		tPrice+=Double.valueOf(orderItems.getPrice());
	}
	
	order.setTotalPrice(String.valueOf(tPrice));
	OrderModel savedOrder = orderModelRepository.save(order); // Save the order to generate orderId

   if (order.getOrderItems() != null) {
       for (OrderItems orderItem : order.getOrderItems()) {
           orderItem.setOrder(savedOrder); // Set the saved order as the reference in each order item
       }
   }
   orderModelRepository.save(savedOrder);

   return "cart items sent to orders" ;
}
}
	 