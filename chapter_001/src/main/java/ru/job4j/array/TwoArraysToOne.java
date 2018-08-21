package ru.job4j.array;
/*
задача на слияние массивов к контрольным вопрсоам первого блока
 */
public class TwoArraysToOne {
    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ia, ib, ic;

        for (ia = ib = ic = 0; ic < c.length; ++ic) {
            if (ia < a.length) {
                if (ib < b.length) {
                    if (a[ia] < b[ib])
                        c[ic] = a[ia++];
                    else
                        c[ic] = b[ib++];
                } else {
                    c[ic] = a[ia++];
                }
            } else
                c[ic] = b[ib++];
        }

        return c;
    }
}