package ru.job4j.array;

public class Qwerty {
    public boolean isSort(int[] a) {
        boolean result;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            } else {
                for (int j = 0; j < a.length - 1; j++) {
                    if (a[i] < a[j + 1]) {
                        result = false;
                    }
                }
            }
        }
        return true;
    }
}