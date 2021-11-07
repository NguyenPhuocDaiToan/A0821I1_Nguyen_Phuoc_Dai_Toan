package ss5_AccessModifier_Static.BaiTap.WriteOnlyClass;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String name, classes;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập lớp: ");
        classes = scanner.nextLine();
        Student student =  new Student();
        student.setName(name);
        student.setClasses(classes);
        student.dislay();
    }
}


