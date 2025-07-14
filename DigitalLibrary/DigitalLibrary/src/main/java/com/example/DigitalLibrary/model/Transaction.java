
package com.example.DigitalLibrary.model;

import com.example.DigitalLibrary.model.Book;
import com.example.DigitalLibrary.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    int id;
    Student student;
    Book book;
    double paidAmount;
    Timestamp createdOn;
    Timestamp updatedOn;
    TransactionType type;
}
