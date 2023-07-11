package com.examly.springapp.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class CartModel {
    // Entity fields, annotations, constructors, getters, and setters
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long cartItemID;
        
	    @Column(name = "productName")
	    private String productName;
	    
	    @Column(name = "userId")
	    private String userId;
	    
	    @Column(name = "price")
	    private String price;
	    
	    @Column(name = "quantity")
	    private String quantity;
	    
	    @Column(name = "imageUrl")
	    private String imageUrl;
}
