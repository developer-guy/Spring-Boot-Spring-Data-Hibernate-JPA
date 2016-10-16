package org.todolist.persistence.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Repository
public interface GenericDao<E,K extends Serializable> {
    public E add(E e);
    public E update(E e);
    public E delete(E e);
    public E find(E e,K key);
    public List<E> findAll();
}
