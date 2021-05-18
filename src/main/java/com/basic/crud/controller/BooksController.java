package com.basic.crud.controller;

import com.basic.crud.model.Books;
import com.basic.crud.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    //autowire book service class
    @Autowired
BooksService booksService;

    @GetMapping("")
    private String mainEntry(){return "Hello There";}

    //getting all books
    @GetMapping("/all")
    private List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }
    @GetMapping("/{bookid}")
    public ResponseEntity<Books> get(@PathVariable Integer bookid){
        try{
            Books book = booksService.getBooksById(bookid);
            return  new ResponseEntity<Books>(book,HttpStatus.OK);
        }catch (NoSuchElementException e){return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);}
    }
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") Integer bookid)
    {
        booksService.delete(bookid);
    }
    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books.getBookId();
    }

    @PutMapping("/book/{bookId}")
    private ResponseEntity<?> updateBook(@RequestBody Books books,@PathVariable Integer bookId){
      try{
          Books existing = booksService.getBooksById(bookId);
          existing.setAuthor(books.getAuthor());
          existing.setBookName(books.getBookName());
          existing.setPrice(books.getPrice());
          booksService.saveOrUpdate(existing);
          return new ResponseEntity<>(HttpStatus.OK);
      }catch (NoSuchElementException e){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }
}
