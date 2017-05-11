package com.bot;

import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {
    private Point a, b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public void paint(Graphics g) {
        int color = (int) (Math.random() * 3);

        switch (color) {
            case 0:
                g.setColor(Color.GREEN);
                break;
            case 1:
                g.setColor(Color.BLUE);
                break;
            case 2:
                g.setColor(Color.BLACK);
                break;
        }

        g.drawLine(a.x, a.y, b.x, b.y);
        g.setColor(Color.BLACK);
    }
}
