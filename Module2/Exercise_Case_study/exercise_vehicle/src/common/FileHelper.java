package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper<T> {
    public List<String> read(String Path) {
        List<String> res = new ArrayList<>();
        creatFileIfNotExist(Path);
        try (BufferedReader reader = new BufferedReader(new FileReader(Path))){
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

    public void write(String Path, List<T> tList, boolean isAppend) {
        creatFileIfNotExist(Path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path, isAppend))){
            for (T t : tList) {
                writer.write(t.toString());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatFileIfNotExist(String Path) {
        try {
            File file = new File(Path);
            if(!file.exists())
                file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
