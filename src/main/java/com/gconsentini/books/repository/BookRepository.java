package com.gconsentini.books.repository;

import com.gconsentini.books.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
