package ru.job4j.array;

public class Qwerty {
    public boolean isSort(int[] a) {
        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        return result;
    }
}
