package org.todolist.persistence.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.todolist.persistence.domain.Todo;
import org.todolist.persistence.domain.User;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapaydin on 18.10.2016.
 */
@Repository
public class TodoRepository extends GenericDaoRepository<Todo, Long> {

    private Logger LOG = LoggerFactory.getLogger(TodoRepository.class);

    public List<Todo> findTodosByUserId(User id) {
        Query query = null;
        List<Todo> allTodos = new ArrayList<>();
        try {
            query = entityManager.createQuery("select t from Todo t where t.user = :userId");
            query.setParameter("userId", id);
            allTodos = (List<Todo>) query.getResultList();
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        return allTodos;
    }
}


