package org.todolist.persistence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by bapaydin on 17.10.2016.
 */
@Controller
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("msg") String msg){
        if(msg != null && !msg.toString().equals("")){
            model.addAttribute("msg",msg.toString());
            model.addAttribute("render",true);
        }
        return "index";
    }

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public String goToLoginPage(){
        return "redirect:/login";
    }
}
