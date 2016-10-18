package org.todolist.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bapaydin on 18.10.2016.
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
