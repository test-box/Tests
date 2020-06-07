package ru.globux.tester.unicalcbeta;

public class Calculator {
    private int num1;
    private int num2;
    private char sign;
    private boolean flag = false;
    private int result;

    public int getIntNum1() {
        return num1;
    }

    public int getIntNum2() {
        return num2;
    }

    public char getCharOperator() {
        return sign;
    }

    public boolean verificationOfTheNumbers(String numAR) {
        String regexArab = "^(10|[1-9]{1}) [+-/*]{1} (10|[1-9]{1})$";
        String regexRom = "^([IVX]{1}|[IVX]{2}|[IV]{3}|[IV]{4}) [+-/*]{1} ([IVX]{1}|[IVX]{2}|[IV]{3}|[IV]{4})$";
        System.out.println(numAR.matches(regexArab) + "Arab");
        System.out.println(numAR.matches(regexRom) + "Rom");

        if (numAR.matches(regexArab)) {
            System.out.println("+++A");
            flag = true;
            String[] arrayFromStringArab = numAR.split(" ");
            num1 = Integer.parseInt(arrayFromStringArab[0]);
            num2 = Integer.parseInt(arrayFromStringArab[2]);
            sign = arrayFromStringArab[1].charAt(0);
            System.out.println("Arab input");

        } else if (numAR.matches(regexRom)) {
            System.out.println("+++R");
            flag = true;
            String[] arrayFromStringRom = numAR.split(" ");
            num1 = Calculator.romanNumerals(arrayFromStringRom[0]);
            num2 = Calculator.romanNumerals(arrayFromStringRom[2]);
            sign = arrayFromStringRom[1].charAt(0);
        }
        System.out.println("Exception arab | Rom"); //!!! Exception
        System.out.println("num1: " + num1 + "\nnum2: " + num2 + "\nsign: " + sign);
        return flag;
    }

    private static int romanNumerals(String numRom) {
        int numArab = 0;
        String letters[]  = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for(int i = 0; i < letters.length; i++){
            if(numRom.equals(letters[i])){
                System.out.println("true: " + i);
                numArab = i + 1;
            }
        }
        if(numArab == 0) {
            System.out.println("Exception input RomIIIII"); //!!! Exception
        }
        return numArab;
    }

    public int calculate(int num1, int num2, char sign) {
        int result = 0;
        switch(sign) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("You made an error when entering a number or operator"); // Exception
        }
        return result;
    }
}