package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter1 {

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }
    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return рубли
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
    public int euroToRuble(int value) {
        return value * 70;
    }
}