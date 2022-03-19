package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @PostMapping("/sandwich")
    public ModelAndView save(@RequestParam("condiment") String condiment) {
        ModelAndView modelAndView = new ModelAndView("index", "choices", condiment);
        return modelAndView;
    }
}
