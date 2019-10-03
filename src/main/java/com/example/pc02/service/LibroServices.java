package com.example.pc02.service;

import com.example.pc02.model.Author;
import com.example.pc02.model.Book;
import com.example.pc02.model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LibroServices implements GenericService<Book, String> {
    List<Author> authors = new ArrayList<>(
            Arrays.asList(
                    new Author("72638945", "Marcelo", "Arias", "Cadena", 43, "Muy buen autor, nacio, crecio y murio"),
                    new Author("72638945", "Marcelo", "Arias", "Cadena", 43, "Muy buen autor, nacio, crecio y murio")
            )
    );

    List<Book> books = new ArrayList<>(
            Arrays.asList(
                    new Book("1", authors, "El libro bueno", "buen libro", LocalDate.of(2000, 11, 11), 504, "espanol")
            )
    );

    @Override
    public void create(Book book) {
        books.add(book);
    }

    @Override
    public void update(Book book) {
        Book currentProduct = findById(book.getIsbn());

        int index = books.indexOf(currentProduct);

        books.set(index, book);
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(String s) {
        Book currentBook = books.stream()
                .filter(c -> s.equalsIgnoreCase(c.getIsbn()))
                .findFirst()
                .orElse(null);

        return currentBook;    }
}