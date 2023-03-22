package lesson02;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

class mylib {
    public static void main(String[] args) {

    }

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

    /**
     * @param str
     * @throws IOException
     * @throws SecurityException
     */
    static void logEvent(String msg) {
        Logger logger = Logger.getLogger(mylib.class.getName());
        logger.setLevel(Level.INFO);
        try {
            FileHandler fn = new FileHandler("lesson.log", true);
            logger.addHandler(fn);
            SimpleFormatter sFormat = new SimpleFormatter();
            fn.setFormatter(sFormat);
            // Определим имя родительского класса и метода
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StackTraceElement stackTraceElement = stackTrace[2];
            msg = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "=>" + msg;
            logger.info(msg);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}