package ru.globux.tester;

import java.util.jar.JarOutputStream;

public class LambdaTest {
    static LambdaTest lt;

    public static void main(String... args) {
        lt = new LambdaTest();
        lt.runTestLambda();
    }

    private void runTestLambda() {
        int n = 5;
        MyIface mi = () -> {
            int x = n + 1;
            System.out.println("Вызов из лямбды + " + x);
            System.out.println(this);
        };
        mi.func();
        System.out.println(mi);
        //n++;  // Локальная переменная используемая в анонимном классе должна быть либо final,
                // либо неизменяемой на протяжении всего своего существования.
        String[] s = {"qwer", "asdf"};
        String s1 = joinStr(String::join, "-", s);
        System.out.println(s1); //String::join()

        String[] s2 = {"qwer", "asdf", "zxcv"};

        // Вариант 1
        System.out.println(((StrJoin) String::join).doIt("/", s2));

        // Вариант 2
        StrJoin sj1 = String::join;
        System.out.println(sj1.getClass().getSimpleName());
        String s3 = sj1.doIt("/", s2);
        System.out.println(s3);

        MyIface mf = lt::refMethInst; // Экземпляр анонимного класса реализующего интерфейс MyIface, с подмененным методом func()
        mf.func();
        System.out.println(mf);
        System.out.println(mf.getClass().getSimpleName());

        // тест ссылки на метод экземпляра через класс
        LambdaTest2 lt2 = new LambdaTest2() {};
        MyIntLamb mf2 = LambdaTest2::test;
        mf2.func(lt2);

        // тест ссылки на метод экземпляра через класс
        MyIntNum myNum = new MyIntNum(1);
        MyIntNumPredicate inp = MyIntNum::isFactor;
        inp.test(myNum, 2);

        // тест ссылки на метод экземпляра через класс
        HighTemp[] highTemps = {new HighTemp(45), new HighTemp(75), new HighTemp(56)};
        int c = counter(highTemps, HighTemp::LessTemp, new HighTemp(87));
        System.out.println("Счётчик маленьких HighTemp's = " + c);
    }

    private String joinStr(StrJoin j, CharSequence cs, CharSequence... csa) {
        return j.doIt(cs, csa);
    }

    private void refMethInst() {
        System.out.println("Тест. Подмена метода анонимного класса методом экземпляра");
    }

    private <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;
        for (T val : vals) {
            if (f.func(val, v)) count++;
        }
        return count; // Заглушка
    }
}

interface MyFunc<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private final int hiTemp;
    public HighTemp(int t) {
        this.hiTemp = t;
    }
    public boolean SameTemp(HighTemp h) {
        return this.hiTemp == h.getTemp();
    }
    public boolean LessTemp(HighTemp h) {
        return this.hiTemp < h.getTemp();
    }
    public int getTemp() {
        return hiTemp;
    }
}

interface MyIntLamb {
    void func(LambdaTest2 l);
}

class LambdaTest2 {
    public void test() {
        System.out.println("тест LambdaTest2");
    }
}

interface MyIface {
    void func();

}

interface StrJoin {
    String doIt(CharSequence delim, CharSequence... elem);

}

interface MyIntNumPredicate {
    boolean test(MyIntNum mv, int n);
}

class MyIntNum {
    public MyIntNum(int x) {

    }
    boolean isFactor(int n){
        System.out.println("Сообщение из MyIntNum");
        return true;
    }
}

