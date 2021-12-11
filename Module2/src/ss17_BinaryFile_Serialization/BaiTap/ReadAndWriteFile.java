package ss17_BinaryFile_Serialization.BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile implements Serializable {
    private static final String PATH = "F:\\Codegym\\Module2\\src\\ss17_BinaryFile_Serialization\\BaiTap\\Products";

    public static List<Product> ReadFile() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            products = (List<Product>) objectInputStream.readObject();
            inputStream.close();
            objectInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void WriteFile(List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
