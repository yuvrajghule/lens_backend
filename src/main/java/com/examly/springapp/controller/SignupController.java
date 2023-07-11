package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.LoginModel;
import com.examly.springapp.model.UserModel;
import com.examly.springapp.repo.userRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class SignupController {
	@Autowired
	userRepo repo;
	@PostMapping("/signup")
	public boolean saveUser(@RequestBody UserModel user)
	{
		repo.save(user);
		if (user.getUserName() != null) {
	        return true;
	    } else {
	    	return false;
	    }
	}
	
	@CrossOrigin("*")
	@GetMapping("/getuser/{email}")
	public UserModel getuser(@PathVariable String email)
	{	
		UserModel user=repo.findById(email).orElse(null);
		return user;
	}

}
