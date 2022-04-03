package com.example.user.controller;

import com.example.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @GetMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("index", "user", new User());
    }

    @PostMapping("/add")
    public String addUser(Model model, @Validated User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }
        model.addAttribute("firstName",user.getFirstname());
        model.addAttribute("lastName",user.getLastname());
        return "result";
    }
}
