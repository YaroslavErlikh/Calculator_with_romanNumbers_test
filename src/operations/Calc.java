package operations;

import input.Input;

public class Calc {

    public static int sum() {
        int sum = Input.getElements().get(0);

        for (int i = 1; i < Input.getElements().size(); i++) {
            sum += Input.getElements().get(i);
        }

        return sum;
    }

    public static int mul() {
        int mul = Input.getElements().get(0);

        for (int i = 1; i < Input.getElements().size(); i++) {
            mul *= Input.getElements().get(i);
        }

        return mul;
    }

    public static int sub() {
        int sub = Input.getElements().get(0);

        for (int i = 1; i < Input.getElements().size(); i++) {
            sub -= Input.getElements().get(i);
        }

        return sub;
    }

    public static int dev() {
        int dev = Input.getElements().get(0);

        for (int i = 1; i < Input.getElements().size(); i++) {
            dev /= Input.getElements().get(i);
        }

        return dev;
    }
}
