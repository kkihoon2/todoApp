package com.codestates.todoApp.dto;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class TodoPostDto {
    @NotBlank
    private String title;
    @Positive
    private long todo_order;
    @NotNull
    private Boolean completed;
}
