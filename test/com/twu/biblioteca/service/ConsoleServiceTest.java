package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsoleServiceTest {

    private OutputStream outputStream;
    private PrintStream ps;
    private ConsoleService consoleService;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        ps = new PrintStream(outputStream);
        System.setOut(ps);

        consoleService = new ConsoleService();
    }

    @Test
    public void should_show_welcome_message() throws Exception {
        consoleService.showWelcomeMessage();

        assertEquals(outputStream.toString(),"Welcome to Biblioteca!\n");
    }

    @Test
    public void should_display_list_of_all_library_books() throws Exception {
        List<Book> books = Arrays.asList(new Book("978-0201485677","Refactoring","Martin Fowler & Kent Beck","1999"),
                new Book("978-0132350884","Clean Code","Robert C. Martin","2008"));
        String expectedDisplay = "978-0201485677\t\tRefactoring\t\tMartin Fowler & Kent Beck\t\t1999\n"+
                "978-0132350884\t\tClean Code\t\tRobert C. Martin\t\t2008\n";

        consoleService.displayBooks(books);

        assertEquals(outputStream.toString(), expectedDisplay);
    }
}
