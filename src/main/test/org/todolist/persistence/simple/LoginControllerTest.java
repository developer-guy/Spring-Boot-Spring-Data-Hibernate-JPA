package org.todolist.persistence.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.todolist.persistence.domain.Todo;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.service.UserService;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.* ;

/**
 * Created by bapaydin on 20.10.2016.
 */

//Todo : Fail,buna bak!
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestEntityManager
@DataJpaTest
public class LoginControllerTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService userService;


    @Test
    public void testExample() throws Exception {
        this.entityManager.persist(new User("sboot","boot","test@test.com","1234",new ArrayList<Todo>()));
        User user = this.userService.findByEmail("test@test.com");
        assertThat(user.getUserName()).isEqualTo("sboot");
        assertThat(user.getSurName()).isEqualTo("boot");
    }
}
