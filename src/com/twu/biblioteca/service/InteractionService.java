package com.twu.biblioteca.service;

import com.twu.biblioteca.enumeration.Operation;

public class InteractionService {
    private final MenuService menuService;
    private final ConsoleService consoleService;
    private final LibraryService libraryService;

    public InteractionService(MenuService menuService,
                              ConsoleService consoleService,
                              LibraryService libraryService) {
        this.menuService = menuService;
        this.consoleService = consoleService;
        this.libraryService = libraryService;
    }

    public String chooseOperation(Integer index) {
        Operation operation = menuService.getOperationByOptionIndex(index);
        if (operation == null) {
            return "Select a valid option!";
        }
        switch (operation) {
            case LIST_BOOKS:
                consoleService.displayBooks(libraryService.getAvailableBooks());
                return "\nAll books have been displayed.Please choose next step operation.";
            case CHECK_OUT:
                consoleService.displayBooks(libraryService.getAvailableBooks());
                return libraryService.checkOutBook(consoleService
                        .inputWithPrompt("\nAll available books have been displayed." +
                                "\nPlease enter ISBN which you wan to check out: "));
            case RETURN:
                return libraryService.returnBook(consoleService
                        .inputWithPrompt("Please enter ISBN which you wan to return: "));
            case QUIT:
                return "Bye.";
            default:
                throw new UnsupportedOperationException();
        }
    }
}
