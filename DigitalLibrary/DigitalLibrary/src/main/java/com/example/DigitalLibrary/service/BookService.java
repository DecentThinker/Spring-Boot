package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.exception.BookAlreadyPresent;
import com.example.DigitalLibrary.model.Author;
import com.example.DigitalLibrary.model.Book;
import com.example.DigitalLibrary.repository.AuthorDao;
import com.example.DigitalLibrary.repository.BookDao;
import com.example.DigitalLibrary.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService
{
    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public Book createbook(CreateBookRequest createBookRequest)
    {
        String bookId = createBookRequest.getBookId();
        String bookName = createBookRequest.getBookName();
        String bookType = createBookRequest.getBookType().toString();
        String authorEmail = createBookRequest.getAuthorEmail();

        Book bookResult = null;
        try
        {
            int status = bookDao.findBookById(bookId);
            if(status>0)
            {
                throw new BookAlreadyPresent("Book is already present in the database");
            }
            int result = bookDao.createBookInDatabase(bookId, bookName, bookType, authorEmail);
            if(result<=0)
            {
                return null;
            }

            boolean isAuthorExist = false;

            try{
                Author authorExist = authorDao.findAuthorById(authorEmail);
                isAuthorExist = true;
            }
            catch (Exception e) {
                isAuthorExist = false;
            }

            if(isAuthorExist==true)
                return bookResult;

            authorDao.createAuthor(CreateBookRequest.toAuthor(createBookRequest));
        }
        catch (BookAlreadyPresent e) {
            throw new RuntimeException(e);
        }

        return bookResult;
    }
}
