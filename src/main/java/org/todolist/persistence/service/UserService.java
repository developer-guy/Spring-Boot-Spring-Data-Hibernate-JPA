package org.todolist.persistence.service;

import org.springframework.stereotype.Service;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.repository.UserRepository;

import javax.persistence.Query;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Service
public class UserService extends GenericDaoService<User,Long,UserRepository> {

    public User findByEmail(String email){
       return getRepository().findByEmail(email);
    }
}
