package com.gconsentini.books.service;

import com.gconsentini.books.crawler.BooksCrawler;
import com.gconsentini.books.model.dto.BookDto;
import com.gconsentini.books.model.entity.BookEntity;
import com.gconsentini.books.repository.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @MockBean
    private BooksCrawler booksCrawler;

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void createNewBookTest(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        BookDto bookDto = new BookDto("TITULO", "DESCRICAO", "ISBN", "BR");
        Mockito.when(bookRepository.save(Mockito.notNull())).thenReturn(new BookEntity());
        Assert.assertTrue(bookService.createBook(bookDto));
        Assert.assertFalse(bookService.createBook(null));
    }
    @Test
    public void getBookByIdTest(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        Mockito.when(bookRepository.findById(Mockito.any())).thenReturn(java.util.Optional.of(new BookEntity()));
        Assert.assertNotNull(bookService.retrieveBook(1L));
        Assert.assertNull(bookService.retrieveBook(null));
    }

    @Test
    public void getAllBooksTest(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        Mockito.when(bookRepository.findAll()).thenReturn(Collections.emptyList());
        Assert.assertNotNull(bookService.retrieveAllBooks());
    }
}