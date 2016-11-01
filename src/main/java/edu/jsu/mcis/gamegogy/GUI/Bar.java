package edu.jsu.mcis.gamegogy.GUI;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class Bar extends JComponent implements ComponentListener {
    public Color barColor = Color.green;
    public float width, height = 20,
            pointsPossible, score,
            x = 20, y = 0;
    public String id;
    
    public Bar(float totalPointsPossible, float score, String studentID) {
        this.id = studentID;
        pointsPossible = totalPointsPossible;
        this.score = score;
        calculateWidth(pointsPossible, score);
        addComponentListener(this);
        this.setPreferredSize(new Dimension(320,25));
    }
    
    public void calculateWidth(float pointsPossible, float points) {
        this.width = (points / pointsPossible) * (this.getWidth() * .8f);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        calculateWidth(pointsPossible, score);
        g2d.setColor(barColor);
        g2d.fillRect((int)x,(int)y,(int)this.width,(int)this.height);
        g2d.setColor(Color.BLACK);
        g2d.draw(new Rectangle2D.Double(x,y,this.width,this.height));
        g2d.setFont(new Font("SansSerif", Font.BOLD, 14));
        System.out.println();
        g2d.drawString(Float.toString(score),
                super.getWidth() - 40,
                this.height - 5);
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        calculateWidth(pointsPossible, score);
    }
    @Override
    public void componentMoved(ComponentEvent e) {
    }
    @Override
    public void componentShown(ComponentEvent e) {
    }
    @Override
    public void componentHidden(ComponentEvent e) {
    }
    
}
