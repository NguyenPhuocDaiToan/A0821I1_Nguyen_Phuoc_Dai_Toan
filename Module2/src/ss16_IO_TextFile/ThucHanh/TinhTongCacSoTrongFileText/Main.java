package ss16_IO_TextFile.ThucHanh.TinhTongCacSoTrongFileText;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Nhập đường dẫn file: ");
//        Scanner scanner = new Scanner(System.in);
//        String path = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileText("F:\\Codegym\\Module2\\src\\ss16_IO_TextFile\\ThucHanh\\TinhTongCacSoTrongFileText\\numbers");
    }
}

