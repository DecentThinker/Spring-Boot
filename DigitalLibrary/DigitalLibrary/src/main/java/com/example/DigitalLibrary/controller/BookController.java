package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.model.Book;
import com.example.DigitalLibrary.request.CreateBookRequest;
import com.example.DigitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    BookService bookservice;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest createBookRequest)
    {
        Book book = bookservice.createbook(createBookRequest);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
