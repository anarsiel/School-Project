package com.problem;
import java.util.Random;

public class Point {
    int x, y; // координаты вершины

    static final Random r = new Random();

    Point() {
        x = r.nextInt();
        y = r.nextInt();
    } // конструктор, создающий точку с рандомными координатами

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    } // конструктор, создающий точку с заданными координатами

    Point minus(Point a) {
        return new Point(x - a.x, y - a.y);
    } // Метод, возвращающий вектор разности текущего вектора и заданного

    double len2() {
        return x * x + y * y;
    } // Метод возвращающий квадрат длинны вектора

    Point copy() {
        return new Point(x, y);
    } // Метод возвращающий копию объекта
}
