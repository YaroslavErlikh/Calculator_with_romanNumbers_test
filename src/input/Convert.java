package input;

import enums.Roman;

import java.util.List;

public final class Convert {

    private static List<Roman> romanNumerals;

    public static int convertRomanToArabic(String input) {

        romanNumerals = Input.getRomanNumerals();

        String romanNumeral = input.toUpperCase();
        int result = 0;
        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            Roman symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {

                if (1 > symbol.getValue() || symbol.getValue() > 10) {
                    try {
                        throw new IllegalArgumentException();
                    } catch (IllegalArgumentException e) {
                        System.err.println("Вводите числа от I до X");
                        System.exit(1);
                        return 0;
                    }
                }

                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        try {
            if (romanNumeral.matches("[-+]?\\d*\\.?\\d+")) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            System.err.println(" Вводите только римские либо только арабские цифры!");
            System.exit(1);
            return 0;
        }
        return result;
    }

    public static String convertArabicToRoman(int number) {

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Roman currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
