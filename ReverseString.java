/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Taylor
 */
import java.util.Scanner;
public class ReverseString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanInput = new Scanner(System.in);
        String input;
        
        System.out.print("Enter A string to have it reversed: ");
        input = scanInput.next();
    String reverse =    new StringBuilder(input).reverse().toString();
    System.out.println("Reversed String Result: " +reverse);
    int numberOfWords = reverse.length();
    System.out.print("Number of words in String " +numberOfWords +"\n");
      
        
     
        
      //  System.out.println(input);
       
    }
}
