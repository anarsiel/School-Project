package com.problem;

public class Circle {
    Point c; // точка, являющаяся центром окружности
    int r; // радиус окружности

    Circle() {}

    Circle(Point c, int r) {
        this.c = c.copy();
        this.r = r;
    } // конструктор, создающий окружность заданного радиуса с центром в заданной точке

    Circle copy() {
        return new Circle(c, r);
    } // метод, возвращающий копию объекта

    int countPointsInCircle(Point[] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) { // переберем все точки множества
            Point current = arr[i];

            if (current.minus(c).len2() <= r * r) { // проверка, лежит ли данная точка внутри окружности
                cnt++;                              // (сравниваем квадрат расстояния между центром окружности и заданной точкой
            }                                       // с квадратом радиуса)
        }
        return cnt;
    } // метод возвращающий по заданному в виде массива множеству точек, количество точек, лежащих внутри окружности
}
