package com.minorc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author Taylor
 */
public class AddStudent  extends JFrame{
//    
    //declation of variables
    private static final int WIDTH = 800;
    private static final int HEIGHT = 100;
    
    
    public AddStudent () {
        //title of the window
        setTitle("Add New Student");
       Container panel = getContentPane();
        //specify layout manager
        panel.setLayout(new GridLayout(2,10));
        
        
        //create the Objects to be added to the GUI
        JTextField studentName;
        studentName = new JTextField("Student Name");
        JTextPane sName;
        sName = new JTextPane();
        sName.setText(" Student Name");
        JTextPane sFan;
        sFan = new JTextPane();
        sFan.setText(" Student Fan");
        JTextPane sScoreOne;
        sScoreOne = new JTextPane();
        sScoreOne.setText(" Score One");
        
        JTextPane sScoreTwo;
        sScoreTwo = new JTextPane();
        sScoreTwo.setText(" Score Two");
        
        JTextPane sScoreThree;
        sScoreThree = new JTextPane();
        sScoreThree.setText(" Score Three");
        
        JTextPane sScoreFour;
        sScoreFour = new JTextPane();
        sScoreFour.setText(" Score Four");
        
        JTextField fan;
        
        fan = new JTextField("FAN");
        JTextField scoreOne;
        scoreOne = new JTextField("Score One");
        JTextField scoreTwo;
        scoreTwo = new JTextField("Score Two");
        JTextField scoreThree;
        scoreThree = new JTextField("Scoree Three");
        JTextField scoreFour;
        scoreFour = new JTextField("Score Four");
        
        //add the objects to the GUI
        panel.add(sName);
        panel.add(sFan);
        panel.add(sScoreOne);
        panel.add(sScoreTwo);
        panel.add(sScoreThree);
        panel.add(sScoreFour);
        panel.add(studentName);
        panel.add(fan);
        panel.add(scoreOne);
        panel.add(scoreTwo);
        panel.add(scoreThree);
        panel.add(scoreFour);
        
        
        
        
        
        //sets location and size and default close operation (only closes this window)
       setLocation(250,580);
       setSize(WIDTH,HEIGHT);
       setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setVisible(true);
     
        
    }
    
   
    
    
    
}
