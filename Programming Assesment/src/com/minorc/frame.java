/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minorc;

/**
 *
 * @author Taylor
 */
//import classes that are needed
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



public class frame extends JFrame{
    
  //declaration of variables  
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    
    //arguments that are passed through and the data types
      public frame(int count,String sname[],String fan[],
            String studentScoreOne[], String studentScoreTwo[], String studentScoreThree[], String studentScoreFour[],
            String[] totalGrade) {

       //set Title and create the Pane
          setTitle("Student Information System");
       Container pane = getContentPane();
       
     
      
       
     //set the layout to a GridLayout
      pane.setLayout(new GridLayout(12,7));
       
      
       
       //declare Object arrays to store the GUI Objects
       JTextField[] Name  = new JTextField[count];
       JTextField[] sfan = new JTextField[count];
       JTextField[] one = new JTextField[count];
       JTextField[] two = new JTextField[count];
       JTextField[] three = new JTextField[count];
       JTextField[] four = new JTextField[count];
       JLabel[] totalScore = new JLabel[count];
       JLabel title_name = new JLabel("Student Name");
       JLabel title_fan = new JLabel("FAN");
       JLabel title_score1 = new JLabel("Score One");
       JLabel title_score2 = new JLabel("Score Two");
       JLabel title_score3 = new JLabel("Score Three");
       JLabel title_score4 = new JLabel("Score Four");
       //JButton space = new JButton("Total Score");
       
       //add the headings to the GUI
       pane.add(title_name);
       pane.add(title_fan);
       pane.add(title_score1);
       pane.add(title_score2);
       pane.add(title_score3);
       pane.add(title_score4);
      
     //loop through to store the values from the text files
       //and store them as values in the object array
       for(int i = 0; i<count; i++){
           Name[i] = new JTextField(sname[i]);
           //pane.add(sname[i], BorderLayout.PAGE_START);
                   //add(sname[i], BorderLayout.SOUTH);        

           sfan[i] = new JTextField(fan[i]);
            one[i] = new JTextField(studentScoreOne[i]);
            two[i] = new JTextField(studentScoreTwo[i]);
          three[i] = new JTextField(studentScoreThree[i]);
          four[i] = new JTextField(studentScoreFour[i]);
         totalScore[i] = new JLabel(totalGrade[i]);
         // totalScore[i] = new JLabel(total[i]);
           
           //Name[i].setFont(new Font("Serif",Font.BOLD,20));
          
           
         //add the Object arrays to the GUI
           pane.add(Name[i],BorderLayout.NORTH);
           pane.add(sfan[i],BorderLayout.SOUTH);
            pane.add(one[i],BorderLayout.EAST);
            pane.add(two[i],BorderLayout.WEST);
          pane.add(three[i],BorderLayout.CENTER);
           pane.add(four[i],BorderLayout.PAGE_END);
          //pane.add(totalScore[i]);
           
              
                   
                   
       }
  //set the width and the location of where the frame apears
       //setDefault close operation (Closes program when the 'X' is clicked
       setLocation(250,70);
       setSize(WIDTH,HEIGHT);
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);

        
    }
    
    
    
    
    
}
