package org.todolist.persistence.repository;

import org.springframework.stereotype.Repository;
import org.todolist.persistence.dao.UserDao;
import org.todolist.persistence.domain.User;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Repository
public class UserRepository extends GenericDaoRepository<User,Long> implements UserDao{

}
