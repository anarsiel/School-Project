package com.problem;

import com.bot.Point;

import java.util.ArrayList;

public class Circle {
    Point c; // точка, являющаяся центром окружности
    int r; // радиус окружности

    public Circle() {}

    public Circle(Point c, int r) {
        this.c = c.copy();
        this.r = r;
    } // конструктор, создающий окружность заданного радиуса с центром в заданной точке

    public Circle copy() {
        return new Circle(c, r);
    } // метод, возвращающий копию объекта

    public int countPointsInCircle(ArrayList<Point> arr) {
        int cnt = 0;

        for (int i = 0; i < arr.size(); i++) { // переберем все точки множества
            Point current = arr.get(i);

            if (current.minus(c).len2() <= r * r) { // проверка, лежит ли данная точка внутри окружности
                cnt++;                              // (сравниваем квадрат расстояния между центром окружности и заданной точкой
            }                                       // с квадратом радиуса)
        }
        return cnt;
    } // метод возвращающий по заданному в виде массива множеству точек, количество точек, лежащих внутри окружности
}
