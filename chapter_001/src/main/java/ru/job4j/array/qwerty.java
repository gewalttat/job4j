package ru.job4j.array;

public class qwerty {
    /*
    для сортировки применим стандартный метод пузырьком
     */
    public int[] sort(int mass[]) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < i; j++) {
                if (mass[j] > mass[j + 1]) {
                    int tmp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = tmp;
                }
            }
        }
        return mass;
    }
}