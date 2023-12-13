package com.nit.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
	private Integer categoryId;
	private String categoryTitle;
	private String categoryDiscription;
}
