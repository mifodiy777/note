package ru.innopolis.note.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Кирилл on 21.11.2016.
 */
@Controller
public class SecurityController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String start(HttpSession session, Model model) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getName();
            session.setAttribute("username", username);
        }
        return "index";
    }

    /**
     * Форма авторизации
     *
     * @param error  msg об ошибке
     * @param logout msg о выходе из сессии
     * @param model
     * @return форма
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        ModelMap model) {
        if (error != null) {
            model.addAttribute("error", "Неправильный логин или пароль!");
        }
        if (logout != null) {
            model.addAttribute("msg", "Вы вышли");
        }
        return "login";
    }
}
