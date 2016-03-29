/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minorc;

/**
 *
 * @author Taylor
 */
import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class get {
public static int i = 0;
public static String[] details(String[] studentName, String[] FAN, float[] scoreOne, float[] scoreTwo
            ,float[] scoreThree, float[] scoreFour) throws IOException {
    
      
        //set up variables for scanning text file 
        String inputFile = "students.txt";
        Scanner scan = new Scanner(new File(inputFile));
        i = 0;
        
        while(scan.hasNext()){
            String NextWord = scan.nextLine();
            Scanner sc = new Scanner(NextWord);
            sc.useDelimiter(",");
            
            //store values in text file into the arrays
            studentName[i] = sc.next();
            FAN[i] = sc.next();
            // float StudentScore1 = sc.nextFloat();
            scoreOne[i] = sc.nextFloat();
            scoreTwo[i] = sc.nextFloat();
            scoreThree[i] = sc.nextFloat();
            scoreFour[i] = sc.nextFloat();
                          i++;
        }
        
        return null;
        
                }
    //method to change the Float values to a String value so they can be displayed in GUI
    public static String[] scoreOneToString(float[] scoreOne, String[] studentScoreOne) {
        for(i = 0; i<scoreOne.length; i++){
            studentScoreOne[i] = String.valueOf(scoreOne[i]);
        }
        return studentScoreOne;
        
        
    }
    //method to change the Float values to a String value so they can be displayed in GUI
    public static String[] scoreTwoToString(float[] scoreTwo, String[] studentScoreTwo){
        for(i = 0; i<scoreTwo.length; i++){
            studentScoreTwo[i] = String.valueOf(scoreTwo[i]);
        }
        return studentScoreTwo;
       
    }
    //method to change the Float values to a String value so they can be displayed in GUI
    public static String[] scoreThreeToString(float[] scoreThree, String[] studentScoreThree){
        for(i = 0; i<scoreThree.length; i++){
            studentScoreThree[i] = String.valueOf(scoreThree[i]);
        }
        return studentScoreThree;
    }
    //method to change the Float values to a String value so they can be displayed in GUI
    public static String[] scoreFourToString(float[] scoreFour, String[] studentScoreFour){
        for(i = 0; i<scoreFour.length; i++){
            studentScoreFour[i] = String.valueOf(scoreFour[i]);
        }
       return studentScoreFour;
    }
    //method to calculate the total marks of each student
    //round totals by 2 decimal points
    //store total values into a string array so they can be displayed in GUI
    public static String[] total(int count,double[] total, float[] scoreOne, float[] scoreTwo, float[] scoreThree
            ,float[] scoreFour,String[] totalGrade){
        
        for(i = 0; i<count; i++){
            //calculate totals using the weightings provided
            total[i] = total[i] = (scoreOne[i] * 0.1) + (scoreTwo[i] * 0.4) + 
                    (scoreThree[i] * 0.2) + (scoreFour[i] * 0.3);
       //need to lookup how to filter JTEXTFIELD values      
  //Format the totals to two decimal places          
int decimalPlaces = 2;
BigDecimal bd = new BigDecimal(total[i]);

// setScale is immutable

bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
//assign value formated to the array
total[i] = bd.doubleValue();
//store totals in a string Array 
//could not get Totals to printed out as ints etc 
            totalGrade[i] = String.valueOf(total[i]);
            //totalGrade[i] = df.format(totalGrade[i]);
        }
        
        return totalGrade;
    }
    
    
}
