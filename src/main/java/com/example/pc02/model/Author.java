package com.example.pc02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Scope("session")
@Component
@Data
public class Author {
    private String dni;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private int age;
    private String biography;
}
