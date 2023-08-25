public class Exceptions {
}
/*
Exception example 1
        class Exc0 {
            public static void main(String[] args) {
                int a = 0;
                int b = 42 / a;
            }
        }

Exception example 2
        class Exc1 {
            static void subroutine() {
                int a = 0;
                int b = 10 / a; // Exception возник в этом методе, Исправление делаем в первой строке которую выдал Stack Trace
            }
            public static void main(String[] args) {
                Exc1.subroutine();
            }
        }

Exception example 3
        class Exc2 {
            public static void main(String[] args) {
                int a, b;
                try { //проконтролировать блок кода
                    a = 0;
                    b = 42 / a;
                    System.out.println("Эта строка не будет выведена.");
                } catch (ArithmeticException e) { //перехватить ошибку деления на 0
                    System.out.println("Деление на 0.");
                }
                System.out.println("После оператора catch.");
            }
        }

Exception example 4
        class HandleError {
            public static void main(String[] args) {
                int a = 0, b = 0, c = 0;
                Random r = new Random();
                for (int i = 0; i < 32000; i++) {
                    try {
                        b = r.nextInt();
                        c = r.nextInt();
                        a = 12345/(b/c);
                    } catch (ArithmeticException e) {
                        System.out.println("Деление на 0.");
                        a = 0;
                    }
                    System.out.println("a: " + a);
                }
            }
        }

Exception example 5
        //Обработать исключение и продолжить работу
        class HandleError {
            public static void main(String[] args) {
                int a = 0, b = 0, c = 0;
                Random r = new Random();
                for (int i = 0; i < 32000; i++) {
                    try {
                        b = r.nextInt();
                        c = r.nextInt();
                        a = 12345/(b/c);
                    } catch (ArithmeticException e) {
                        System.out.println("Исключение: " + e);
                        a = 0; //присвоить 0 и продолжить работу
                    }
                    System.out.println("a: " + a);
                }
            }
        }

Exception example 6
        //Приминение нескольких операторов catch
        class  MultipleCatches {
            public static void main(String[] args) {
                try {
                    int a = args.length;
                    System.out.println("a: " + a);
                    int b = 42 / a;
                    int[] c = {1};
                    c[42] = 99;
                } catch (ArithmeticException e) {
                    System.out.println("Деление на ноль " + e);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ошибка индексации за пределеми массива: " + e);
                }
                System.out.println("После блока операторов try/catch.");
            }
        }

Exception example 7
        //Эта программа содержит ошибку
        //В последовательности операторов catch подкласс исключений
        //должен быть указан перед его суперклассом, иначе это приведёт
        //к недостижимому коду и ошибке во время компиляции.
        class SuperSubCatch {
            public static void main(String[] args) {
                try {
                    int a = 0;
                    int b = 42 / a;
                } catch (Exception e) {
                    System.out.println("Перехват исключений суперкласса Exception.");
                }
        //Этот оператор catch вообще не будет достигнут, т.к.
        //подкласс ArithmeticException является производным
        //от класса Exception
                catch (ArithmeticException e) {//ОШИБКА!! Недостижимый код
                    System.out.println("Этод код вообще недостидим.");
                }
            }
        }

Exception example 8

*/