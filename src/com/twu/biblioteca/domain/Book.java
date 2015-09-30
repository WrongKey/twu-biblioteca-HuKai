package com.twu.biblioteca.domain;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t%s\t\t%s", isbn, title, author);
    }
}
