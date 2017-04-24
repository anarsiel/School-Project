package com.bot;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Point extends JPanel{
    private static final Color DEFAULT_COLOR = Color.RED;

    public int x, y; // координаты вершины

    static final Random r = new Random();

    public Point() {
        x = r.nextInt();
        y = r.nextInt();
    } // конструктор, создающий точку с рандомными координатами

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    } // конструктор, создающий точку с заданными координатами

    public Point minus(Point a) {
        return new Point(x - a.x, y - a.y);
    } // Метод, возвращающий вектор разности текущего вектора и заданного

    public double len2() {
        return x * x + y * y;
    } // Метод возвращающий квадрат длинны вектора

    public Point copy() {
        return new Point(x, y);
    } // Метод возвращающий копию объекта

    public void paint(Graphics g){
        g.setColor(DEFAULT_COLOR);
        g.fillRect(0,0,3,3);

    }
}
