/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome.pkg3;

import java.util.Scanner;

/**
 *
 * @author Coles Laptop
 */
public class Palindrome3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Cole Mollica, Febuary 120th 2018, to revese a phrase and to see if it is a palendrome
        
        //asking for input from the user
        System.out.println("Enter A Phrase to check if it is a palendrome (Dont not use caps)");
      
        //setting up input
        Scanner input = new Scanner(System.in);
             
        //declaring the "s" variable as a string
        String s="";
        //getting input    
        s=input.nextLine();
             
        //removing the spaces from the s variable and assigning this string value to the s2 variable
            String s2=s.replaceAll("\\s+", "");
            
            //reversing s2 and assigning it to the string variable "reverse".
               String reverse = new StringBuffer(s2).reverse().toString();
             
               //comparing the s2 varialbe to the reverse string and if they equal it is a palindrome.
               if (s2.equals(reverse)) {
        System.out.println("The Phrase " + s + " is a palendrome");
             }else{
        System.out.println("The Phrase is not a palindrome");
    }
             
             
    }
    
}
