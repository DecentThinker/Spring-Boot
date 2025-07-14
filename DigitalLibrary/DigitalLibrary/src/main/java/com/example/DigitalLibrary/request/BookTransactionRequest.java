package com.example.DigitalLibrary.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookTransactionRequest
{
    int studentId;
    int bookId;
    String amount;
    String requestType;
}
