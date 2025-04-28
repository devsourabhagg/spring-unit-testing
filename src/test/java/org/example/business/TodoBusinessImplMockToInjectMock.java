package org.example.business;

import org.example.service.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


public class TodoBusinessImplMockToInjectMock {


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    TodoService todoServiceMock;
    //TodoService todoServiceMock = mock(TodoService.class);

    @InjectMocks
    TodoBusinessImpl todoBusiness;
    //TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD(){
        //Given
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //when
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        //then
        assertThat(filteredTodos.size(),is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD(){
        //Given
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //then
        verify(todoServiceMock,times(1)).deleteTodo("Learn to Dance");
        //or
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        verify(todoServiceMock,atLeastOnce()).deleteTodo("Learn to Dance");
        verify(todoServiceMock,atLeast(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        //verify this method is never called for "Learn Spring"
        verify(todoServiceMock,never()).deleteTodo("Learn Spring");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptor(){

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //Given
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(),is("Learn to Dance"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_multipleTimes(){

        //Given
        List<String> todos = Arrays.asList("Learn MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
    }
}
