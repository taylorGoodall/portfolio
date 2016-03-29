/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taylor
 */
import java.util.Scanner;
import java.io.*;
import com.minorc.*;

public class minorc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
int i = 0;
        String text;

        int count = 0;
        String InputFile = "students.txt";
        Scanner scan = new Scanner(new File(InputFile));
//iterate through text file and count Lines in file
        while (scan.hasNextLine()) {
            count++;
            scan.nextLine();
        }
       
//declare arrays
        String[] textt;
        textt = new String[count];
        String[] studentName;
        studentName = new String[count];
        String[] FAN;
        FAN = new String[count];
        float[] scoreOne;
        scoreOne = new float[count];
        float[] scoreTwo;
        scoreTwo = new float[count];
        float[] scoreThree;
        scoreThree = new float[count];
        float[] scoreFour;
        scoreFour = new float[count];
        double[] total;
        total = new double[count];
        
        String[] studentScoreOne;
        String[] studentScoreTwo;
        String[] studentScoreThree;
        String[] studentScoreFour;
        String[] totalGrade;

        studentScoreOne = new String[count];
        studentScoreTwo = new String[count];
        studentScoreThree = new String[count];
        studentScoreFour = new String[count];
        totalGrade = new String[count];
        
        //call classes to read details from text file and to calculate weightings
        get.details(studentName, FAN, scoreOne, scoreTwo, scoreThree, scoreFour);
        get.scoreOneToString(scoreOne, studentScoreOne);
        get.scoreTwoToString(scoreTwo, studentScoreTwo);
        get.scoreThreeToString(scoreThree, studentScoreThree);
        get.scoreFourToString(scoreFour, studentScoreFour);
        get.total(count, total, scoreOne, scoreTwo, scoreThree, scoreFour,totalGrade);
        
        //create object of the framework specifying the arguments passing through
        frame framework;
        framework = new frame(count,studentName, FAN, studentScoreOne, studentScoreTwo, studentScoreThree, studentScoreFour,totalGrade);
       //create a newStudent object of the AddStudent Class
        AddStudent newStudent;
        newStudent = new AddStudent();
        
        
        
        
        //gui mainframe = new gui();
    }
}
