package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private static final Map<String, Book> ALL_BOOKS = new HashMap<String, Book>();
    private static final List<String> CHECKED_OUT_BOOKS = new ArrayList<String>();

    static {
        ALL_BOOKS.put("978-0201485677", new Book("978-0201485677", "Refactoring", "Martin Fowler & Kent Beck", "1999"));
        ALL_BOOKS.put("978-0132350884", new Book("978-0132350884", "Clean Code", "Robert C. Martin", "2008"));
        ALL_BOOKS.put("078-5342616224", new Book("078-5342616224", "The Pragmatic Programmer", "Andrew Hunt & David Thoma", "1999"));
        ALL_BOOKS.put("978-0321146533", new Book("978-0321146533", "Test Driven Development", "Kent Beck", "2002"));
        ALL_BOOKS.put("079-0145196705", new Book("079-0145196705", "Code Complete", "Steve McConnell", "2004"));
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<Book>();
        for (Book book : ALL_BOOKS.values()) {
            allBooks.add(book);
        }
        return allBooks;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<Book>();


        for (String isbn : ALL_BOOKS.keySet()) {
            if (!CHECKED_OUT_BOOKS.contains(isbn)) {
                availableBooks.add(ALL_BOOKS.get(isbn));
            }
        }

        return availableBooks;
    }

    public String checkOutBook(String isbn) {
        if (isBookAvailable(isbn)) {
            CHECKED_OUT_BOOKS.add(isbn);
            return "Thank you! Enjoy the book.\n";
        }
        return "That book is not available.\n";
    }

    public String returnBook(String isbn) {
        if(isBookCheckedOut(isbn)) {
            CHECKED_OUT_BOOKS.remove(isbn);
            return "Thank you for returning the book.\n";
        }
        return "That is not a valid book to return.\n";
    }

    protected boolean isBookAvailable(String isbn) {
        return ALL_BOOKS.containsKey(isbn) && !CHECKED_OUT_BOOKS.contains(isbn);
    }

    protected boolean isBookCheckedOut(String isbn) {
        return ALL_BOOKS.containsKey(isbn) && CHECKED_OUT_BOOKS.contains(isbn);
    }
}
