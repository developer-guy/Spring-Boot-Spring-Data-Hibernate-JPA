package org.todolist.persistence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.todolist.persistence.domain.User;

/**
 * Created by bapaydin on 17.10.2016.
 */
@Controller
public class ResultController {

    @RequestMapping(path = "/result",method = RequestMethod.GET)
    public String result(@ModelAttribute("user") final User user, Model model){
        model.addAttribute("user",user);
        return "result";
    }
}
