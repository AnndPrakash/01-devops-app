package com.nit.blog.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException  {
	
	String resourceName;
	String filedName;
	long filedValue;
	public ResourceNotFoundException(String resourceName, String filedName, long filedValue) {
		super(String.format("%s not found with %s :%s",resourceName,filedName, filedValue));
		this.resourceName = resourceName;
		this.filedName = filedName;
		this.filedValue = filedValue;
	}
	

}
