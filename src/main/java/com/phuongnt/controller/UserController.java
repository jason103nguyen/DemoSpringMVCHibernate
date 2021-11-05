package com.phuongnt.controller;

import com.phuongnt.entities.User;
import com.phuongnt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUser() {

        userService.create(new User("Huong", "2222", "huong@gmail.com"));

        return "home.jsp";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        return "hello.jsp";
    }
}
