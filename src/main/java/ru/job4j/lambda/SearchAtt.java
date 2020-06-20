package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    private static List<Attachment> filter(List<Attachment> attachments, Predicate<Attachment> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : attachments) {
            if (func.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> attachments) {
        Predicate<Attachment> func = new Predicate<>() {
            @Override
            public boolean test(Attachment att) {
                return att.getSize() > 100;
            }
        };
        return filter(attachments, func);
    }

    public static List<Attachment> filterName(List<Attachment> attachments) {
        Predicate<Attachment> func = new Predicate<>() {
            @Override
            public boolean test(Attachment att) {
                return att.getName().contains("bug");
            }
        };
        return filter(attachments, func);
    }
 }
