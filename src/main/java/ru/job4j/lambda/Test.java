package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (a, b) -> {
            System.out.println("compare: " + '\"' + b + '\"' + " with " + '\"' + a + '\"');
            return b.compareTo(a);
        };
        String[] strs = {"zxr", "abc", "rty", "lka"};
        Arrays.sort(strs, cmpDescSize);
        System.out.println(Arrays.toString(strs));
    }
}
