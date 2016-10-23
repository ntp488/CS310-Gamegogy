package edu.jsu.mcis.gamegogy;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderboardPanel extends JPanel{
    private ArrayList<Bar> barArray = new ArrayList();
    private Dimension dim = this.getSize();
    
    public LeaderboardPanel() {
        
        Bar b = new Bar(dim, 100, 85);
        Bar b2 = new Bar(dim, 100, 60);
        Bar b3 = new Bar(dim, 100, 20);
        
        barArray.add(b);
        barArray.add(b2);
        barArray.add(b3);
        
        for (Bar bar : barArray) {
            add(bar);
            JLabel barlabel = new JLabel();
            barlabel.setText("Bloop");
            barlabel.setVerticalAlignment(JLabel.TOP);
            add(barlabel);
        }
        
        GridLayout grid = new GridLayout(0,2);
        this.setLayout(grid);
        
//        add(b);
//        add(b2);
//        add(b3);
    }
    
    public static void refreshPanel(int assignmentIndexSelected) {
        
    }
}