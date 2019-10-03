package com.example.pc02.controller;

import com.example.pc02.model.Author;
import com.example.pc02.service.AutorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AutorController implements GenericController<Author, String> {
    @Autowired
    AutorServices autorServices;

    @GetMapping("/autors")
    public String getList(Model model) {
        List<Author> autors = autorServices.findAll();
        model.addAttribute("autors", autors);
        return "autor";
    }

    @PostMapping("/autors/save")
    public String save(Author author, Model model) {
        autorServices.create(author);
        List<Author> autors = autorServices.findAll();
        model.addAttribute("autors", autors);
        return "autor";
    }


    @GetMapping("/autors/edit/{dni}")
    public String getForUpdate(@PathVariable String dni, Model model) {
        Author currentAuthor = autorServices.findById(dni);
        model.addAttribute("autor", currentAuthor);
        return "autor-edit";
    }

    @PostMapping("/autors/update/{dni}")
    public String update(@PathVariable String dni, Author author, Model model) {
        //Update
        autorServices.update(author);

        //list
        List<Author> autores = autorServices.findAll();
        model.addAttribute("autors", autores);
        return "autor";
    }

    @GetMapping("/autors/add")
    public String add(Model model) {
        model.addAttribute("autor", new Author());
        return "autor-add";
    }

    @GetMapping("/autors/delete/{dni}")
    public String delete(@PathVariable String dni, Model model) {
        Author aBorrar = autorServices.findById(dni);
        autorServices.delete(aBorrar);
        return getList(model);
    }
}
