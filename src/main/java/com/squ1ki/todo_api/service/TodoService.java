package com.squ1ki.todo_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.squ1ki.todo_api.dto.TodoDTO;
import com.squ1ki.todo_api.entity.Todo;
import com.squ1ki.todo_api.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    public TodoDTO addTodo(TodoDTO todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class);

        todo = todoRepository.save(todo);

        return modelMapper.map(todo, TodoDTO.class);
    }

    public TodoDTO getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TODO not found."));

        return modelMapper.map(todo, TodoDTO.class);
    }

    public List<TodoDTO> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    // complete TODO
    // Update TODO List
}