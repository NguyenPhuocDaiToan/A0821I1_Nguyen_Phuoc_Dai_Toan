package ss1_IntroduceJava.BaiTap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        System.out.println("Nhập vào số dương có tối đa 3 chữ số: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String[] units  = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] dozens = {"zero", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String text = "";
        if(number<=10) text = units[number];
        else if(number<=20){
            switch (number){
                case 11:
                    text = "elevent";
                    break;
                case 12:
                    text = "twelve";
                    break;
                case 13:
                    text = "thirteen";
                    break;
                case 15:
                    text = "fifteen";
                    break;
                case 18:
                    text = "eighteen";
                    break;
                case 20:
                    text = "twenty";
                    break;
                default:
                    text = units[number%10] + "teen";
                    break;
            }
        }
        else if(number<100){
            if(number%10==0)    text = dozens[number/10];
            else text = dozens[number/10] + " " + units[number%10];
        }
        else{
            if(number%100==0)   text = units[number/100] + " hundred";
            else{
                text = units[number/100] + " hundred and ";
                if(number/10%10==0) text += units[number%10];
                else {
                    if(number%10==0)    text += dozens[(number/10)%10];
                    else text += dozens[(number/10)%10] + " " + units[number%10];
                }
            }
        }
        System.out.println(number + " is " + text);
    }
}
