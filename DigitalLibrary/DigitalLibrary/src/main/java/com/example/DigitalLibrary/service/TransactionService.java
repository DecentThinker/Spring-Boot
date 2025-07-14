package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.repository.TransactionDao;
import com.example.DigitalLibrary.request.BookTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionDao transactionDAO;

    public boolean issueBook(BookTransactionRequest bookTransactionRequest){
        int row= transactionDAO.issueBookToStudent(bookTransactionRequest);
        if (row>0){
            return true;
        }
        return false;
    }
}
