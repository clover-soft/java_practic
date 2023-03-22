package lesson01;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class homework {

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть
     * true, в противном случае – false.
     */
    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        int summ = a + b;
        return summ >= 10 && summ <= 20;
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        return x > 0;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        for (int i = 0; i < repeat; i++) {
            System.out.println(source);
        }
    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));
    }

    private static int[] createArray(int len, int initalValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initalValue;
        }
        return arr;
    }

    private static List<Integer> replaceArrItems(Integer[] arr, int val1, int val2) {
        // 1.Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
        // заменить 0 на 1, 1 на 0;
        List<Integer> arr2 = Arrays.asList(arr);
        UnaryOperator<Integer> op = (num) -> num == val1 ? val2 : val1; // Мог бы просто циклом, но лямбду попробовать
                                                                        // интереснее было
        arr2.replaceAll(op);
        return arr2;

    }

    private static int[] productArrItems(int[] arr) {
        // 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему
        // циклом, и числа меньшие 6 умножить на 2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;
        }
        return arr;

    }

    private static int[][] quadMatrixDiagonalFill(int size) {
        // 3. Создать квадратный двумерный целочисленный массив (количество строк и
        // столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно
        // только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу: индексы
        // таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        // Также заполнить элементы побочной диагонали
        //
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, z = arr[i].length - 1; j < arr[i].length; j++, z--) {
                if (i == j || i == z)
                    arr[i][j] = 1;
                else
                    arr[i][j] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false
        System.out.println(isPositive(5)); // true
        System.out.println(isPositive(-3)); // false
        System.out.println(isLeapYear(2023));
        System.out.println(Arrays.toString(createArray(10, 33)));
        printString("abcd", 5); // abcdabcdabcdabcdabcd
        Integer[] arr = { 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 };
        System.out.println(Arrays.toString(replaceArrItems(arr, 1, 0).toArray()));
        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(productArrItems(arr2)));
        int[][] arr3 = quadMatrixDiagonalFill(20);
        for (int[] is : arr3) {
            System.out.println(Arrays.toString(is));
        }

    }
}
