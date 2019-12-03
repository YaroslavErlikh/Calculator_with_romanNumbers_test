package input;

import enums.Roman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Input {

    private static String example;
    private static ArrayList<String> ex = new ArrayList<>();
    private static String operation;
    private static List<Roman> romanNumerals = Roman.getHashMapRoman();
    private static ArrayList<Integer> elements = new ArrayList<>();
    private static boolean isRoman;

    public static List<Roman> getRomanNumerals() {
        return romanNumerals;
    }

    public static ArrayList<Integer> getElements() {
        return elements;
    }

    public static String getOperation() {
        return operation;
    }

    public static boolean isIsRoman() {
        return isRoman;
    }

    public static void in() {

        example = new Scanner(System.in).nextLine().toUpperCase();

        whichOperation();

        ex.addAll(Arrays.asList(example.split(operation)));

        if (ex.size() > 2) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.println("Вводите пример из 2х чисел");
                System.exit(1);
            }
        }

        arabOrRome(ex);
    }

    private static void whichOperation() {
        if (example.contains("+")) operation = "\\+";
        else if (example.contains("-")) operation = "-";
        else if (example.contains("*")) operation = "\\*";
        else if (example.contains("/")) operation = "/";
        else if (example.contains(":")) operation = "/";
        else throw new IllegalArgumentException(example + " ошибка ввода");
    }

    private static void arabOrRome(ArrayList<String> num) {

        for (Roman r : romanNumerals) {
            for (String str : num) {
                if (str.startsWith(r.name())) {
                    isRoman = true;
                    break;
                }
            }
        }

        if (isRoman) {
            for (String str : num) {
                elements.add(Convert.convertRomanToArabic(str));
            }
        } else {

            for (String str : num) {
                int i = Integer.parseInt(str);

                if (1 > i || i > 10) {
                    try {
                        throw new NumberFormatException();
                    } catch (NumberFormatException e) {
                        System.err.println("Вводите числа от 1 до 10");
                        System.exit(1);
                    }
                } else {
                    elements.add(i);
                }
            }
        }
    }
}
