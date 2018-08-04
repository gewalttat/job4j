package ru.job4j.condition;

public class Point {
    private int me;
    private int y;

    public Point(int x, int y) {
        this.me = x;
        this.y = y;
    }

    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.me - that.me, 2)+Math.pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.me);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.me);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между мной и точкой В = " + result);
    }
}
