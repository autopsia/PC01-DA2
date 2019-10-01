package com.example.pc02.service;

import com.example.pc02.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AutorServices implements GenericService<Author, String> {
    List<Author> autors = new ArrayList<>(
            Arrays.asList(
                    new Author("","","","",12, ""),
                    new Author("","","","",12, ""),
                    new Author("","","","",12, ""),
                    new Author("","","","",12, ""),
                    new Author("","","","",12, ""),
                    new Author("","","","",12, ""),
                    new Author("","","","",12, ""),
                    new Author("","","","",12, "")

            )
    );

    @Override
    public void create(Author o) {
        autors.add(o);
    }

    @Override
    public void update(Author o) {
        Author currentProduct = findById(o.getDni());

        int index = autors.indexOf(currentProduct);

        autors.set(index, o);
    }

    @Override
    public void delete(Author o) {
        autors.remove(o);
    }

    @Override
    public List<Author> findAll() {
        return autors;
    }

    @Override
    public Author findById(String s) {
        Author currentCliente = autors.stream()
                .filter(c -> s.equalsIgnoreCase(c.getDni()))
                .findFirst()
                .orElse(null);

        return currentCliente;
    }
}
