package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.SettingService;

@Controller
public class OnchangeLanguageController {
    private SettingService service = new SettingService();

    @GetMapping("/getSetting/{lang}")
    public ModelAndView getByLanguage(@PathVariable String lang) {
        Setting setting = service.getSetting(lang);
        return new ModelAndView("setting", "set", setting);
    }
}
