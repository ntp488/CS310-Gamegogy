package edu.jsu.mcis.gamegogy.GUI;

import edu.jsu.mcis.gamegogy.*;
import edu.jsu.mcis.gamegogy.GUI.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class GamegogyGUI extends JFrame{

    
    private Database database;
    private Course[] courseObjs;
    private static SelectionPanel selectionPanel;
    private static LeaderboardPanel leaderboardPanel;
    private static InformationPanel infoPanel;

    public GamegogyGUI(Resource resource) {
        database = new Database(resource);
        setPreferredSize(new Dimension(500, 500));
        courseObjs = (Course[])database.getAllCourses();
        this.setTitle("Gamegogy");
        
        infoPanel = new InformationPanel(database);
        leaderboardPanel = new LeaderboardPanel(infoPanel);
        selectionPanel = new SelectionPanel(courseObjs, database, this);
        
        BorderLayout frameLayout = new BorderLayout();
        frameLayout.setVgap(10);
        this.setLayout(frameLayout);
        
        JScrollPane scrollPane = new JScrollPane(leaderboardPanel);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        this.add(selectionPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.SOUTH);
    }
    
    public void setSelectedAssignment(int assignmentIndexSelected,
            CourseGrades grades) {
        leaderboardPanel.refreshPanel(assignmentIndexSelected, grades);
        infoPanel.refreshPanel(assignmentIndexSelected, grades);
    }

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        
        Resource resource;
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(
                    GamegogyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (args.length == 1) {
            if ( (args[0].isEmpty() != true) && (args[0].charAt(args[0].length() - 1) != '/') ) {
                args[0] += '/';
            }
            Connection.setBaseURL(args[0]);
            resource = new JSONResource();
        } else {
            resource = new CSVResource();
        }
        
        GamegogyGUI frame = new GamegogyGUI(new CSVResource());//resource);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
        
    }
}