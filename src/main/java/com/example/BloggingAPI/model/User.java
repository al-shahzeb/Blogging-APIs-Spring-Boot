package com.example.BloggingAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

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

    public User(int userId, String userName, String email, String password, String about) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.about = about;
    }
}
