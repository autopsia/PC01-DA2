package com.example.pc02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private String dni;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private int age;
    private String biography;
}
