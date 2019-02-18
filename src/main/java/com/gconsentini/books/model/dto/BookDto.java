package com.gconsentini.books.model.dto;


import lombok.Data;

@Data
public class BookDto {

    private String title;
    private String description;
    private String isbn;
    private String language;

    public BookDto(String title, String description, String isbn, String language){
        this.setTitle(title);
        this.setDescription(description);
        this.setIsbn(isbn);
        this.setLanguage(language);
    }


}
