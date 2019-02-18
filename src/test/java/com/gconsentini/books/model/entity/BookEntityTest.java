package com.gconsentini.books.model.entity;

import com.gconsentini.books.crawler.BooksCrawler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookEntityTest {

    @MockBean
    private BooksCrawler booksCrawler;

    @Test
    public void testBookEntity(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1L);
        bookEntity.setIsbn("ISBN");
        bookEntity.setLanguage("BR");
        bookEntity.setTitle("TITULO");
        bookEntity.setDescription("DESCRICAO");
        Assert.assertEquals(new Long(1L), bookEntity.getId());
        Assert.assertEquals("BR", bookEntity.getLanguage());
        Assert.assertEquals("TITULO", bookEntity.getTitle());
        Assert.assertEquals("DESCRICAO", bookEntity.getDescription());
        Assert.assertEquals("ISBN", bookEntity.getIsbn());
    }
}