package ss1_IntroduceJava.ThucHanh;

import java.util.Scanner;

public class MBI_Caculator {
    public static void main(String[] args) {
        double weight, height, bmi;
        Scanner scanner = new Scanner(System.in);
        // Nhập vào chiều cao, cân nặng
        System.out.print("Your weight (kg): ");
        weight = scanner.nextDouble();
        System.out.print("Your height (m): ");
        height = scanner.nextDouble();

        // Tính BMI
        bmi = weight/ Math.pow(height,2);

        if(bmi<18.5)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if(bmi<25)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if(bmi<30)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
