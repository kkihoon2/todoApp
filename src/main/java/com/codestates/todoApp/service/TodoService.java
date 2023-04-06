package com.codestates.todoApp.service;

import com.codestates.todoApp.entity.Todo;
import com.codestates.todoApp.mapper.TodoMapper;
import com.codestates.todoApp.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo){
        todoRepository.save(todo);
        return todo;
    }
    public Todo updateTodo(Todo todo,long todoId){
        Todo findTodo = findVerifiedTodo(todoId);

        Optional.ofNullable(todo.getTitle())
                .ifPresent(title->findTodo.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder())
                .ifPresent(todo_order->findTodo.setTodoOrder(todo_order));
        Optional.ofNullable(todo.getCompleted())
                .ifPresent(completed->findTodo.setCompleted(completed));
        return todoRepository.save(findTodo);
    }

    public Todo findTodo(long todoId){
        return findVerifiedTodo(todoId);
    }

    public List<Todo> findTodos(){

        List<Todo>todos = todoRepository.findAll(Sort.by("todoOrder").ascending());

        return todos;
    }
    public void deleteTodo(long todoId){
        Todo findTodo = findVerifiedTodo(todoId);
        todoRepository.delete(findTodo);
    }

    public void deleteTodos(){
        todoRepository.deleteAll();
    }


    public Todo findVerifiedTodo(long todoId){
        Optional<Todo>optionalTodo=todoRepository.findById(todoId);
        Todo findTodo = optionalTodo.orElseThrow(()->new RuntimeException("Todo못찾음"));
        return findTodo;
    }
}
