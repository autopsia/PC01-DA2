package com.example.pc02.controller;

import com.example.pc02.model.Book;
import com.example.pc02.model.Book;
import com.example.pc02.service.LibroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibroController implements GenericController<Book, String> {
    @Autowired
    LibroServices libroServices;

    @GetMapping("/libros")
    public String getList(Model model) {
        List<Book> libros = libroServices.findAll();
        model.addAttribute("libros", libros);
        return "libro";
    }

    @PostMapping("/libros/save")
    public String save(Book Book, Model model) {
        libroServices.create(Book);
        List<Book> libros = libroServices.findAll();
        model.addAttribute("libros", libros);
        return "libro";
    }


    @GetMapping("/libros/edit/{isbn}")
    public String getForUpdate(@PathVariable String isbn, Model model) {
            Book currentLibro = libroServices.findById(isbn);
            model.addAttribute("libro", currentLibro);
            return "libro-edit";

    }

    @PostMapping("/autors/update/{isbn}")
    public String update(@PathVariable String isbn, Book book, Model model) {
        //Update
        libroServices.update(book);

        //list
        List<Book> books = libroServices.findAll();
        model.addAttribute("libros", books);
        return "libro";
    }

    @GetMapping("/libros/add")
    public String add(Model model) {
        model.addAttribute("libro", new Book());
        return "libro-add";
    }

    @GetMapping("/libros/delete/{isbn}")
    public String delete(@PathVariable String isbn, Model model) {
        Book aBorrar = libroServices.findById(isbn);
        libroServices.delete(aBorrar);
        return getList(model);
    }
}
