package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.UserModel;

public interface userRepo extends JpaRepository<UserModel, String> {

}
