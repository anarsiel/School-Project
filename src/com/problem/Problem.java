package com.problem;
import com.bot.Point;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem {


    public static ArrayList<Point[]> main2(ArrayList<Point> points, int r) {
        int n = points.size();

        ArrayList<Point[]> answer = new ArrayList<>();   /* динамический массив, в котором, после выполнения программы будут лежать
                                                            пары точек, таких что окружности заданного радиуса с центрами в этих точках содержат
                                                            внутри себя одинаковое количество точек */

        for (int i = 0; i < n; i++) { // перебираем первую точку из пары
            for (int j = i + 1; j < n; j++) { // перебираем вторую точку из пары начиная с i + 1 индекса, чтобы у нас не было одиковых пар вида {a, b} {b, a}
                Circle circle1 = new Circle(points.get(i), r); // cоздаем окружности с центрами в этих точках и заданными радиусами
                Circle circle2 = new Circle(points.get(j), r);

                if (circle1.countPointsInCircle(points) == circle2.countPointsInCircle(points)) { // если обе окружности содержат внутри себя
                                                                                                    // одинаковое колличество точек, то добавляем их
                    Point[] to_add = new Point[2];
                    to_add[0] = points.get(i);
                    to_add[1] = points.get(j);
                    answer.add(to_add);
                    // в массив ответа
                }
            }
        }

        return answer;
    }
}
