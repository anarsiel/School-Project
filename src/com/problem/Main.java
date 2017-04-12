package com.problem;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // считываем общее количество точек
        Point[] points = new Point[n]; // массив, в котором будут лежать все наши точки

        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == 0) { // считываем число: 0 - считать с консоли координаты точки; 1 - создать точку с радномными координатами
                int x = sc.nextInt(), y = sc.nextInt();
                points[i] = new Point(x, y);
            } else {
                points[i] = new Point();
            }
        }

        double r = sc.nextDouble(); // считываем радиус окружностей

        ArrayList<int[]> answer = new ArrayList<>();   /* динамический массив, в котором, после выполнения программы будут лежать
                                                            пары точек, таких что окружности заданного радиуса с центрами в этих точках содержат
                                                            внутри себя одинаковое количество точек */

        for (int i = 0; i < n; i++) { // перебираем первую точку из пары
            for (int j = i + 1; j < n; j++) { // перебираем вторую точку из пары начиная с i + 1 индекса, чтобы у нас не было одиковых пар вида {a, b} {b, a}
                Circle circle1 = new Circle(points[i], r); // cоздаем окружности с центрами в этих точках и заданными радиусами
                Circle circle2 = new Circle(points[j], r);

                if (circle1.countPointsInCircle(points) == circle2.countPointsInCircle(points)) { // если обе окружности содержат внутри себя
                    int[] pair = {i + 1, j + 1};                                                  // одинаковое колличество точек, то добавляем их
                    answer.add(pair);                                                             // в массив ответа
                }
            }
        }

        for (int i = 0; i < answer.size(); i++) { // выводим на экран пары номеров вершин
            System.out.println(answer.get(i)[0] + " " + answer.get(i)[1]);
        }
    }
}
