package com.twu.biblioteca.domain;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final String yearPublished;

    public Book(String isbn, String title, String author, String yearPublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t%s", isbn, title, author,yearPublished);
    }
}
