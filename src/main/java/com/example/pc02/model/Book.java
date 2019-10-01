package com.example.pc02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private String isbn;
    private List<Author> authors;
    private String title;
    private String summary;
    private LocalDate publicationDate;
    private int numberOfPages;
    private String languages;
}
