package com.example.DigitalLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Author
{
   private int id;
   private String name;
   private String email;
   private String phoneNo;
   private List<Book> bookList;

}
