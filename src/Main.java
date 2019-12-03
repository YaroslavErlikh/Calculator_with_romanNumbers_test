import input.Convert;
import input.Input;
import operations.Calc;

public class Main {

    public static void main(String[] args) {
        System.out.println("Вас приветствует калькулятор\nВведите пример арабскими либо римскими цифрами");
        Input.in();

        if (Input.getOperation().contains("\\+")) printResult(Calc.sum());
        else if (Input.getOperation().contains("-")) printResult(Calc.sub());
        else if (Input.getOperation().contains("\\*")) printResult(Calc.mul());
        else if (Input.getOperation().contains("/")) printResult(Calc.dev());
        else if (Input.getOperation().contains(":")) printResult(Calc.dev());
    }

    private static void printResult(int resul) {
        String print;
        boolean isNegative=false;

        if (Input.isIsRoman()) {
            if (resul<0){
                resul*=-1;
                isNegative=true;
            }
            print = isNegative ? "-"+Convert.convertArabicToRoman(resul) : Convert.convertArabicToRoman(resul);
        } else print = Integer.toString(resul);

        System.out.println(print);
    }
}
