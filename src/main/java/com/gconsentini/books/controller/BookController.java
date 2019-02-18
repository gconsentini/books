package com.gconsentini.books.controller;

import com.gconsentini.books.model.dto.BookDto;
import com.gconsentini.books.model.dto.ListOfBooks;
import com.gconsentini.books.model.entity.BookEntity;
import com.gconsentini.books.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Cria um novo livro na base")
    @PostMapping("/book")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 403, message = "Forbidden")
    })
    public ResponseEntity postBook(@RequestBody BookDto bookDto){
        boolean isCreated = bookService.createBook(bookDto);
        if (!isCreated)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "retorna um livro por id", response = BookEntity.class)
    @GetMapping("/books/{bookId}")
    @ApiResponse(code = 200, message = "Success", response = BookEntity.class)
    public BookDto getBookById(@PathVariable Long bookId){
        return bookService.retrieveBook(bookId);
    }

    @ApiOperation(value = "retorna um livro por id", response = ListOfBooks.class)
    @GetMapping("/books")
    @ApiResponse(code = 200, message = "Success", response = ListOfBooks.class)
    public ListOfBooks getAllBooks() {
        return bookService.retrieveAllBooks();
    }

}
