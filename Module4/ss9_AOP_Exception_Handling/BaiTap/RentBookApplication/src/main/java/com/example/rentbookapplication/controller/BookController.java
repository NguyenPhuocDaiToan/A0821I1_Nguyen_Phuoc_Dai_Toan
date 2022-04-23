package com.example.rentbookapplication.controller;

import com.example.rentbookapplication.Exception.GiveBookBackException;
import com.example.rentbookapplication.Exception.RentBookException;
import com.example.rentbookapplication.model.Book;
import com.example.rentbookapplication.service.BookService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController {
    private Map<Integer,Book> bookMap=new HashMap<>();
    @Autowired
    private BookService bookService;

    @GetMapping()
    public ModelAndView getViewList() {
        System.out.println(bookService.getAll().size());
        return new ModelAndView("list", "books", bookService.getAll());
    }

    @GetMapping("/rentBook/{id}")
    public ModelAndView viewRentBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        Random rand = new Random();
        int random = rand.nextInt(99999- 10000) + 10000;
        if(book == null) {
            return new ModelAndView("errorRentBook");
        }
        ModelAndView modelAndView= new ModelAndView("rentBook","book",book);
        modelAndView.addObject("random",random);
        return modelAndView;
    }

    @PostMapping("/rentBook/{random}")
    public ModelAndView rentBook(@ModelAttribute Book book, @PathVariable int random) throws RentBookException {
        if(bookService.rentBook(book)) {
            bookMap.put(random, book);
            return new ModelAndView("list","books",bookService. getAll());
        }
        throw new RentBookException();
    }

    @GetMapping("/giveBookBack")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("giveBookBack","random", new Integer("0"));
    }

    @PostMapping("/giveBookBack")
    public ModelAndView giveBookBack(@RequestParam int random) throws GiveBookBackException {
        System.out.println(random);
        if(bookMap.containsKey(random)) {
            Book book= bookMap.get(random);
            bookService.giveBookBack(book);
            bookMap.remove(random);
            return new ModelAndView("list","books",bookService.getAll());
        }
        throw new GiveBookBackException();
    }

    @ExceptionHandler(RentBookException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("errorRentBook");
    }

    @ExceptionHandler(GiveBookBackException.class)
    public ModelAndView showErrorGiveBookBack() {
        return new ModelAndView("errorGiveBookBack");
    }
}
