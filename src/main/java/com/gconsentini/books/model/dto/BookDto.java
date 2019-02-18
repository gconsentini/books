package com.gconsentini.books.model.dto;


import lombok.Data;

@Data
public class BookDto {
    /*{
        "title": "Book title example",
            "description": "Book description example",
            "isbn": "9781617293290",
            "language": "BR"
    }*/

    private Long id;
    private String title;
    private String description;
    private String isbn;
    private String language;

    public BookDto(Long id, String title, String description, String isbn, String language){
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.language = language;
    }


}
