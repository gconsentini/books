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

    private String title;
    private String description;
    private String isbn;
    private String language;

    public BookDto(String title, String description, String isbn, String language){
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.language = language;
    }


}
