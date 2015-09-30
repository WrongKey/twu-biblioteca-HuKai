package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleService {
    private BufferedReader bufferedReader;

    public ConsoleService() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public void displayBooks(List<Book> books) {
        System.out.println("\nAll books as follows:\n" +
        "\tisbn\t\t\t\t\t\ttitle\t\t\t\t\tauthor\t\t\t\t\tpublished year");
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public void displayMessage(String message) {
        System.out.print(message);
    }

    public String inputWithPrompt(String prompt) {
        displayMessage("\n" + prompt);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "-1";
    }
}
