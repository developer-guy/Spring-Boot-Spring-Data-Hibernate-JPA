package org.todolist.persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.service.UserService;

/**
 * Created by bapaydin on 17.10.2016.
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("loginUser",new User());
        return "login";
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute User user,Model model){
        User byEmail = userService.findByEmail(user.getEmail());
        if(byEmail == null){
            model.addAttribute("loginUser",new User());
            model.addAttribute("status",true);
            model.addAttribute("msg","Kullanıcı kaydı bulunamadı,Kayıt olunuz");
            return "login";
        }else{
            if(user.getPassword().equals(byEmail.getPassword())){
                model.addAttribute("user",byEmail);
                return "home";
            }else{
                model.addAttribute("loginUser",new User());
                model.addAttribute("msg","Şifre yanlış,tekrar deneyin");
                return "login";
            }
        }
    }

}
