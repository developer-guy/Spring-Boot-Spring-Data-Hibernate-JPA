package org.todolist.persistence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bapaydin on 16.10.2016.
 */
@Controller
public class HomeController {

    @RequestMapping(path = "/")
    public String helloPage(){
        return "index";
    }
}
