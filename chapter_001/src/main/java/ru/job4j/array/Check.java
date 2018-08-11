package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) { // цикл перебора
            if (data[0] != data[i]) {
                return result;
            }
        }
        return result = true;
    }
}

