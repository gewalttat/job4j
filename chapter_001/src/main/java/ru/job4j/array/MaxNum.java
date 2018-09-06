package ru.job4j.array;

/*
since 02.09
@count = переменная, отображающая количество элементов, сравниваемая с @sequence на количество элементов
если больше, то передаем ее значение в @sequence и выводим последовательность
 */
public class MaxNum {
    public int maxNum(int[] a) {
        int count = 1, sequence = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > sequence) {
                sequence = count;
            }
        }
        return sequence;
    }
}