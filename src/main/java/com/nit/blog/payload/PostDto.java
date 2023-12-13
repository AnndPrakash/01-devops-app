package com.nit.blog.payload;

import java.util.Date;

import com.nit.blog.entity.Category;
import com.nit.blog.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter

@Getter

public class PostDto {
 
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	
   private Category category;
   private User user;
   

}
