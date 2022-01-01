package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper<T> {
    public List<String> readFile(String PATH) {
        List<String> res = new ArrayList<>();
        creatFileIfNotExist(PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){
            String line;
            while ((line = reader.readLine()) != null) {
                res.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void writeFile(String PATH, List<T> tList, boolean isAppend) {
        creatFileIfNotExist(PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, isAppend))){
            for(T t : tList) {
                writer.write(t.toString());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatFileIfNotExist(String PATH) {
        File file = new File(PATH);
        try {
            if(!file.exists())
                file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
