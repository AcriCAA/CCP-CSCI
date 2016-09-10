/*
 * Factorial.java
 * Computer Science 112, Spring 2014
 * Last edited Jan. 20, 2014 by C. Herbert
 * 
 * This code contains three methods for calcualting factorials
 * Theffirst two are iterative; the third method is recursive.
 */
package factorial;
import java.util.Scanner;

 
public class Factorial {

    public static void main(String[] args) {

        long n; //target integer whose factorial will be determined
        long i;  // a loop counter

        // set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);

        // startup message to use
        System.out.println("This program will calculate the facorial of a number.");

        // input n -- prompt & capture 
        System.out.println("\nEnter a positive longeger n:");
        n = kb.nextInt();

        System.out.println("\n" + n + " factorial (up  ) is : " + factorialup(n));
        System.out.println(n + " factorial (down) is : " + factorialdown(n));
        System.out.println(n + " factorial (rec.) is : " + factorialrecursive(n));


    } // main

    //a method for claculating a factiroal iterating upward 
    static long factorialup(long n) {
        
        long factorial = 1;
        
        for (long i = 2; i <= n; i++) 
            factorial = factorial * i;
        
        return factorial;
    } // end factorial()


// a method to calculate n factorial iterating downward
    static long factorialdown(long n) {

        long factorial = (n);

        for (long i = (n-1); i > 0 ; i--) 
            factorial = factorial * i;

        return factorial;
    } // end factorialdown()

    // a method to calculate n factorial recursively   
    static long factorialrecursive(long n) {

        if (n == 1) 
            return 1;
        else
            return n * factorialrecursive(n-1);
                
    } // end factorialdown()    
    
}  // end class Factorial



