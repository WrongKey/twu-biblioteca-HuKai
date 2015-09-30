package com.twu.biblioteca.service;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class LibraryServiceTest {
    private LibraryService libraryService;

    @Before
    public void setUp() throws Exception {
        libraryService = new LibraryService();
    }

    @Test
    public void should_prompt_successful_message_when_check_out() throws Exception {
        String isbn = "978-0201485677";
        String promptMessage = libraryService.checkOutBook(isbn);

        assertEquals("Thank you! Enjoy the book.\n", promptMessage);
    }

    @Test
    public void should_prompt_failed_message_when_check_out_failed() throws Exception {
        String isbn = "078-5342616224";
        String successMessage = libraryService.checkOutBook(isbn);
        assertEquals("Thank you! Enjoy the book.\n", successMessage);

        String failedMessage = libraryService.checkOutBook(isbn);
        assertEquals("That book is not available.\n", failedMessage);
    }

    @Test
    public void should_not_appear_in_the_list_of_books_when_book_has_been_checked_out() {
        String isbn = "978-0132350884";
        libraryService.checkOutBook(isbn);

        assertFalse(libraryService.isBookAvailable(isbn));
        assertTrue(libraryService.isBookCheckedOut(isbn));
    }

    @Test
    public void should_appear_in_the_list_of_books_when_book_has_been_returned() {
        String isbn = "978-0321146533";
        String message = libraryService.checkOutBook(isbn);
        assertEquals("Thank you! Enjoy the book.\n", message);

        message = libraryService.returnBook(isbn);
        assertEquals("Thank you for returning the book.\n", message);

        assertTrue(libraryService.isBookAvailable(isbn));
    }

    @Test
    public void should_prompt_failed_message_when_book_not_exist() {
        String isbn = "1111111111111";

        String message = libraryService.returnBook(isbn);
        assertEquals("That is not a valid book to return.\n", message);
    }

    @Test
    public void should_prompt_failed_message_when_book_have_not_been_checked_out() {
        String isbn = "079-0145196705";

        String message = libraryService.returnBook(isbn);
        assertEquals("That is not a valid book to return.\n", message);
    }
}