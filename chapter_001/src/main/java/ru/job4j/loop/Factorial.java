package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1; //переменная для результата (1 потому что н*0=0)
        for (int i = 1; i <= n; i++) { //цикл от 1 до 5
            result *= i; //переменная перемножает каждый тик цикла друг на друга
        }
        return result; //возвращение полученного результата
    }
}
