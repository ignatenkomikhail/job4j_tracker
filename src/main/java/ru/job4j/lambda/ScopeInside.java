package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    private static int total = 0;

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        for (int i = 0; i < number.length; i++) {
            final int num = i;
            total = add(
                    () -> total + number[num]
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
