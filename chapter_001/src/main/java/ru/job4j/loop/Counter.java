package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int result = 0;
        int var = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                var = i;
            }
            result += var;
            var = 0;
        }
        return result;
    }
}