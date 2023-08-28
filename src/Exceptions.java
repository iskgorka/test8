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
        //Пример применения вложенных операторов try
        class NestTry {
            public static void main(String[] args) {
                try {
                    int a = args.length;
        //Если не указаны аргументы командной строки
        //в следующем операторе будет сгенерировано
        //исключение в связи с делением на ноль.
                    int b = 42 / a;
                    System.out.println("a: " + a);
                    try { // вложенный блок try
        //Если указан один аргумент командной строки,
        //то исключени в связи с делением на ноль
        //будет сгенерировано в следующем коде.
                        if(a == 1) a = a / (a-a); //деление на 0
        //Если указаны два аргумента командной строки,
        //то генерируется исключение в связи с выходом
        //за пределы массива
                        if(a == 2) {
                            int[] c = {1};
                            c[42] = 99;//здесь генерируется исключение в связи с выходом за пределы массива
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Индекс за пределами массива: " + e);
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Деление на ноль: " + e);
                }
            }
        }

Exception example 9
        class MethNestTry {
            static void nesttry(int a) {
                try {
                    if (a == 1) a = a / (a - a);
                    if (a == 2) {
                        int[] c = {1};
                        c[42] = 99;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Индекс за пределеами массива: " + e);
                }
            }

            public static void main(String[] args) {
                try {
                    int a = args.length;
                    int b = 42 / a;
                    System.out.println("a: " + a);
                    nesttry(a);
                } catch (ArithmeticException e) {
                    System.out.println("Деление на ноль: " + e);
                }
            }
        }

Exception example 10
        //Применение оператора throw
        class ThrowDemo {
            static void demoproc() {
                try {
                    throw new NullPointerException("Демонстрация");
                } catch (NullPointerException e) {
                    System.out.println("Исключение перехвачено в теле метода demoproc().");
                    throw e; //повторно сгенерировать исключение
                }
            }

            public static void main(String[] args) {
                try {
                    demoproc();
                } catch (NullPointerException e) {
                    System.out.println("Повторний перехват: " + e);
                }
            }
        }

Exception example 11
        //Эта программа содержит ошибку и поэтому она не подлежит компиляции
        class ThrowsDemo {
            static void throwOne() throws IllegalAccessException {
                System.out.println("В теле метода throwOne().");
                throw new IllegalAccessException("демонстрация.");
            }

            public static void main(String[] args) throws IllegalAccessException {
                throwOne();
            }
        }

Exception example 12
        //Эта программа написана верно
        class ThrowsDemo {
            static void throwOne() throws IllegalAccessException {
                System.out.println("В теле метода throwOne()");
                throw new IllegalAccessException("демонстрация");
            }

            public static void main(String[] args) {
                try {
                    throwOne();
                } catch (IllegalAccessException e) {
                    System.out.println("Перехвачено исключение " + e);
                }
            }
        }

Exception example 13
        //Применение оператора finally
        class FinallyDemo {
        //сгенерировать исключение в методе
            static void procA() {
                try {
                    System.out.println("В теле метода procA()");
                    throw new RuntimeException("демонстрация");
                } finally {
                    System.out.println("Блок оператора finally в методе procA()");
                }
            }
            //возвратить управление из блока оператора try
            static void procB() {
                try {
                    System.out.println("В теле метода procB()");
                    return;
                } finally {
                    System.out.println("Блок оператора finally в методе procB()");
                }
            }
            //выполнить блок try как обычно
            static void procC() {
                try {
                    System.out.println("В теле метода procC()");
                } finally {
                    System.out.println("Блок оператора finally в методе procС()");
                }
            }

            public static void main(String[] args) {
                try {
                    procA();
                } catch (Exception e) {
                    System.out.println("Исключение перехвачено" + e);
                }
                procB();
                procC();
            }
        }

Exception example 14
        //В этой программе создается специальный тип исключения
        class MyException extends Exception {
            private int detail;
            MyException(int a) {
                detail = a;
            }
            public String toString() {
                return "MyException [" + detail + "]";
            }
        }
        class ExceptionDemo {
            static void compute(int a) throws MyException {
                System.out.println("Вызван метод compute (" + a + ")");
                if (a > 10)
                    throw new MyException(a);
                System.out.println("Нормальное завершение");
            }

            public static void main(String[] args) {
                try {
                    compute(1);
                    compute(20);
                } catch (MyException e) {
                    System.out.println("Исключение перехвачено: " + e);
                }
            }
        }

Exception example 15
        //Продемонстрировать цепочки исключений
        class ChainExcDemo {
            static void demoproc() {
        // создать исключение
                NullPointerException e = new NullPointerException("верхний уровень");
        // добавить причину исключения
                e.initCause(new ArithmeticException("причина"));
                throw e;
            }

            public static void main(String[] args) {
                try {
                    demoproc();
                } catch (NullPointerException e) {
        // вывести исключение верхнего уровня
                    System.out.println("Перехвачено исключение: " + e);
        // вывести исключение, послужившее причиной для исключения верхнего уровня
                    System.out.println("Первопричина: " + e.getCause());
                }
            }
        }
*/