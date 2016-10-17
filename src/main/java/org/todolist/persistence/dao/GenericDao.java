package org.todolist.persistence.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bapaydin on 16.10.2016.
 */
public abstract class GenericDao<E, K extends Serializable> {
    public abstract E add(E e);

    public abstract E update(E e);

    public abstract E delete(E e);

    public abstract E find(E e, K key);

    public abstract List<E> findAll();
}
