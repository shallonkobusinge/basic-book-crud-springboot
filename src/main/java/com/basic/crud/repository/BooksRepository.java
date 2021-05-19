package com.basic.crud.repository;

import com.basic.crud.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {

//    @Query(value = "Select author from books author where ")
}
