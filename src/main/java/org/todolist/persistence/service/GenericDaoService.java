package org.todolist.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.todolist.persistence.dao.GenericDao;
import org.todolist.persistence.repository.GenericDaoRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bapaydin on 16.10.2016.
 */

public abstract class GenericDaoService<E, K extends Serializable, D extends GenericDaoRepository<E,K>> {

    @Autowired
    public D repository;

    @Transactional
    public E add(E e) {
        return repository.add(e);
    }

    @Transactional
    public E update(E e) {
        return repository.update(e);
    }

    @Transactional
    public E delete(E e) {
        return repository.delete(e);
    }

    @Transactional
    public E find(E e, K key) {
        return repository.find(e, key);
    }

    @Transactional
    public List<E> findAll() {
        return repository.findAll();
    }

    public D getRepository() {
        return repository;
    }

    public void setRepository(D repository) {
        this.repository = repository;
    }
}
