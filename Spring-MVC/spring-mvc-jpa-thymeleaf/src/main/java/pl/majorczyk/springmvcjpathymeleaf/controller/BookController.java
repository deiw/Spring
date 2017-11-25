package pl.majorczyk.springmvcjpathymeleaf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.majorczyk.springmvcjpathymeleaf.model.Book;
import pl.majorczyk.springmvcjpathymeleaf.repository.BookRepository;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class BookController  {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Model model, @ModelAttribute ArrayList<Book> bookList){
        if(book.getIsbn().length()!=13)
            model.addAttribute("message","Enter valid isbn number!");
        else {
            model.addAttribute("message",book+" added successfully!");
            try {
                bookRepository.save(book);
            }catch (DataIntegrityViolationException e){
                model.addAttribute("message","Book already in the database");
            }
            bookList= (ArrayList<Book>) bookRepository.findAll();
            model.addAttribute("bookList",bookList);
        }
        return "home";
    }


}

