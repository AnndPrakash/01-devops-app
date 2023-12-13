package com.nit.blog.payload;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;
	@Nonnull
	@NotEmpty
	@Size(min=4,message="UserName must be minimum 4 character")
	private String name;
	@Email(message="Your email id is not Valid")
	private String email;
	@Nonnull
	@NotEmpty
	@Size(min=4,max=10,message="Password must be minimum of 3 char and maximum of 10 charecter")
	@Pattern(regexp = "[a-z0-9A-Z]")
	private String pasword;
	@Nonnull
	@NotEmpty
	private String about;

}
