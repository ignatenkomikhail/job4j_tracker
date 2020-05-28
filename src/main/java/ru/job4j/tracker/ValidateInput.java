package ru.job4j.tracker;

import java.util.Scanner;

public class ValidateInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.parseInt(askStr(question));
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }

        } while (invalid);
        return value;
    }
    @Override
    public int askInt(String question, int max) {
        int value = -1;
        do {
            try {
                value = Integer.parseInt(askStr(question));
                if (value >= 0 && value < max) {
                    return value;
                } else {
                    throw new IllegalStateException(String.format("Out of about %s > [0, %s]", value, max));
                }
            } catch (IllegalStateException ise) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (true);
    }
}
