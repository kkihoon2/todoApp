package com.codestates.todoApp.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class TodoResponseDto {
    private long todoId;
    private String title;
    private long todo_order;
    private Boolean completed;
}
