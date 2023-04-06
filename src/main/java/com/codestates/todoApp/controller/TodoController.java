package com.codestates.todoApp.controller;

import com.codestates.todoApp.dto.TodoPatchDto;
import com.codestates.todoApp.dto.TodoPostDto;
import com.codestates.todoApp.entity.Todo;
import com.codestates.todoApp.mapper.TodoMapper;
import com.codestates.todoApp.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping()
@Validated
@Slf4j
public class TodoController {
    TodoService todoService;

    TodoMapper mapper;

    public TodoController(TodoService todoService, TodoMapper mapper) {
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto){
        Todo todo = todoService.createTodo(mapper.TodoPostDtoToTodo(todoPostDto));
        return new ResponseEntity<>(mapper.TodoToTodoResponseDto(todo),HttpStatus.OK);
    }
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive long todoId){
        Todo todo = todoService.findTodo(todoId);
        return new ResponseEntity<>(mapper.TodoToTodoResponseDto(todo),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos(){
        List<Todo> todo = todoService.findTodos();
        return new ResponseEntity<>(mapper.TodoToTodoResponseDtoList(todo),HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id")@Positive long todoId, @Valid @RequestBody TodoPatchDto todoPatchDto){
        Todo todo = todoService.updateTodo(mapper.TodoPatchDtoToTodo(todoPatchDto),todoId);
        return new ResponseEntity<>(mapper.TodoToTodoResponseDto(todo),HttpStatus.OK);
    }
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") @Positive long todoId){
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity deleteTodos(){
        todoService.deleteTodos();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
