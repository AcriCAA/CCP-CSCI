/* RecursiveCount.Java
 * Computer Science 112, Spring 2014
 * Last edited Jan. 20, 2014 by C. Herbert
 * 
 * This code is a simple recursive program for printing the integers from 
 * 1 to the highest integer, Integer.MAX_VALUE
 * 
 * It is intended as a comparison to the iterative program
 * IterativeCount, which does the same thing iteratively.
 * 
 * You should run the two programs and compare results.
 * This recursive program will crash and generate 
 *    'Exception in thread "main" java.lang.StackOverflowError'
 * followed by many other errors as it backs out of the recursion.
 * 
 * Scroll up through the output to find the first error message.
 *
 * This illustrates the problem with recursion overhead, and shows that 
 * recursive techniques such as merge sort and quick sort are executing a
 * "depth first" recursion, otherwise they  would run out of stack space 
 * with large lists, but they do not.
 * 
 */
package recursivecount;

public class RecursiveCount {

    public static void main(String[] args) {
 
 	// start the recursion
       reCount(1);

    }  // end main()

    public static void reCount(int count) {
        System.out.println(count);

 	// Integer.MAX_VALUE is the highest possible int value
        if (count < Integer.MAX_VALUE) 
            reCount(count + 1);

    } // end (recount()
}  // end class RecursiveCount
