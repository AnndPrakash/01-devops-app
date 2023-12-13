package com.nit.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
