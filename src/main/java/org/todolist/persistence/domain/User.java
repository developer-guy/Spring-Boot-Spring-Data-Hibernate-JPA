package org.todolist.persistence.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@lombok.Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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

}
