package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        /*
        делаем переменную равной длине массива для цикла
        al = array.length
         */
        int al = array.length;
        /*
        задаем цикл на два индекса для нахождения дублей
        цикл для i - основной, j - придаточный для дублей
        */
        for (int i = 0; i < al; i++) {
            for (int j = i + 1; j < al; j++)
                /*
                если i=j (дубликат найден), то отсылаем его в конец массива
                и уменьшаем значения al и j для корректировки
                 */
            if (array[i] == array[j]) {
                array[i] = array[al-1];
                al--;
                j--;
            }
        }
        /*
        возвращаем массив с обрезкой лишних элементов
         */
        return Arrays.copyOf(array, al);
    }
}
