package ru.job4j.loop;
public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int h = 1; h <= height; h++) {
            for (int w = 1; w <= width; w++) {
                int wh = w + h;
                if (wh % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            System.getProperty("line.separator");
            screen.append(ln);
        }
        return screen.toString();
    }
}