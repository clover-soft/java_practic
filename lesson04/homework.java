// Реализовать консольное приложение, которое:

// 1. Принимает от пользователя строку вида text~num

// 1. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
// 2. Если введено print~num, выводит строку из позиции num в связном списке.
// 3. Если введено exit, завершаем программу

// Пример:
// string~4
// num~3
// print~3
// > num
// print~4
// > string
// my_value~1
// print~1
// > my_value

package lesson04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homework {
    static List<String> myDict = new ArrayList<String>();

    static void addItem(String str, Integer index) {
        if (index < 0)
            throw new NumberFormatException("Negative index");
        while (myDict.size() < index + 1)
            myDict.add(null);
        myDict.set(index, str);
    }

    static String getItem(Integer index) {
        if (index > 0 && myDict.size() > index && myDict.get(index) != null) {
            return myDict.get(index);
        } else {
            throw new NumberFormatException("Wrong index");
        }
    }

    public static void main(String[] args) {

        String cmd = "";
        Scanner iScanner = new Scanner(System.in);
        while (!cmd.equals("exit")) {
            cmd = iScanner.nextLine();
            String[] cmdArr = cmd.split("~");
            if (cmdArr.length == 2) {
                try {
                    Integer index = Integer.parseInt(cmdArr[1]);
                    if (cmdArr[0].equals("print")) {
                        System.out.println(getItem(index));
                    } else {
                        addItem(cmdArr[0], index);
                    }

                } catch (NumberFormatException e) {
                    System.out.println(String.format("ERR:%s", e.getMessage()));
                }
            }
        }
        iScanner.close();
    }
}
