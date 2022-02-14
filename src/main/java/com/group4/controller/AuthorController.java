package com.group4.controller;

import com.group4.model.Author;
import com.group4.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAuthor(Model model) {
        model.addAttribute("listAuthor", this.authorService.listAuthor());
        return "list-authors";

    }

    @GetMapping(value = "/add")
    public String create(Model model) {
        model.addAttribute("author", new Author());
        return "create-author";
    }

    @PostMapping(value = "/add")
    public String create(@Validated @ModelAttribute("author") Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "create-author";
        }
        authorService.addAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/remove/{id}")
    public RedirectView removeBook(@PathVariable("id") int id) {
        this.authorService.removeAuthor(id);
        return new RedirectView("/authors");
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
//        Author author = authorService.getAuthorById(id);
//        model.addAttribute("author",author);
        model.addAttribute("author", authorService.getAuthorById(id));
        return "update-author";
    }
}
