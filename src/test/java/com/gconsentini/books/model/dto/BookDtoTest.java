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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDtoTest {

    @MockBean
    private BooksCrawler booksCrawler;

    @Test
    public void testBookDto(){
        Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
        BookDto bookDto = new BookDto("TITULO", "DESCRICAO", "ISBN", "BR");
        Assert.assertEquals("TITULO", bookDto.getTitle());
        Assert.assertEquals("DESCRICAO", bookDto.getDescription());
        Assert.assertEquals("ISBN", bookDto.getIsbn());
        Assert.assertEquals("BR", bookDto.getLanguage());
    }

}