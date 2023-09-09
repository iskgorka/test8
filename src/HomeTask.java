import java.util.InputMismatchException;
import java.util.Scanner;

class MyException extends Exception {
    private int value;

    MyException(int i) {
        value = i;
    }

    public String toString() {
        return "Число в недопустимом диапазоне [" + value + "]";
    }
}

public class HomeTask {
    static double divineDouble(double a, double b) throws ArithmeticException {
        if (a == 0 || b == 0) throw new ArithmeticException();
        else return a / b;
    }

    static int getNumber(int i) throws MyException {
        if (i < 1 | i > 100) throw new MyException(i);
        else return i;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Введите 2 числа:");
            double a = new Scanner(System.in).nextDouble();
            double b = new Scanner(System.in).nextDouble();
            System.out.println(divineDouble(a, b));
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели строку: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0 " + e);
        }
        try {
            System.out.println("Введите целое число в диапазоне от 1 до 100:");
            int value1 = new Scanner(System.in).nextInt();
            System.out.println(getNumber(value1));
        } catch (MyException e) {
            System.out.println("Исключение перехвачено: " + e);
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели строку: " + e);
        }
    }
}