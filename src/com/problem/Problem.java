package com.problem;

import com.bot.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem {

    private static int[] p; // массив предков, необходимый для СНМ

    private static int get(int vertex) { // Система Непересекающихся Множеств - СНМ
        if (p[vertex] == vertex)
            return vertex;
        p[vertex] = get(p[vertex]);
        return p[vertex];
    }

    private static void merge(int vertex, int urtex) {
        vertex = get(vertex);
        urtex = get(urtex);
        p[vertex] = urtex;
    }

    public static ArrayList<Point[]> main2(ArrayList<Point> points, int r, boolean need_input_from_file) throws FileNotFoundException {
        int n;
        if (need_input_from_file) { // считывание дополнительных данных из файла, если необходимо
            try (Scanner in = new Scanner(new File("input.txt"))) {
                n = in.nextInt();
                r = in.nextInt();
                for (int i = 0 ; i < n; i++) {
                    points.add(new Point(in.nextInt(), in.nextInt()));
                }
                in.close();
            }
        }

        n = points.size();
        ArrayList<Point[]> answer = new ArrayList<>();   /* динамический массив, в котором, после выполнения программы будут лежать
                                                        пары точек, удовлетворяющие условию */

        ArrayList<int[]> edges = new ArrayList<>(); // Динамический массив ребер графа, где ребро существует только между 2 точками, удоблетворяющими условию

        p = new int[n]; // заполнение массива предков
        for (int i = 0; i < n; i++) // изначально каждая вершина является множеством, поэтому она же и является корнем этого множества
            p[i] = i;

        for (int i = 0; i < n; i++) { // перебираем первую точку из пары
            for (int j = i + 1; j < n; j++) { // перебираем вторую точку из пары начиная с i + 1 индекса, чтобы у нас не было одиковых пар вида {a, b} {b, a}
                Circle circle1 = new Circle(points.get(i), r); // cоздаем окружности с центрами в этих точках и заданными радиусами
                Circle circle2 = new Circle(points.get(j), r);

                if (circle1.countPointsInCircle(points) == circle2.countPointsInCircle(points)) { // если обе окружности содержат внутри себя
                    edges.add(new int[]{i, j});                                                   // одинаковое колличество точек, то добавляем ребро в граф
                }
            }
        }
        Collections.shuffle(edges);

        // строим остов графа при помощи СНМ
        for (int i = 0; i < edges.size(); i++) { // Перебираем все ребра
            int vertex = edges.get(i)[0];
            int urtex = edges.get(i)[1];
            if (get(vertex) != get(urtex)) { // Если две точки данного ребра не лежат в одном множестве, то объединяем эти 2 множества
                answer.add(new Point[]{points.get(vertex), points.get(urtex)}); // и добавляем ребро в остов
                merge(vertex, urtex);
            }
        }
        return answer;
    }
}
