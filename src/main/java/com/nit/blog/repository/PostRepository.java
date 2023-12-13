package com.nit.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.blog.entity.Category;
import com.nit.blog.entity.Post;
import com.nit.blog.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
