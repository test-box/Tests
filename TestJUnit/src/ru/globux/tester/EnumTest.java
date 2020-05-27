package ru.globux.tester;

public class EnumTest {
    enum Transport {
        CAR, TRACK, TRAIN, AIRPLAIN, BOAT
    }

    enum Trans {
        CAR(200), TRACK(120), TRAIN(300), AIRPLAIN(800), BOAT(25);
        private final int speed;

        Trans(int s) {
            this.speed = s;
        }
        public int getSpeed() {
            return this.speed;
        }
    }

    public static void main(String... args) {
        Transport t = Transport.TRACK;
        System.out.println("t содержит " + t);

        for (Transport tc: t.values()) {
            System.out.println(tc);
        }

        Trans t1, t2;
        t1 = Trans.CAR;
        t2 = Trans.CAR;
        System.out.println((t1 == t2) ? "равны" : "не равны");
    }
}
