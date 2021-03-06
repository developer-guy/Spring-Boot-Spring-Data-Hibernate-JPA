package org.todolist.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email","password"})
})
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "user_id_sequence_table")
    @TableGenerator(
            table = "USER_ID_SEQUENCE",
            name = "user_id_sequence_table",
            allocationSize = 50,
            schema = "sample",
            pkColumnName = "USER_ID"
    )
    @Column(name = "ID")
    private Long id;


    @Column
    private String userName;

    @Column
    private String surName;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
    private List<Todo> todoList = new ArrayList<>();

    public User() {
    }

    public User(String userName, String surName, String email, String password, List<Todo> todoList) {
        this.userName = userName;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
