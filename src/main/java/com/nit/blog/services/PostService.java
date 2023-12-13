package com.nit.blog.services;

import java.util.List;

import com.nit.blog.entity.Post;
import com.nit.blog.payload.PostDto;

public interface PostService {
	
	// create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	// update 
	Post updatePost(PostDto postDto,Integer postId);
	//delete post
	void deletePost(Integer postId);
	// get 
	List<Post>getAll();
	// get single post
	
	Post getPostById(Integer postId);
	
	// get all post by category
	
	List<Post>getPostsBycategory(Integer categoryId);
	
	// get post by user
	
	List<Post>getPostsByUser(Integer userId);
	// search post
	List<Post>searchPosts(String keyword);

}
