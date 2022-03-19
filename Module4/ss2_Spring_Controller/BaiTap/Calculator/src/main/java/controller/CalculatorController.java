package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @GetMapping("/calculator")
    public ModelAndView calculator(@RequestParam String number1, @RequestParam String number2, @RequestParam String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        double n1 = Integer.parseInt(number1);
        double n2 = Integer.parseInt(number2);
        double result = 0;
        switch (operator) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
        }
        return modelAndView.addObject("result", result);
    }
}
