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


    @Override
    public String getForUpdate(String s, Model model) {
        return null;
    }

    @Override
    public String update(String s, Author author, Model model) {
        return null;
    }

    @GetMapping("/autors/add")
    public String add(Model model) {
        model.addAttribute("autor", new Author());
        return "autor-add";
    }

    @GetMapping("/productos/delete/{dni}")
    public String delete(@PathVariable String autorid, Model model) {
        Author aBorrar = autorServices.findById(autorid);
        autorServices.delete(aBorrar);
        return getList(model);
    }
}
