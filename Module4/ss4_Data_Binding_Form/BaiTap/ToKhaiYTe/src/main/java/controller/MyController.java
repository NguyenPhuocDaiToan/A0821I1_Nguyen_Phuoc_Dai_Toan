package controller;

import model.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    private People people = new People();
    @GetMapping()
    public ModelAndView getIndex() {
        return new ModelAndView("index", "res", people);
    }

    @PostMapping("/save")
    public String save(@ModelAttribute People res, Model model) {
        people = res;
        model.addAttribute("people", people);
        return "result";
    }
}
