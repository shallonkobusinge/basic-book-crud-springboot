package com.basic.crud.service;

import com.basic.crud.model.Books;
import com.basic.crud.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BooksService {
    @Autowired
    BooksRepository booksRepository;
    public List<Books> getAllBooks()
    {
//        List<Books> books = new ArrayList<Books>();
//        booksRepository.findAll().forEach(books1 -> books.add(books1));
//        return books;
        return booksRepository.findAll();
    }
    public Books getBooksById(Integer id)
    {
        return booksRepository.findById(id).get();
    }
    public void saveOrUpdate(Books books)
    {
        booksRepository.save(books);
    }
    public void delete(Integer id)
    {
        booksRepository.deleteById( id);
    }
    //updating a record
//    public void update(Books books, Long bookid)
//    {
//        booksRepository.save(books);
//    }

}
