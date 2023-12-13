package com.nit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.blog.entity.Category;
import com.nit.blog.exception.ResourceNotFoundException;
import com.nit.blog.payload.CategoryDto;
import com.nit.blog.repository.CategoryRepository;
import com.nit.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.mapper.map(categoryDto, Category.class);
		Category addedCat=this.categoryRepository.save(cat);
		
		return this.mapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ", "CategoryId", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDiscription(categoryDto.getCategoryDiscription());
		Category updateCat=this.categoryRepository.save(cat);
		return this.mapper.map(updateCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
	    this.categoryRepository.delete(cat);	
		
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		return this.mapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category>categories=this.categoryRepository.findAll();
		List<CategoryDto>categoryDtos=categories.stream().map((cat)->this.mapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return categoryDtos;
		
	}
	}