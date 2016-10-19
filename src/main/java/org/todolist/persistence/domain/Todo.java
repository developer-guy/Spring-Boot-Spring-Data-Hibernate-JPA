package org.todolist.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bapaydin on 18.10.2016.
 */
@Entity
@Table
public class Todo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "todo_id_sequence_table")
    @TableGenerator(
            table = "TODO_ID_SEQUENCE",
            name = "todo_id_sequence_table",
            allocationSize = 50,
            schema = "sample",
            pkColumnName = "TODO_ID"
    )
    @Column(name = "ID")
    private Long id;

    @Column
    private String todoText;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public User user;


    public Todo() {
    }

    public Todo(String todoText, User user) {
        this.todoText = todoText;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodoText() {
        return todoText;
    }

    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
