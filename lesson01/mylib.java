package lesson01;

import java.util.Scanner;

class mylib {
    static int inputInt(String prompt) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf(prompt);
        if (iScanner.hasNextInt()) {
            int i = iScanner.nextInt();
            iScanner.close();
            return i;
        } else {
            iScanner.close();
            throw new RuntimeException("Wrong input");
        }
    }

    static String inputStr(String prompt) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf(prompt);
        String s = iScanner.nextLine();
        iScanner.close();
        return s;
    }

}
