package ru.globux.tester;

public class TestGenerics {
    public static void main(String... args) {

    }
}

interface MinMax<T extends Comparable<T>>  {
    T min();
    T max();
}

class MyClassGen<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;
    public T min() {
        return vals[1]; //dump operator
    }
    public T max() {
        return vals[2]; //dump operator
    }
}