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


    @Override
    public String getForUpdate(String s, Model model) {
        return null;
    }

    @Override
    public String update(String s, Book Book, Model model) {
        return null;
    }

    @GetMapping("/libros/add")
    public String add(Model model) {
        model.addAttribute("libro", new Book());
        return "libro-add";
    }

    @GetMapping("/productos/delete/{id}")
    public String delete(@PathVariable String libroid, Model model) {
        Book aBorrar = libroServices.findById(libroid);
        libroServices.delete(aBorrar);
        List<Book> libros = libroServices.findAll();
        model.addAttribute("libros", libros);
        return "libros";
    }
}
