package com.twu.biblioteca.service;

import com.twu.biblioteca.enumeration.Operation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InteractionServiceTest {
    @Test
    public void should_return_prompt_message_when_user_choose_an_invalid_option() {
        InteractionService interactionService = new InteractionService(new MockMenuService(),
                new MockConsoleService(), new MockLibraryService());
        String message = interactionService.chooseOperation(1);

        String expected = "Select a valid option!";
        assertEquals(expected, message);
    }

    private class MockMenuService extends MenuService {
        @Override
        public Operation getOperationByOptionIndex(Integer index) {
            return null;
        }
    }

    private class MockConsoleService extends ConsoleService {

    }

    private class MockLibraryService extends LibraryService {

    }
}
