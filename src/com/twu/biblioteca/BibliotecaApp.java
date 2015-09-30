package com.twu.biblioteca;

import com.twu.biblioteca.service.ConsoleService;
import com.twu.biblioteca.service.InteractionService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MenuService;

public class BibliotecaApp {
    public static final String QUIT_FLAG = "Bye.";
    private static final ConsoleService consoleService;
    private static final LibraryService libraryService;
    private static final MenuService menuService;
    private static final InteractionService interactionService;

    static {
        consoleService = new ConsoleService();
        libraryService = new LibraryService();
        menuService = new MenuService();
        interactionService = new InteractionService(menuService, consoleService, libraryService);
    }

    public static void main(String[] args) {
        lunchApplication();
    }

    private static void lunchApplication() {
        consoleService.showWelcomeMessage();
        consoleService.displayBooks(libraryService.getAllBooks());

        String message = "";
        while (!message.equals(QUIT_FLAG)) {
            menuService.displayMainMenu();
            message = interactionService.chooseOperation(Integer
                    .valueOf(consoleService.inputWithPrompt("Please choose a number:")));
            consoleService.displayMessage(message);
        }

    }
}
