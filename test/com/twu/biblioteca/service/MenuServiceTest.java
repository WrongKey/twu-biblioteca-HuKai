package com.twu.biblioteca.service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class MenuServiceTest {
    private OutputStream outputStream;
    private PrintStream ps;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        ps = new PrintStream(outputStream);
        System.setOut(ps);
    }

    @Test
    public void should_display_main_menu_at_least_contains_list_books() {
        MenuService menuService = new MenuService();
        menuService.displayMainMenu();

        assertTrue(outputStream.toString().contains("List Books"));
    }

    @Test
     public void should_display_main_menu_at_least_contains_quit() {
        MenuService menuService = new MenuService();
        menuService.displayMainMenu();

        assertTrue(outputStream.toString().contains("Quit"));
    }

    @Test
    public void should_display_main_menu_at_least_contains_check_out() {
        MenuService menuService = new MenuService();
        menuService.displayMainMenu();

        assertTrue(outputStream.toString().contains("Check Out"));
    }

    @Test
    public void should_display_main_menu_at_least_contains_return_book() {
        MenuService menuService = new MenuService();
        menuService.displayMainMenu();

        assertTrue(outputStream.toString().contains("Return Book"));
    }
}