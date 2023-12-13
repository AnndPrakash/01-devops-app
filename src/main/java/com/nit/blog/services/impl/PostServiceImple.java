package com.nit.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.blog.entity.Category;
import com.nit.blog.entity.Post;
import com.nit.blog.entity.User;
import com.nit.blog.exception.ResourceNotFoundException;
import com.nit.blog.payload.PostDto;
import com.nit.blog.repository.CategoryRepository;
import com.nit.blog.repository.PostRepository;
import com.nit.blog.repository.UserRepository;
import com.nit.blog.services.PostService;

@Service
public class PostServiceImple implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("USer ","userId",userId));
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category ","categoryId",categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		Post newPost=this.postRepository.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsBycategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
