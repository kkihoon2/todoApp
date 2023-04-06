package com.codestates.todoApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 100, nullable = false,unique = true)
    private Long todoOrder;

    @Column(nullable = false)
    private Boolean completed;


}
