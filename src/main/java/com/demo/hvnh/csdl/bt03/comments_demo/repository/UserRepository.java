package com.demo.hvnh.csdl.bt03.comments_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hvnh.csdl.bt03.comments_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}