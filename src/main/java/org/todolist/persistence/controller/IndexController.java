package org.todolist.persistence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bapaydin on 17.10.2016.
 */
@Controller
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public String goToLoginPage(){
        return "redirect:/login";
    }
}
