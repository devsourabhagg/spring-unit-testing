package org.example.business;

import org.example.service.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TodoBusinessImplMock {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredTodos.size());
    }
}
