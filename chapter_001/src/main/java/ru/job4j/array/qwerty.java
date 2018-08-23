package ru.job4j.array;

public class qwerty {
    public boolean isSort(int[] a) {
        boolean result;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            } else if (a[i] < a[i + 1]) {
                result = false;
            }
        }
        return true;
    }
}