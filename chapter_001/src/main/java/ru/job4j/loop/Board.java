package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int h = 1; h <= height; h++) {
            for (int w = 1; w <= width; w++) {
                int wh = w + h;
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if (wh % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            System.getProperty("line.separator"); // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}