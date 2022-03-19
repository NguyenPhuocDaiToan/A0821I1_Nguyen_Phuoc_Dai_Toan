package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("hello", "Xin chào");
        map.put("goodbye", "Tạm biệt");
    }
    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam() String english, Model model) {
        model.addAttribute("wordEnglish", english);
        model.addAttribute("wordVietNamese", map.get(english));
        return "result";
    }
}
