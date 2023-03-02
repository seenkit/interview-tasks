import java.util.HashMap;
import java.util.Map;

/**
 * Посчитать количество вхождений повторяющихся эллементов в массиве и вывести их
 * (не повторяющиеся элементы не выводим). В масиве только положительные целые числа
 * Пример {5, 3, 1, 2, 1, 2, 20, 20, 3, 3}
 * 1 -> 2
 * 2 -> 2
 * 3 -> 3
 * 20 -> 2
 * 5 не выводим
 */

public class CountRepeatArrayVal {
    public static void main(String[] args) {

        //Вариант 1
        int[] array1 = {5, 3, 1, 2, 1, 2, 20, 20, 3, 3};
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int value : array1) {
            map1.merge(value, 1, (oldVal, val) -> oldVal + val);
        }

        map1.forEach((key, val) -> {
            if (val != 1) {
                System.out.println(key + " -> " + val);
            }
        });

        //Вариант 2
        int[] array2 = {5, 3, 1, 2, 1, 2, 20, 20, 3, 3};
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int val : array2) {
            if (!map2.containsKey(val)) {
                map2.put(val, 1);
            } else {
                map2.put(val, map2.get(val) + 1);
            }
        }

        map2.forEach((key, val) -> {
            if (val != 1) {
                System.out.println(key + " -> " + val);
            }
        });

    }
}