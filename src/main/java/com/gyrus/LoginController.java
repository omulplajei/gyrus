package com.gyrus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello gorgeous!";
    }
}
