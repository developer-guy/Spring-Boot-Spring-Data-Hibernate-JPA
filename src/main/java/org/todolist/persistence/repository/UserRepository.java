package org.todolist.persistence.repository;

import org.springframework.stereotype.Repository;
import org.todolist.persistence.domain.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Repository
public class UserRepository extends GenericDaoRepository<User, Long> {

    public User findByEmail(String email) {
        Query query = null;
        try {
            query = entityManager.createQuery("select u from User u where u.email = :email");
            query.setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
