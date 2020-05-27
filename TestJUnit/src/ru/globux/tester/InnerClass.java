package ru.globux.tester;

public class InnerClass {
    class BB {
    }

    static class CC {
    }

    public static void main(String... args) {
        A a = new A();
        B b = new B();
        C c = new C<F>();
        A ab, ac; B bb, bc; C cc;
        ab = b; bb = b;
        System.out.println("#### Используем экземпляр В:");
        System.out.println("Присвоен переменной типа А");
        ab.test(); ab.methA(); //ab.methB();
        System.out.println(ab.i);
        System.out.println("Присвоен переменной типа B");
        bb.test(); bb.methA(); bb.methB();
        System.out.println(bb.i);
        System.out.println();

        ac = c; bc = c; cc = c;
        System.out.println("#### Используем экземпляр C:");
        System.out.println("Присвоен переменной типа А");
        ac.test();
        System.out.println(ac.i);
        System.out.println("Присвоен переменной типа B");
        bc.test();
        System.out.println(bc.i);
        System.out.println("Присвоен переменной типа C");
        cc.test();
        System.out.println(cc.i);

        D d = new D<F>();
        E e = new E();
        A a1 = new D();
        C<E> c1 = new C<E>();
        C<E> c2 = (C<E>) new D<E>();
        A a2 = new C<F>();
        Object o = (Object) d;
        if (b instanceof C<?>) {
            //test
        }
        c2.test();
        E<?>[] ee = new E<?>[10];
        ee[0] = new E<D>();
        F ff = new F(new E<C<?>>());
        System.out.println("d: " + d.getClass() + "\n" + "o: " + o.getClass() + "\n" + "a1: " + a1.getClass() + "\n" + "e: " + e.getClass() + "\n");
    }
}

class A {
    String i = "Поле класса из А";
    void test() {
        System.out.println("Вызван метод Тест из А");
    }
    void methA() {
        System.out.println("Meth A");
    }
}
class B extends A {
    String i = "Поле класса из В";
    @Override
    void test() {
        System.out.println("Вызван метод Тест из В");
    }
    void methB() {
        System.out.println("Meth B");
    }
}
class C<T> extends B {
    String i = "Поле класса из С";
    @Override
    void test() {
        System.out.println("Вызван метод Тест из С");
    }
}
class D<T> extends C<T> {}
class E<T extends B> {}
class F {
    public F(E<? super C<?>> b) {
    }
    public void myMethod() {
    }
}
interface IGenIF<T, V extends T> {}
class MyClass<T, V extends T> implements IGenIF<T,V> {}
