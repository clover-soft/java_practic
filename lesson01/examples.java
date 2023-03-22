package lesson01;

import java.util.*;

public class examples {

    /**
     * Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное
     * количество подряд идущих 1.
     */

    static void example01() {
        int[] array = { 1, 1, 0, 1, 1, 1 };

        int curr = 0;
        int best = 0;
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if (a == 1) {
                curr++;
            } else {
                if (curr > best) {
                    best = curr;
                }
                curr = 0;
            }
        }
        if (curr > best) {
            best = curr;
        }

        System.out.println(best);
    }

    /*
     * Дан массив nums = [3,2,2,3] и число val = 3. Если в массиве есть числа,
     * равные заданному,
     * нужно перенести эти элементы в конец массива. Таким образом, первые
     * несколько(или все)
     * элементов массива должны быть отличны от заданного, а остальные - равны ему.
     */
    // int[] both = ArrayUtils.addAll(first, second);
    public static void example02() {
        int[] arr = { 0, 1, 3, 3, 2, 3, 4, 1, 0, 3 };
        int val = 3;
        List<Integer> leftArr = new ArrayList<Integer>();
        List<Integer> rightArr = new ArrayList<Integer>();
        for (int item : arr) {
            if (val == item)
                rightArr.add(item);
            else
                leftArr.add(item);
        }
        leftArr.addAll(rightArr);
        System.out.println(Arrays.toString(leftArr.toArray()));
    }

    /*
     * Напишите метод, который находит самую длинную строку общего префикса среди
     * массива строк.
     * Если общего префикса нет, вернуть пустую строку "".
     */

    static String example03(String[] array) {
        String first = array[0];
        for (int i = 1; i < array.length; i++) {
            if (first.length() > array[i].length()) {
                first = array[i];
            }
        }

        String result = "";
        first: for (int index = 0; index < first.length(); index++) {
            char firstIndexChar = first.charAt(index);
            for (int i = 1; i < array.length; i++) {
                char secondStringChar = array[i].charAt(index);

                if (firstIndexChar != secondStringChar) {
                    break first;
                }
            }
            result += firstIndexChar;
        }

        return result;
    }

    public static void main(String[] args) {
        example02();
    }

}