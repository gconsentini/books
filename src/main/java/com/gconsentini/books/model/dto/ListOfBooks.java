package com.gconsentini.books.model.dto;

import com.gconsentini.books.model.entity.BookEntity;
import lombok.Data;

import java.util.List;

@Data
public class ListOfBooks {
    private int numberBooks;
    private List<BookEntity> books;
}
