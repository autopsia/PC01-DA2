package com.example.pc02.service;

import com.example.pc02.model.Book;
import com.example.pc02.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LibroServices implements GenericService<Book, String> {
    List<Book> autors = new ArrayList<>(
            Arrays.asList(


            )
    );

    @Override
    public void create(Book o) {
        autors.add(o);
    }

    @Override
    public void update(Book o) {
        Book currentProduct = findById(o.getIsbn());

        int index = autors.indexOf(currentProduct);

        autors.set(index, o);
    }

    @Override
    public void delete(Book o) {
        autors.remove(o);
    }

    @Override
    public List<Book> findAll() {
        return autors;
    }

    @Override
    public Book findById(String s) {
        Book currentCliente = autors.stream()
                .filter(c -> s.equalsIgnoreCase(c.getIsbn()))
                .findFirst()
                .orElse(null);

        return currentCliente;
    }
}