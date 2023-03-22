package lesson02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class homeworks {

    /**
     * Метод для построения строки
     * Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет
     * строку длины N, которая
     * состоит из чередующихся символов c1 и c2, начиная с c1. (6, 'a', 'b') ->
     * "ababab"
     * 
     * @param n  количество повторов (обязательно четное)
     * @param c1 первый символ
     * @param c2 второй символ
     * @return Возарвщает сгенерированную строку
     */
    static String buildString(int n, char c1, char c2) {
        String result = "";
        if (n <= 0 || n % 2 > 0)
            throw new UnsupportedOperationException("Ошибка входных параметров метода buildString");
        for (int i = 0; i < n / 2; i++) {
            result += String.valueOf(c1) + String.valueOf(c2);
        }
        return result;
    }

    /**
     * Метод записывает массив строк в файл
     * Создать файл с названием file.txt. Если файл уже есть, то создавать не надо
     * Записать в него Слово "TEXT" 100 раз
     * 
     * @param fileName Имя файла
     * @param words    Массив строк
     */
    static void createFile01(String fileName, List<String> words) {
        try {
            Path file = Paths.get(fileName);
            Files.write(file, words, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод список слов побайтово, можно разделить символом перевода строки
     * Создать файл с названием file.txt. Если файл уже есть, то создавать не надо
     * Записать в него Слово "TEXT" 100 раз
     * 
     * @param filename Имя файла
     * @param words    Массив строк
     * @param sep      разделитель строк, например "/" или ""
     */
    static void createFile02(String filename, List<String> words, String sep) {
        String text = "";
        for (String string : words) {
            text += string + sep;
        }
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        try {
            FileOutputStream fn = new FileOutputStream(filename, true);
            BufferedOutputStream buf = new BufferedOutputStream(fn);
            buf.write(bytes, 0, bytes.length);
            buf.flush();
            buf.close();
            fn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        System.out.println(buildString(9, 'a', 'b'));

        List<String> words = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            words.add("TEXT");
        }
        // createFile01("file.txt", words);
        createFile02("file.txt", words, "\n");
    }
}
