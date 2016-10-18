package org.todolist.persistence.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.todolist.persistence.domain.Todo;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.repository.TodoRepository;
import org.todolist.persistence.service.TodoService;
import org.todolist.persistence.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by bapaydin on 18.10.2016.
 */
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    private Logger LOG = LoggerFactory.getLogger(TodoController.class);


    @RequestMapping(path = "/todo", method = RequestMethod.GET)
    public String todo(HttpServletRequest request,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        List<Todo> allTodos = todoService.findTodosByUserId(user);
        if(allTodos.size() != 0 ){
            model.addAttribute("render",true);
            model.addAttribute("todos",allTodos);
        }
        model.addAttribute(new Todo());
        return "todo";
    }

    @RequestMapping(path = "/todo", method = RequestMethod.POST)
    public String addTodo(HttpServletRequest request, @ModelAttribute Todo todo, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        todo.setUser(user);
        Todo addedTodo = todoService.update(todo);
        return "redirect:/todo";
    }

}
