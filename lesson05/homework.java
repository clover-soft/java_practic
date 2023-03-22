package lesson05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class homework {
    /**
     * Есть тест. Нужно извлечь из него все слова и отсортировать по длине.
     * Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица
     * проснись
     *
     * и
     * ты
     * Еще
     * день друг Пора
     * ..
     */
    static void collectStats(String text) {
        List<String> listStr = Arrays.asList(text.split(" "));
        Map<Integer, List<String>> stats = new HashMap<>();
        listStr.forEach(str -> {
            stats.merge(str.length(), Arrays.asList(str),
                    (oldList, newList) -> Stream.concat(oldList.stream(), newList.stream()) // <--*
                            .collect(Collectors.toList()));
        });
        System.out.println(stats);
    }

    // *--> Не нашел другого способа возврата смерженного листа, кроме как через
    // Stream, отдельную функцию не стал писать
    public static void main(String[] args) {
        String text = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        collectStats(text);
    }

}
