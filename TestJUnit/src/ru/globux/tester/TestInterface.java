package ru.globux.tester;

public class TestInterface {
    public static void main(String[] args) {

    }

}

class Inheritor implements MyInterfaceOne, MyInterfaceTwo {
    @Override
    public int method() {
        return 1;
    }
}

interface MyInterfaceOne {
    int method();
}

interface MyInterfaceTwo {
    int method();
}
