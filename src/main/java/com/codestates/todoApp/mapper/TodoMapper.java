package com.codestates.todoApp.mapper;

import com.codestates.todoApp.dto.TodoPatchDto;
import com.codestates.todoApp.dto.TodoPostDto;
import com.codestates.todoApp.dto.TodoResponseDto;
import com.codestates.todoApp.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    @Mapping(source = "todo_order",target = "todoOrder")
    Todo TodoPostDtoToTodo(TodoPostDto todoPostDto);
    @Mapping(source = "todo_order",target = "todoOrder")
    Todo TodoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    @Mapping(source = "todoOrder",target = "todo_order")
    TodoResponseDto TodoToTodoResponseDto(Todo todo);
    @Mapping(source = "todoOrder",target = "todo_order")
    List<TodoResponseDto>TodoToTodoResponseDtoList(List<Todo>todo);
}
