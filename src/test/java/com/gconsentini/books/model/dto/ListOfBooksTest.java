package com.gconsentini.books.model.dto;

import com.gconsentini.books.crawler.BooksCrawler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListOfBooksTest {

    @MockBean
    private BooksCrawler booksCrawler;

    @Test
    public void testListOfBooks(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        ListOfBooks listOfBooks = new ListOfBooks();
        listOfBooks.setBooks(Collections.emptyList());
        listOfBooks.setNumberBooks(0);
        Assert.assertEquals(0, listOfBooks.getNumberBooks());
        Assert.assertNotNull(listOfBooks.getBooks());
    }
}