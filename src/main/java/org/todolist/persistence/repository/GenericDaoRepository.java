package org.todolist.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.todolist.persistence.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by bapaydin on 16.10.2016.
 */
public abstract class GenericDaoRepository<E, K extends Serializable> extends GenericDao<E,K>{

    @PersistenceContext
    public EntityManager entityManager;

    private Class<E> entityClass;

    public GenericDaoRepository() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Transactional
    public E add(E e) {
        entityManager.persist(e);
        return e;
    }

    @Transactional
    public E update(E e) {
        return entityManager.merge(e);
    }

    @Transactional
    public E delete(E e) {
        if (entityManager.contains(e)) {
            entityManager.remove(e);
        } else {
            e = update(e);
            entityManager.remove(e);
        }
        return e;
    }

    @Transactional
    public E find(E e, K key) {
        return entityManager.find(entityClass, key);
    }

    @Transactional
    public List<E> findAll() {
        return entityManager.createQuery("from " + entityClass).getResultList();
    }
}
