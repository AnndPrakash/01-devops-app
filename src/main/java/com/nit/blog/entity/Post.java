package com.nit.blog.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private String title;
	@Column(length = 10000)
	private String content;
	private String imageName;
	private Date addedDate;
	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@ManyToOne
	private User user;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
