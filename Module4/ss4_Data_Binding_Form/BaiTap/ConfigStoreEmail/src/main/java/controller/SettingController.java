package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SettingService;

@Controller
public class SettingController {
    private SettingService service = new SettingService();
    @GetMapping("/setting")
    public ModelAndView setting() {
        return new ModelAndView("setting", "set", new Setting());
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("set") Setting setting) {
        service.save(setting);
        return new ModelAndView("setting", "set", setting);
    }
}
