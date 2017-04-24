package com.bot;

import com.problem.Circle;
import com.problem.Problem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Best program ever");
        frame.setPreferredSize(new Dimension(700,700));
        JPanel panel = new JPanel(new BorderLayout());
        Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));

        final Panel pointpane = new Panel(); // ?
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

        JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
        addPointwithCoords.setBounds(2,2,300,25); //
        butPanel.add(addPointwithCoords);

        JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
        addRandomPoints.setBounds(2,50,300,25);
        butPanel.add(addRandomPoints);

        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        butPanel.add(Y);
        JLabel R = new JLabel("R:");
        R.setBounds(88,25,15,25);
        butPanel.add(R);
        JLabel N = new JLabel("N:");
        N.setBounds(2,70,30,25);
        butPanel.add(N);

        final JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        butPanel.add(y);
        final JTextField r = new JTextField();
        r.setBounds(103,25, 25,25);
        butPanel.add(r);
        final JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        butPanel.add(n);

        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,160,40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("")?Integer.parseInt(x.getText()):0);
                int Y= (!y.getText().equals("")?Integer.parseInt(y.getText()):0);
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);

                if ((X>0)&&(Y>0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x, b.y, b.x + 10, b.y + 10);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Point b = new Point((int)(Math.random()*(frame.getWidth()-250)), (int)(Math.random()*frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x,b.y,b.x+3,b.y+3);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });

        JButton button2 = new JButton("очистить");
        button2.setBounds(2,150,160,40);
        butPanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
            }
        });

        JButton button3 = new JButton("Запустить");
        button3.setBounds(2, 200, 160, 40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int R = (!r.getText().equals("") ? Integer.parseInt(r.getText()) : 0);
                System.out.println("started main2");
                ArrayList<Point[]> answer = Problem.main2(points, R);
                System.out.println("finished main2");
                System.out.println("started erasing points");
                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);

                    }
                }
                pointpane.repaint();
                pointpane.revalidate();


                System.out.println("finished erasing points");
                for (int i = 0; i < answer.size(); i++) {
                    points.add(answer.get(i)[0]);
                    points.add(answer.get(i)[1]);
                }
                System.out.println("started printing points");
                for (int i = 0; i < points.size(); i++) {
                    Point b = points.get(i);
                    b.setBounds(b.x, b.y, b.x + 3, b.y + 3);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                System.out.println("finished printing points");
                System.out.println("started making pairs");
                for (int i = 0; i < answer.size(); i++) {
                    Point a = answer.get(i)[0], b = answer.get(i)[1];


                }
            }
        });

        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
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
