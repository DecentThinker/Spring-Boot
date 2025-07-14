package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.request.BookTransactionRequest;
import com.example.DigitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    @RequestMapping("/book/issue")
    @PostMapping
    public boolean bookTransaction(@RequestBody BookTransactionRequest bookTransactionRequest){
        return transactionService.issueBook(bookTransactionRequest);
    }
}
