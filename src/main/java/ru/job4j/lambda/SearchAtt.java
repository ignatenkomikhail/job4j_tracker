package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SearchAtt {

    private static List<Attachment> filter(List<Attachment> attachments,
            BiFunction<Attachment, List<Attachment>, List<Attachment>> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : attachments) {
            rsl = func.apply(att, rsl);
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> attachments) {
        BiFunction<Attachment, List<Attachment>, List<Attachment>> func = new BiFunction<>() {
            @Override
            public List<Attachment> apply(Attachment att, List<Attachment> rsl) {
                if (att.getSize() > 100) {
                    rsl.add(att);
                }
                return rsl;
            }
        };
        return filter(attachments, func);
    }

    public static List<Attachment> filterName(List<Attachment> attachments) {
        BiFunction<Attachment, List<Attachment>, List<Attachment>> func = new BiFunction<>() {
            @Override
            public List<Attachment> apply(Attachment att, List<Attachment> rsl) {
                if (att.getName().contains("bug")) {
                    rsl.add(att);
                }
                return rsl;
            }
        };
        return filter(attachments, func);
    }
 }
