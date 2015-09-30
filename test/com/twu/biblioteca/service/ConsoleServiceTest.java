package com.twu.biblioteca.service;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
}
