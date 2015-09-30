package com.twu.biblioteca.enumeration;

public enum Operation {
    LIST_BOOKS("List Books"), QUIT("Quit"),CHECK_OUT("Check Out"), RETURN("Return Book");

    private String displayMsg;

    Operation(String displayMsg) {
        this.displayMsg = displayMsg;
    }

    public String getDisplayMsg() {
        return displayMsg;
    }
}
