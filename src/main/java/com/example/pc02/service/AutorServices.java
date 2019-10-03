package com.example.pc02.service;

import com.example.pc02.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AutorServices implements GenericService<Author, String> {
    List<Author> autors = new ArrayList<>(
            Arrays.asList(
                    new Author("0000001","Ciro","Alegría","Bazán",57, "Es uno de los máximos representantes de la narrativa indigenista, marcada por la creciente conciencia sobre el problema de la opresión indígena y por el afán de dar a conocer esta situación, cuyas obras representativas son las llamadas “novelas de la tierra”."),
                    new Author("0000002","Alfredo","Bryce ","Echenique ",80 , "Es un escritor peruano, célebre por novelas como Un mundo para Julius, La vida exagerada de Martín Romaña o No me esperen en abril.")

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
