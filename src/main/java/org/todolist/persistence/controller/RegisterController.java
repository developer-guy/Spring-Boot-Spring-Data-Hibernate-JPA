package org.todolist.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.service.UserService;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String customerSubmit(@ModelAttribute User user,Model model){
        User add = userService.add(user);
        if(add != null){
            System.out.println();
        }
        model.addAttribute("user",add);
        return "result";
    }
}
