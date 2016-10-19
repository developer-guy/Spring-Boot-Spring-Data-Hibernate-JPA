package org.todolist.persistence.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.todolist.persistence.domain.User;
import org.todolist.persistence.repository.TodoRepository;
import org.todolist.persistence.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static javax.swing.text.StyleConstants.ModelAttribute;

/**
 * Created by bapaydin on 17.10.2016.
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User foundUser = userService.findByEmail(user.getEmail());
        if (foundUser == null) {
            model.addAttribute("user", new User());
            model.addAttribute("render", true);
            model.addAttribute("msg", "Kullanıcı kaydı bulunamadı,Kayıt olunuz");
            return "login";
        } else {
            if (user.getPassword().equals(foundUser.getPassword())) {
                session.setAttribute("user", foundUser);
                return "redirect:/todo";
            } else {
                model.addAttribute("user", new User());
                model.addAttribute("msg", "Şifre yanlış,tekrar deneyin");
                return "login";
            }
        }
    }

}
