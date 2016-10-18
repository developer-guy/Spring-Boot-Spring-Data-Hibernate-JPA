package org.todolist.persistence.service;

import org.springframework.stereotype.Service;
import org.todolist.persistence.domain.Todo;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.repository.TodoRepository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapaydin on 18.10.2016.
 */
@Service
public class TodoService extends GenericDaoService<Todo,Long,TodoRepository>{
    public List<Todo> findTodosByUserId(User id) {
        return repository.findTodosByUserId(id);
    }
}
