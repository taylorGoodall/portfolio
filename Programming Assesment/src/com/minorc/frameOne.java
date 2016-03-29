/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minorc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Taylor
 */
public class frameOne extends JFrame{
    
    
    public frameOne() {
        
        JFrame frame = new JFrame("Calculator"); // creates the JFrame(a window with decorations)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops the program when window is closed
        frame.setSize(800, 500);
        frame.setLocation(250, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel content = new JPanel(new GridLayout(4, 0)); // the main panel of the JFrame, remembet you cant add content directly to JFrame
        JPanel textarea = new JPanel(new GridLayout(4, 0)); // panel for the text field
        JPanel buttonarea = new JPanel(new GridLayout(5, 2)); // panel for the buttons, GridLayout(int rows, int columns, int horizontal_gap, int vertical_gap)
        JPanel secondbuttonarea = new JPanel(new GridLayout(1, 1, 2, 2)); //  the panel for the bigger bottom buttons
        JPanel label = new JPanel(); // the panel for the text on top
        
        textarea.setBackground(Color.BLUE);
        secondbuttonarea.setBackground(Color.red);
        
        label.setBackground(Color.ORANGE);
       
        
        JTextField[] Test = new JTextField[50];
        
//      JScrollPane scrollPane = new JScrollPane();
//      scrollPane.setViewportView(textarea);
//      
// textarea.add(scrollPane);
        
        JScrollPane scrollPane = new JScrollPane(textarea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        
        
        
        JButton[] options = new JButton[10];
        for(int j = 0; j<10; j++){
            options[j] = new JButton("H");
        }
        for(int i = 0; i<50; i++)
        {
            
         Test[i] = new JTextField(i);
         textarea.add(Test[i]);
         
      
        }
        
        content.add(label);
        content.add(textarea);
        content.add(buttonarea);
        content.add(secondbuttonarea);
        
        
        
        
        
        
        
        
        
        
        frame.getContentPane().add(content); 
        frame.setVisible(true);
        
        
        

        
        
        
    }
    
    
    
    
    
    
}
