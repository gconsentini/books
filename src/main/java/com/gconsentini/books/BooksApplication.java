package com.gconsentini.books;

import com.gconsentini.books.crawler.BooksCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BooksApplication {

	@Autowired
	private BooksCrawler booksCrawler;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void fillDataFromWebSite() {
		booksCrawler.collectBooks("https://kotlinlang.org/docs/books.html");
	}
}

