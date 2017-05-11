package com.bot;

import com.problem.Problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.exit;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Line> lines = new ArrayList<Line>();

    public static void createGUI() {
        final JFrame frame = new JFrame("Best program ever");
        frame.setPreferredSize(new Dimension(800, 800));
        JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(260, 700));

        final Panel pointpane = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

        JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
        addPointwithCoords.setBounds(2, 2, 300, 25); //
        butPanel.add(addPointwithCoords);

        JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
        addRandomPoints.setBounds(2, 50, 300, 25);
        butPanel.add(addRandomPoints);

        JLabel X = new JLabel("X:");
        X.setBounds(2, 25, 15, 25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45, 25, 15, 25);
        butPanel.add(Y);
        JLabel R = new JLabel("R:");
        R.setBounds(88, 25, 15, 25);
        butPanel.add(R);
        JLabel N = new JLabel("N:");
        N.setBounds(2, 70, 30, 25);
        butPanel.add(N);

        final JTextField x = new JTextField();
        x.setBounds(17, 25, 25, 25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60, 25, 25, 25);
        butPanel.add(y);
        final JTextField r = new JTextField();
        r.setBounds(103, 25, 25, 25);
        butPanel.add(r);
        final JTextField n = new JTextField();
        n.setBounds(17, 70, 25, 25);
        butPanel.add(n);

        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2, 100, 160, 40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("") ? Integer.parseInt(x.getText()) : 0);
                int Y = (!y.getText().equals("") ? Integer.parseInt(y.getText()) : 0);
                int N = (!n.getText().equals("") ? Integer.parseInt(n.getText()) : 0);

                if ((X > 0) && (Y > 0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x, b.y, b.x + 20, b.y + 20);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                } else {
                    if (N > 0) {
                        for (int i = 0; i < N; i++) {
                            Random random = new Random();
                            int x = random.nextInt((frame.getWidth() - 260));
                            int y = random.nextInt(frame.getHeight());
                            Point b = new Point(x, y);
                            points.add(b);
                            b.setBounds(b.x, b.y, b.x  + 20, b.y  + 20);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });

        JButton button5 = new JButton("Взять данные из файла");
        button5.setBounds(2, 150, 160, 40);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Point[]> answer;

                try {
                    answer = Problem.main2(points, 0, true);
                } catch (FileNotFoundException e1) {
                    System.out.println(e1);
                    return;
                }

                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);

                    }
                }
                for (int i = 0; i < lines.size(); i++) {
                    while (lines.size() > 0) {
                        int index = lines.size() - 1;
                        Line line = lines.remove(index);
                        pointpane.remove(line);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
                pointpane.repaint();
                pointpane.revalidate();


                for (int i = 0; i < answer.size(); i++) {
                    points.add(answer.get(i)[0]);
                    points.add(answer.get(i)[1]);
                }
                for (int i = 0; i < points.size(); i++) {
                    Point b = points.get(i);
                    b.setBounds(b.x, b.y, b.x  + 20, b.y  + 20);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }

                for (int i = 0; i < answer.size(); i++) {
                    Point a = answer.get(i)[0], b = answer.get(i)[1];

                    Line pair = new Line(a, b);
                    lines.add(pair);
                    pointpane.add(pair);
                    pair.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                    pointpane.revalidate();
                    pointpane.repaint();
                }
            }
        });

        JButton button2 = new JButton("очистить");
        button2.setBounds(2, 200, 160, 40);
        butPanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
                for (int i = 0; i < lines.size(); i++) {
                    while (lines.size() > 0) {
                        int index = lines.size() - 1;
                        Line line = lines.remove(index);
                        pointpane.remove(line);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
            }
        });

        JButton button3 = new JButton("Запустить");
        button3.setBounds(2, 250, 160, 40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int R = (!r.getText().equals("") ? Integer.parseInt(r.getText()) : 0);
                ArrayList<Point[]> answer = null;
                try {
                    answer = Problem.main2(points, R, false);
                } catch (FileNotFoundException e1) {
                    System.out.println(e1);
                    return;
                }
                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);

                    }
                }
                for (int i = 0; i < lines.size(); i++) {
                    while (lines.size() > 0) {
                        int index = lines.size() - 1;
                        Line line = lines.remove(index);
                        pointpane.remove(line);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
                pointpane.repaint();
                pointpane.revalidate();


                for (int i = 0; i < answer.size(); i++) {
                    points.add(answer.get(i)[0]);
                    points.add(answer.get(i)[1]);
                }
                for (int i = 0; i < points.size(); i++) {
                    Point b = points.get(i);
                    b.setBounds(b.x, b.y, b.x + 20, b.y + 20);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }

                for (int i = 0; i < answer.size(); i++) {
                    Point a = answer.get(i)[0], b = answer.get(i)[1];

                    Line pair = new Line(a, b);
                    lines.add(pair);
                    pointpane.add(pair);
                    pair.setBounds(2, 2, frame.getWidth(), frame.getHeight());
                    pointpane.revalidate();
                    pointpane.repaint();
                }
            }
        });

        JButton button4 = new JButton("Завершить");
        button4.setBounds(2, 300, 160, 40);
        butPanel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });


        panel.add(pointpane, BorderLayout.CENTER);
        panel.add(butPanel, BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
