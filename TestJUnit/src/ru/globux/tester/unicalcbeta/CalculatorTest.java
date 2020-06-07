package ru.globux.tester.unicalcbeta;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc1 = new Calculator();
        Scanner scan = new Scanner(System.in);
        String numAR;
        numAR = scan.nextLine();
//        System.out.println(numAR + " Test In");
//        System.out.println(calc1.verificationOfTheNumbers(numAR) + " m"); // !!!
//        System.out.println(numAR + " Test Out");
        calc1.verificationOfTheNumbers(numAR);
        int num1 = calc1.getIntNum1();
        int num2 = calc1.getIntNum2();
        char sign = calc1.getCharOperator();
        int reresult = calc1.calculate(num1, num2, sign);
        System.out.println("reresult: " + reresult);


    }
}