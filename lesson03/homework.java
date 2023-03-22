package lesson03;

import java.util.ArrayList;

public class homework {
    /**
     * 1. Дан список ArrayList<Integer> целых чисел. Удалить из него нечетные числа.
     */
    static void homework01(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 > 0) {
                arr.remove(i);
                i--;
            }
        }
    }

    /**
     * 2. Дан список ArrayList<String>. Удалить из него все строки, которые являются
     * числами [*** ТИПА Integer ****]
     * Пример: ArrayList<String> list = new ArrayList<>(List.of("string", "s", "5",
     * "10", "-12", "my_value"));
     * ["string", "s", "my_value"]
     */
    static void homework02(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            try {
                Integer.parseInt(arr.get(i));
                arr.remove(i);
                i--;
            } catch (NumberFormatException e) {
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(657);
        arr.add(234);
        arr.add(8);
        arr.add(9);
        System.out.println(arr);
        homework01(arr);
        System.out.println(arr);

        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.add("0023");
        arr2.add("41");
        arr2.add("-422");
        arr2.add("apple");
        arr2.add("dog");
        arr2.add("0");
        arr2.add("cat");
        arr2.add("-0");
        arr2.add("9999999999999999999999999999999999999");
        System.out.println(arr2);
        homework02(arr2);
        System.out.println(arr2);

    }
}
