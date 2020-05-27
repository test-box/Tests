package ru.globux.tester.test;

import org.junit.jupiter.api.Test;
import ru.globux.tester.JUnitTest01;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTest01Test {

    @Test
    void summator() {
        int a = 2;
        int b = 3;

        int expected = 5;
        int actual = JUnitTest01.summator(a, b);
        assertEquals(expected, actual);
    }
}