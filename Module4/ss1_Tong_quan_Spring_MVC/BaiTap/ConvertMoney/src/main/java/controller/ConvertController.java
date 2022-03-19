package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String convert(@RequestParam() String USD,
                          @RequestParam() String rate,
                          Model model)
    {
        double VietNam = Double.parseDouble(USD) * Double.parseDouble(rate);
        model.addAttribute("VietNam", VietNam);
        return "result";
    }
}
