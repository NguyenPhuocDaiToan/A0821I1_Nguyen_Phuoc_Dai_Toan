package service;

import model.Setting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SettingService {
    private static List<Setting> settingList = new ArrayList<>();

    static {
        settingList.add(new Setting("Vietnamese", 10, true, "Hello Viet Nam"));
        settingList.add(new Setting("English", 20, false, "Hello English"));
        settingList.add(new Setting("Chinese", 15, false, "Hello China"));
        settingList.add(new Setting("Japanese", 10, true, "Hello Japan"));
    }

    public Setting getSetting(String language) {
        return settingList.stream().filter(e-> e.getLanguage().equals(language)).collect(Collectors.toList()).get(0);
//        int size = settingList.size();
//        for(int i = 0; i < size; i++) {
//            if(settingList.get(i).getLanguage().equals(language)) {
//                return settingList.get(i);
//            }
//        }
//        return null;
    }

    public void save(Setting setting) {
        settingList.set(settingList.indexOf(getSetting(setting.getLanguage())), setting);
    }
}
