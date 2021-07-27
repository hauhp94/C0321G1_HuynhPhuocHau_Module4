package com.example.controller;

import com.example.exception.IdBookWrongException;
import com.example.exception.OutOfBookException;
import com.example.model.entity.Book;
import com.example.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = {"books", ""})
    public ModelAndView showBookList(@RequestParam("keyWord") Optional<String> keyWord, @PageableDefault(value = 3) Pageable pageable) {
        Page<Book> books;
        String key = "";
        if (keyWord.isPresent()) {
            books = bookService.findAllByNameContaining(keyWord.get(), pageable);
            key = keyWord.get();
        } else {
            books = bookService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("keyWord", key);
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/borrow-view/{id}")
    public ModelAndView detailInformationBook(@PathVariable Integer id) {
        Book book = bookService.findById(id);

        if (book == null) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("/borrow");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @GetMapping("/borrow-book/{id}")
    public ModelAndView borrowBook(@PathVariable Integer id) throws OutOfBookException {
        Book book = bookService.findById(id);
        if (book.getAmount() == 0) {
            throw new OutOfBookException();
        }
        book.setAmount(book.getAmount() - 1);
        bookService.save(book);
        if (book == null) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("/borrow");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "borrow ok");
        return modelAndView;
    }

    @PostMapping("/give-back-book")
    public ModelAndView giveBackBook(@RequestParam Integer id) throws IdBookWrongException {
        if(bookService.findById(id)==null){
            throw new IdBookWrongException();
        }
        Book book = bookService.findById(id);
        book.setAmount(book.getAmount() + 1);
        bookService.save(book);
        if (book == null) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("/borrow");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "give back ok");
        return modelAndView;
    }

    @ExceptionHandler(OutOfBookException.class)
    public String showInputNotAcceptable(Model model) {
        model.addAttribute("message","error out of books, please borrow other book");
        return "error";
    }
    @ExceptionHandler(IdBookWrongException.class)
    public String showIdBookWrong(Model model){
        model.addAttribute("message","id book wrong, please check again");
        return "error";
    }
}
