package ru.globux.tester;

import org.junit.jupiter.api.Assertions.*;

public class JUnitTest01 {

    public static int summator(int a, int b) {
        char cl = Character.MIN_VALUE;
        char ch = Character.MAX_VALUE;
        short s1 = (short) cl;
        short s2 = (short) ch;
        int i1 = cl;
        int i2 = ch;
        System.out.println(cl + "  " + ch + "\n" + s1 + "  " + s2);
        System.out.println(i1 + "  " + i2);
        int i = 0b1111_1111_1111_1100;
        char c = (char) i;
        short s = (short) i;
        System.out.println(i + " " + c + " " + s + " " + Short.toUnsignedInt((short) 0b1111_1111_1111_1100));
        System.out.println(Byte.toUnsignedInt((byte) 255));
        return a + b + 1;
    }
}
