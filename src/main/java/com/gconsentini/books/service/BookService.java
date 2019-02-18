package com.gconsentini.books.service;

import com.gconsentini.books.model.dto.BookDto;
import com.gconsentini.books.model.dto.ListOfBooks;
import com.gconsentini.books.model.entity.BookEntity;
import com.gconsentini.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public boolean createBook(BookDto bookDto){
        if (bookDto != null) {
            BookEntity book = new BookEntity();
            book.setDescription(bookDto.getDescription());
            book.setIsbn(bookDto.getIsbn());
            book.setLanguage(bookDto.getLanguage());
            book.setTitle(bookDto.getTitle());
            bookRepository.save(book);
        }else return false;
        return true;
    }

    public BookDto retrieveBook(Long bookId) {
        BookDto bookDto = null;
        if (bookId != null) {
            Optional<BookEntity> book = bookRepository.findById(bookId);
            if (book.isPresent()){
                bookDto = new BookDto(book.get().getId(), book.get().getTitle(),
                        book.get().getDescription(), book.get().getIsbn(), book.get().getLanguage());
            }
        }
        return bookDto;
    }

    public ListOfBooks retrieveAllBooks(){
        List<BookEntity> bookEntityList = bookRepository.findAll();
        ListOfBooks listOfBooks = new ListOfBooks();
        listOfBooks.setNumberBooks(bookEntityList.size());
        listOfBooks.setBooks(bookEntityList);
        return listOfBooks;
    }

}
