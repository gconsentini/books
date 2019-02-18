package com.gconsentini.books;

import com.gconsentini.books.crawler.BooksCrawler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksApplicationTests {

	@MockBean
	private BooksCrawler booksCrawler;

	@Test
	public void contextLoads() {
		BooksApplication.main(new String[] {});
		Mockito.doNothing().when(booksCrawler).collectBooks(Mockito.any());
	}

}
