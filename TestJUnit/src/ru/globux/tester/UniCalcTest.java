package ru.globux.tester;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Scanner;

class UniCalc {
    private final static String rexAra = "^(10|[1-9]) *[+-/*] *(10|[1-9])$";
    private final static String rexRim = "^(V?I{1,3}|I?[VX]) *[+-/*] *(V?I{1,3}|I?[VX])$";

    public static String calc(String exp) throws IllegalMathExpression {
        String[] nums = exp.split("[+\\-/*]");
        int[] ints = new int[nums.length];
        int i1, i2;
        String result;
        if (exp.matches(rexAra)) {
            i1 = Integer.parseInt(nums[0].trim());
            i2 = Integer.parseInt(nums[1].trim());
            result = Integer.toString(operation(exp, i1, i2));
        }
        else if (exp.matches(rexRim)) {
            i1 = RomNumConverter.romToInt(nums[0].trim());
            i2 = RomNumConverter.romToInt(nums[1].trim());
            result = RomNumConverter.intToRom(operation(exp, i1, i2));
        }
        else {
            throw new IllegalMathExpression("Invalid math expression or number value out of range");
        }
        return result;
    }

    private static int operation(String exp, int i1, int i2) throws IllegalMathExpression {
        int result;
        if (exp.contains("+")) {
            result = i1 + i2;
        }
        else if (exp.contains("-")) {
            result = i1 - i2;
        }
        else if (exp.contains("*")) {
            result = i1 * i2;
        }
        else if (exp.contains("/")) {
            result = i1 / i2;
        }
        else {
            throw new IllegalMathExpression("Illegal operation");
        }
        return result;
    }
}

class RomNumConverter {
    private static final NavigableMap<Integer, String> aras;
    private static final NavigableMap<Character, Integer> rims;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        aras = Collections.unmodifiableNavigableMap(initMap);

        NavigableMap<Character, Integer> initRims = new TreeMap<>();
        initRims.put('I', 1);
        initRims.put('V', 5);
        initRims.put('X', 10);
        initRims.put('L', 50);
        initRims.put('C', 100);
        initRims.put('D', 500);
        initRims.put('M', 1000);
        rims = Collections.unmodifiableNavigableMap(initRims);
    }

    public static String intToRom(int number) {
        StringBuilder result = new StringBuilder();
        for(Integer key : aras.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(aras.get(key));
            }
        }
        return result.toString();
    }

    public static int romToInt(String rim) {
        int result = 0;
        for (int i = 0; i < rim.length(); i++) {
            if (i < rim.length() - 1) {
                int k1 = rims.get(rim.charAt(i));
                int k2 = rims.get(rim.charAt(i + 1));
                if (k2 > k1) {
                    ++i;
                    result += k2 - k1;
                }
                else {
                    result += k1;
                }
            }
            else {
                result += rims.get(rim.charAt(i));
            }
        }
        return result;
    }
}

class IllegalMathExpression extends Exception {
    IllegalMathExpression() {
        super();
    }
    IllegalMathExpression(String description) {
        super(description);
    }
}

public class UniCalcTest {
    public static void main(String[] args) {
        System.out.print("Введи выражение в формате 'число' + 'число': ");
        Scanner console = new Scanner(System.in);
        try {
            System.out.println(UniCalc.calc(console.nextLine()));
        } catch (IllegalMathExpression illegalMathExpression) {
            illegalMathExpression.printStackTrace();
        }
    }
}
