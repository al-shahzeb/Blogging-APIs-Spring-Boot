package com.example.BloggingAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @Column(name="title")
    @NotEmpty
    private String categoryTitle;

    @Column(name="description")
    @NotEmpty
    private String categoryDesc;
}
