package common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper<T> {
    public List<String> read(String path) {
        List<String> res = new ArrayList<>();
        creatFileNotExist(path);

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = "";
            while((line = reader.readLine()) != null) {
                res.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    public void write(List<T> tList, String path, boolean isAppend) {
        creatFileNotExist(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, isAppend))){
            for(T t : tList) {
                writer.write(t.toString());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void creatFileNotExist(String path) {
        File file = new File(path);
        try {
            if(!file.exists())
                file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
