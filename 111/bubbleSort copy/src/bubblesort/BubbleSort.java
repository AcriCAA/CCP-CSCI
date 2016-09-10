/* Corey Acri
 * CSCI 112 
 * Final Project: Comparison of Sorting Algorithms
 *
 * This program compares 
 *
 * It also demonstrates modular development and passing an array as a parameter
 *
 */

package bubblesort;

public class BubbleSort 
{

    public static void main(String[] args) 
    {
       for (int k = 1; k<= 1; k++)
        {
        int size = 100;     // change this number to change the size of the random array
        int[] a = new int[size];
        int [] b = new int[size];
        int [] c = new int[size];
        int [] d = new int[size];
      

        // fill the arrays with random integers
        for (int i = 0; i< a.length; i++) {
            a[i] = (int)(Math.random()*100 +1);
            b[i] = a[i];
            c[i] = a[i];
            d[i] = a[i];
            
        }
        
      
        
        // get the start time in nanoseconds
        long startTime1 = System.nanoTime();
        

        printLineBreak(71,'#');
        System.out.println("Original Version");
        
        printLineBreak(71,'/');
        System.out.print("Input: ");
        for (int i = 0; i< a.length; i++)
            System.out.print(a[i] + ", ");
            System.out.println("");
            
        
        
        bubbleSortOriginal(a);
        long endTime1 = System.nanoTime();
        System.out.print("Output: ");
        for (int i = 0; i< a.length; i++)
            System.out.print(a[i] + ", ");
            System.out.println("");
        
        long duration1 = endTime1 - startTime1;
        // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.print("Time: ");
        System.out.printf("%12.8f %n", (double)duration1/100000000) ;
       printLineBreak(71,'#');
        
       
       // RUN COCKTAIL VERSION 
       
       
        printLineBreak(71,'#');
        System.out.println("Cocktail Sort Version");
        System.out.println("Description and Observations:"); 
        System.out.println("The cocktail sort is an optimized version of the \n"
                + "bubble sort that saves times by sorting once forward and then once backwards.\n"
                + "I ran it several times and the entropy of the data did not seem to have a\nsignificant"
                + " affect.");

        printLineBreak(71,'/');
        long startTime2 = System.nanoTime();
        
        
        
        
        System.out.print("Input: ");
        for (int i = 0; i< a.length; i++)
            System.out.print(b[i] + ", ");
            System.out.println("");
        
        bubbleSortCocktail(b);

        // get the end time in nanoseconds
        
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        
        
        System.out.print("Output: ");
        for (int i = 0; i< a.length; i++)
            System.out.print(b[i] + ", ");
            System.out.println("");
               // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.print("Time: ");
        System.out.printf("%12.8f %n", (double)duration2/100000000) ;
        printLineBreak(71,'#');
        
       // RUN STACK OVERFLOW VERSION 
       
       
        printLineBreak(71,'#');
        System.out.println("Stack Overflow User Version");
         System.out.println("Description and Observations:"); 
        System.out.println("This version of the bubblesort is very similar\n"
                + "to the cocktail sort optimized version except it uses two\n"
                + "nested for loops to iterate through the array.\n"
                + "It was consistently the fastest of the bunch\n"
                + "regardless of data entropy.");
        printLineBreak(71,'/');
        long startTime3 = System.nanoTime();
        
        
        
        
        System.out.print("Input: ");
        for (int i = 0; i< c.length; i++)
            System.out.print(c[i] + ", ");
            System.out.println("");
        // run bubblesort2
        bubbleSortSO(c);

        // get the end time in nanoseconds
        
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        
        
        System.out.print("Output: ");
        for (int i = 0; i< c.length; i++)
            System.out.print(c[i] + ", ");
            System.out.println("");
               // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.print("Time: ");
        System.out.printf("%12.8f %n", (double)duration3/100000000) ;
        printLineBreak(71,'#');    
        
        
        
        // RUN RECURSIVE VERSION
       
       
        printLineBreak(71,'#');
        System.out.println("Recursive Version");
         System.out.println("Description and Observations:"); 
        System.out.println("This version simply implements the traditional\n"
                + "bubble sort recursively by calling itself after a swap.\n"
                + "It performed well but was not the fastest and seemed to\n"
                + "react somewhat negatively to increased entropy.");
        printLineBreak(71,'/');
        long startTime4 = System.nanoTime();
        
        
        
        
        System.out.print("Input: ");
        for (int i = 0; i< d.length; i++)
            System.out.print(d[i] + ", ");
            System.out.println("");
        
        bubbleSortRecursive(d);

        // get the end time in nanoseconds
        
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4;
        
        
        System.out.print("Output: ");
        for (int i = 0; i< d.length; i++)
            System.out.print(d[i] + ", ");
            System.out.println("");
               // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.print("Time: ");
        System.out.printf("%12.8f %n", (double)duration4/100000000) ;
        printLineBreak(71,'#'); 
        

    
        }
        
    } // end main()
/****************************************************************************/




// This method sorts values in the passed string array
public static void bubbleSortOriginal(int[] array)
{
    boolean swapped;    // a boolean variable to keep track of when array values are swapped 
    int temp;        // a catalyst variable for swapping values of variables
    
    do     //the outer post-test loop will  repeat another pass through the list when swapped in true
{ 
     swapped = false;   	
     for(int i=0; i < (array.length - 1) ; i++)    // a pass through the array to the second to last element
     {
	if ( array[i+1] < array[i] )  // if the two items are out of order
 	{
            // Swap the two items and set swapped to true 
            temp = array[i];   
            array[i] = array[i+1];
            array[i+1] = temp;
            swapped = true;
	}  // end if

     } // end for

} while (swapped);	// the outer loop will repeat if swapped is true – another pass

}// end bubbleSortOriginal()
/****************************************************************************/


// Optimized "Cocktail Sort" according to: 
// http://www.javacodex.com/Sorting/Cocktail-Sort

public static void bubbleSortCocktail(int[] array )
/* Sorts in increasing order the array A of the size length */
{
    
  boolean swapped;
    do {
      swapped = false;
      for (int i =0; i<=  array.length  - 2;i++) {
        if (array[ i ] > array[ i + 1 ]) {
          //test whether the two elements are in the wrong order
          int temp = array[i];
          array[i] = array[i+1];
          array[i+1]=temp;
          swapped = true;
        }
      }
      if (!swapped) {
        //we can exit the outer loop here if no swaps occurred.
        break;
      }
      swapped = false;
      for (int i= array.length - 2;i>=0;i--) {
        if (array[ i ] > array[ i + 1 ]) {
          int temp = array[i];
          array[i] = array[i+1];
          array[i+1]=temp;
          swapped = true;
        }
      }
    //if no elements have been swapped, then the list is sorted
    } while (swapped);
    
} // bubbleSort


// Stack Overflow Optimized Suggestion
// http://stackoverflow.com/questions/16195092/optimized-bubble-sort-java#16196115

public static void bubbleSortSO (int[] a) {
  int lastSwap = a.length-1;
  for(int i=1; i<a.length; i++) {
    boolean is_sorted = true;
    int currentSwap = -1;

    for(int j=0; j < lastSwap; j++) {
      if(a[j] > a[j+1]) {
         int temp = a[j];
         a[j] = a[j+1];
         a[j+1] = temp;
         is_sorted = false;
         currentSwap = j;
      }
    }

    if(is_sorted) return;
    lastSwap = currentSwap;
  }
} // SO optimized 


// Recursive Bubble Sort from:
// http://stackoverflow.com/questions/7798068/recursive-bubble-sort-in-java#7798082

   public static void bubbleSortRecursive(int [] a){
    int tmp;
    for(int i=0;i<a.length-1;i++){
        if(a[i] > a[i+1]){
            tmp = a[i];
            a[i]=a[i+1];
            a[i+1]=tmp;
            bubbleSortRecursive(a);
        }
    }
    
   }// end recursive bubble sort


////////////////////////////////////////////////////////////////////////////////    
// this method formats a line break with a width equal to the int passed into
// using the string passed in 
////////////////////////////////////////////////////////////////////////////////
    public static void printLineBreak(int width, char c) {

        for (int i = 1; i < width; i++) {   // print the char c until you've reached the desired width
            System.out.print(c);
        }
        System.out.print("\n");

    }
////////////////////////////////////////////////////////////////////////////////  

} // end class
