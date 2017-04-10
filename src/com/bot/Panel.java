package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Евросеть on 10.04.2017.
 */
public class Panel extends JPanel {
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        g.drawRect(0,0,getWidth()-1,getHeight()-1);
    }
}
