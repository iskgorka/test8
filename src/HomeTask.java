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
        if (a == 0 | b == 0) throw new ArithmeticException();
        else return a / b;
    }

    static int getNumber(int i) throws MyException {
        if (i < 1 | i > 100) throw new MyException(i);
        else return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите число в диапазоне [1;100]");
            int value1 = getNumber(sc.nextInt());
            System.out.println(value1);
        } catch (MyException e) {
            System.out.println("Исключение перехвачено - " + e.toString());
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели строку " + e);
        }

        try {
            System.out.println("Введите 2 числа: ");
            double value2 = sc.nextDouble();
            double value3 = sc.nextDouble();
            System.out.println(divineDouble(value2, value3));
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели строку " + e);
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0 " + e);
        }
    }
}


