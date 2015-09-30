package com.twu.biblioteca.service;

import com.twu.biblioteca.enumeration.Operation;

import java.util.HashMap;
import java.util.Map;

public class MenuService {
    private static final Map<Integer, Operation> supportedOperations = new HashMap<Integer, Operation>();

    static {
        initMenu();
    }

    private static void initMenu() {
        supportedOperations.put(1, Operation.LIST_BOOKS);
        supportedOperations.put(2, Operation.CHECK_OUT);
        supportedOperations.put(3, Operation.RETURN);
        supportedOperations.put(4, Operation.QUIT);
    }

    public void displayMainMenu() {
        System.out.println();
        for (Map.Entry<Integer, Operation> entry : supportedOperations.entrySet()) {
            System.out.print(entry.getKey() + ". " + entry.getValue().getDisplayMsg() + "\t");
        }
        System.out.println();
    }

    public Operation getOperationByOptionIndex(Integer index) {
        return supportedOperations.get(index);
    }
}