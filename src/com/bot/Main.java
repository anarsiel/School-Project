package com.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static Panel pointpane   = new Panel();

    private static ArrayList<Point> points = new ArrayList<Point>();
    static Scanner in = new Scanner(System.in);
    static JButton button1;
    static  JFrame frame = new JFrame("Testframe");


    // задачать кнопки
    static void setButtons(){
        JPanel butPanel = new JPanel();
        frame.getContentPane().add(butPanel, BorderLayout.NORTH);
        button1 = new JButton("Добавить точку");
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pointpane.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        pointpane.posX = e.getX();
                        pointpane.posY = e.getY();
                    }
                });
                Point b = new Point(pointpane.posX,pointpane.posY);
                b.setBounds(b.x,b.y,b.x+3,b.y+3);
                pointpane.add(b);
                pointpane.revalidate();
                pointpane.repaint();
            }
        });
    }



    public static void createGUI() {
	    frame.setPreferredSize(new Dimension(700,700));

	    pointpane.setLayout(null);
	    JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
	    addPointwithCoords.setBounds(2,2,300,25);
	    frame.add(addPointwithCoords);
	    JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
	    addRandomPoints.setBounds(2,50,300,25);
	    frame.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        frame.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        frame.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2,70,30,25);
        frame.add(N);
        JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        frame.add(x);
        JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        frame.add(y);
        JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        frame.add(n);
        pointpane.setSize(new Dimension(500,500));
        frame.getContentPane().add(pointpane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
                setButtons();
            }
        });
    }
}
