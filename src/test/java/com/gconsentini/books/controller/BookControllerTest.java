package com.gconsentini.books.controller;

import com.gconsentini.books.crawler.BooksCrawler;
import com.gconsentini.books.model.dto.BookDto;
import com.gconsentini.books.model.dto.ListOfBooks;
import com.gconsentini.books.model.entity.BookEntity;
import com.gconsentini.books.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BookControllerTest {

    @MockBean
    private BooksCrawler booksCrawler;

    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    @Test
    public void createNewBookTest(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        Mockito.when(bookService.createBook(Mockito.any())).thenReturn(true);
        Assert.assertNotNull(bookController.postBook(new BookDto("TITULO", "DESCRICAO", "ISBN", "BR")));
    }

    @Test
    public void getBookByIdTest() {
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        Mockito.when(bookService.retrieveBook(Mockito.any())).thenReturn(new BookEntity());
        Assert.assertNotNull(bookController.getBookById(1L));
    }

    @Test
    public void getAllBooksTest(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        Mockito.when(bookService.retrieveAllBooks()).thenReturn(new ListOfBooks());
        Assert.assertNotNull(bookController.getAllBooks());
    }


}