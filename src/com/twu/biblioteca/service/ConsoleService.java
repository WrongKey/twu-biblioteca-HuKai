package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;

import java.util.List;

public class ConsoleService {
    public void showWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public void displayBooks(List<Book> books) {
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public void displayMenu() {
        System.out.println("1. List Books");
    }
}
