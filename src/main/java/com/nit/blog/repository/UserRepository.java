package com.nit.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
