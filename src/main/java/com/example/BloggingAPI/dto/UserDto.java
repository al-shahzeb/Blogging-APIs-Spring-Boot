package com.example.BloggingAPI.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty
    @Size(min = 5,message = "UserName must be more than 4 characters.")
    private String userName;
    @Email(message = "Enter valid email.")
    private String email;
    @NotEmpty
    @Size(min = 5,max = 8,message = "Password must be between 5 to 8 characters")
    private String password;
    @NotEmpty
    private String about;

}
