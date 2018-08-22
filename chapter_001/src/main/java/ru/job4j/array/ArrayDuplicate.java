package ru.job4j.array;
import java.util.Arrays;
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int arrlength = array.length;
        for (int i = 0; i < arrlength; i++) {
            for (int j = i + 1; j < arrlength; j++) {
                if (array[i] == array[j]) {
                    array[i] = array[1 - arrlength];
                    arrlength--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, arrlength);
    }
}
