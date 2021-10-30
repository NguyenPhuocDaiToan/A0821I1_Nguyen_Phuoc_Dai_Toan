package ss1_IntroduceJava.ThucHanh;

import java.util.Scanner;

// Giải phương trình bậc nhất ax+b=c
public class LinearEquationResolver {
    public static void main (String [] args){
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();

        if(a==0){
            if(b==c) System.out.print("The solution is all x");
            else System.out.print("No solution");
        }
        else{
            double answer = (c-b)/a;
            System.out.println("Equation pass with x = " + answer);
        }
    }
}
