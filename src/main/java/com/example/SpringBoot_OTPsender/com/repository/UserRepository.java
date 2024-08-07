package com.example.SpringBoot_OTPsender.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBoot_OTPsender.com.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
