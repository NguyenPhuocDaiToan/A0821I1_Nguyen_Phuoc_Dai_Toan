package ss16_IO_TextFile.BaiTap.CopyFile;

import java.io.*;

public class CopyFile {
    private static void copyFile() throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream("F:\\Codegym\\Module2\\src\\ss16_IO_TextFile\\BaiTap\\CopyFile\\SourceFile");
            output = new FileOutputStream("F:\\Codegym\\Module2\\src\\ss16_IO_TextFile\\BaiTap\\CopyFile\\TargetFile");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            input.close();
            output.close();
        }
    }

    public static void main(String[] args) throws IOException {
        copyFile();
    }
}
