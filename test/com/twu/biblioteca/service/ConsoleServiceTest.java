package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsoleServiceTest {

    @Test
    public void should_show_welcome_message() throws Exception {
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);

        ConsoleService consoleService = new ConsoleService();
        consoleService.showWelcomeMessage();

        assertEquals(outputStream.toString(),"Welcome to Biblioteca!\n");
    }

    @Test
    public void should_display_list_of_all_library_books() throws Exception {
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);

        List<Book> books = Arrays.asList(new Book("978-0201485677","Refactoring","Martin Fowler & Kent Beck"),
                new Book("978-0132350884","Clean Code","Robert C. Martin"));
        ConsoleService consoleService = new ConsoleService();
        consoleService.displayBooks(books);

        String expectedDisplay = "978-0201485677\t\tRefactoring\t\tMartin Fowler & Kent Beck\n"+
                "978-0132350884\t\tClean Code\t\tRobert C. Martin\n";
        assertEquals(outputStream.toString(), expectedDisplay);
    }
}
