/* Corey Acri
 * CSCI 112 
 * Final Project: Comparison of Sorting Algorithms
 *
 * This program compares various sorting algorithms 
 */ 
package comparingsortingalgorithms;

import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author AcriCAA
 */
public class ComparingSortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
   
     for(int l=1;l<=24;l++){

  int choice = selectMethod();
  
  int size = selectSize(); 
  
   // create a File class object and give the file the name SQLresult.txt
        java.io.File testResult = new java.io.File("resultsChoice"+ choice + "Size" + size + ".csv");
        // Create a PrintWriter text output stream and link it to the File sqlResult
        java.io.PrintWriter outfile = new java.io.PrintWriter(testResult); 
  
  switch (choice)
    {
    case 1:	// Run Insertion Sort 
        
        System.out.println("Running Insertion Sort");
        
        outfile.println("Insertion Sort");
        outfile.println("Size: " + size);
        
        for (int k = 1; k<= 5; k++){
               

        System.out.println("ATTEMPT #" + k);
            
            
        int[] a = new int[size];
        // fill the array with random integers
            for (int i = 0; i< a.length; i++) 
                a[i] = (int)(Math.random()*size +1);
           
           int [] b = new int[size];
           // copyArray(a,b); 
           long startTime = System.nanoTime();
           // run sort method
           insertionSort(a); 
           
            double time = calculateDuration(startTime);
            outfile.print(time);
            outfile.print(",");
           
           //printLineBreak(71,':');
           //System.out.println("Unsorted:");
           
           //printArray(b);
           //printLineBreak(71,':');
           //printLineBreak(71,'-');
           //printLineBreak(71,':');
           //System.out.println("Sorted:");
           //printArray(a);
           //printLineBreak(71,':');
           
           
        } 
        outfile.close();
        
        
        
   		break;
    case 2:	// Bubble Sort
        System.out.println("Running Bubble Sort");
         outfile.println("Bubble Sort");
        outfile.println("Size: " + size);
        for (int k = 1; k<= 5; k++){
            System.out.println("ATTEMPT #" + k);
        int[] a = new int[size];
        // fill the array with random integers
            for (int i = 0; i< a.length; i++) 
                a[i] = (int)(Math.random()*size +1);
           
           //int [] b = new int[size];
           //copyArray(a,b); 
           long startTime = System.nanoTime();
           // run sort method
           bubbleSort(a);
           double time = calculateDuration(startTime);
            outfile.print(time);
            outfile.print(",");
           //printLineBreak(71,':');
           //System.out.println("Unsorted:");
           
//           printArray(b);
//           printLineBreak(71,':');
//           printLineBreak(71,'-');
//           printLineBreak(71,':');
//           System.out.println("Sorted:");
//           printArray(a);
//           printLineBreak(71,':');
        } 
        outfile.close();
   		break;
    case 3:	// Quick Sort
        System.out.println("Running Quick Sort");
        outfile.println("Quick Sort");
        outfile.println("Size: " + size);
                  
          for (int k = 1; k<= 5; k++){
            System.out.println("ATTEMPT #" + k);
        int[] a = new int[size];
        // fill the array with random integers
            for (int i = 0; i< a.length; i++) 
                a[i] = (int)(Math.random()*size +1);
           
//           int [] b = new int[size];
//           copyArray(a,b); 
           
           long startTime = System.nanoTime();
            
           // run sort method
           quickSort(a, 0, (a.length - 1)); 
           
           double time = calculateDuration(startTime);
            outfile.print(time);
            outfile.print(",");
//           printLineBreak(71,':');
//           System.out.println("Unsorted:");
//           
//           printArray(b);
//           printLineBreak(71,':');
//           printLineBreak(71,'-');
//           printLineBreak(71,':');
//           System.out.println("Sorted:");
//           printArray(a);
//           printLineBreak(71,':');
        } 
          outfile.close();
   		break;
    case 4:	// Merge Sort
            System.out.println("Running Merge Sort");
            outfile.println("Merge Sort");
        outfile.println("Size: " + size);
            for (int k = 1; k<= 5; k++){
    
                int[] a = new int[size];
                int [] temp = new int[a.length];
                // fill the array with random integers
                    for (int i = 0; i< a.length; i++) 
                        a[i] = (int)(Math.random()*size +1);
                  
//                  int [] b = new int[size];
//                  copyArray(a,b); 

                  long startTime = System.nanoTime();
                  // run sort method  
                  mergeSort(a, temp, 0, (a.length - 1));
                  double time = calculateDuration(startTime);
                  outfile.print(time);
            outfile.print(",");
//           printLineBreak(71,':');
//           System.out.println("Unsorted:");
//           
//           printArray(b);
//           printLineBreak(71,':');
//           printLineBreak(71,'-');
//           printLineBreak(71,':');
//           System.out.println("Sorted:");
//           printArray(a);
//           printLineBreak(71,':');
        }
            outfile.close();
   		break;
    default :	System.out.println("ERROR: INVALID CHOICE");
    } //end switch
        
        }
        
    } // end main()
/****************************************************************************/
////////////////////////////////////////////////////////////////////////////////
// This method presents the user with an option to select which sorting
// method he or she wants to test
////////////////////////////////////////////////////////////////////////////////  
public static int selectMethod(){

int item; 
// set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);

        
        System.out.println("This program tests various sorting methods");
        System.out.println("Which method would you like to test?"); 
        System.out.println("Enter \"1\" for Insertion Sort."); 
        System.out.println("Enter \"2\" for Bubble Sort."); 
        System.out.println("Enter \"3\" for Quick Sort."); 
        System.out.println("Enter \"4\" for Merge Sort."); 
        System.out.print("Please make your selection and press enter: ");
       
        do {
            try {
                String s = kb.nextLine();
                item = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.println("Please try again, entering only a number between 1 and 4:");
            }
        } while (true);


return item; 
}
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// This method presents the user with an option to select which sorting
// method he or she wants to test
////////////////////////////////////////////////////////////////////////  
public static int selectSize(){
int size; 
// set up instance of Scanner for input
        Scanner kb = new Scanner(System.in);

        
        System.out.println("Thank you for your selection, now we "
                + "need to know how large an array you want to test.");
        System.out.print("Please enter either 10,000; 20,000; "
                + "100,000; 200,000; 1,000,000 or 2,000,000: ");
       
          do {
            try {
                String s = kb.nextLine();
                size = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.out.println("Please try again, entering only a number:");
            }
        } while (true);



return size; 
}
////////////////////////////////////////////////////////////////////////////////   
    
    
////////////////////////////////////////////////////////////////////////////////   
// INSERTION SORT     
////////////////////////////////////////////////////////////////////////////////
public static void insertionSort(int [] a) {


     int j;                     // the number of items sorted so far
     int key;                // the item to be inserted
     int i;  

     for (j = 1; j < a.length; j++)    // Start with 1 (not 0)
    {
           key = a[j];
           for(i = j - 1; (i >= 0) && (a[ i ] < key); i--)   // Smaller values are moving up
          {
                 a[ i+1 ] = a[ i ];
          }
         a[ i+1 ] = key;    // Put the key in its proper location
     }


}

////////////////////////////////////////////////////////////////////////////////
// BUBBLE SORT This method sorts values in the passed string array
////////////////////////////////////////////////////////////////////////////////
public static void bubbleSort(int[] array)
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

////////////////////////////////////////////////////////////////////////////////
/******* MERGE SORTING ALGORITHM ****************/


    public static void mergeSort(int[] a, int[] temp, int low, int high) {
        
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        
        int mid;  // the middle of the array – last item in low half
        
        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part

            // find middle (last element in low half)   
            mid = (low+high)/2;
            mergeSort(a, temp, low, mid );
            mergeSort(a, temp, mid+1, high);
            
            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if 
        
        return;
        
    }// end mergerSort()
    //********************************************************************
 ////////////////////////////////////////////////////////////////////////////////
    
////////////////////////////////////////////////////////////////////////////////
    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     * 
     * The work of sorting occurs as the two halves are merged back into one 
     * sorted set.
     * 
     * This version of mergesort copies the set to be sorted into the same 
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */
    public static void merge(int[] a, int[] temp, int low, int mid, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half
        
        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }

        //set up necessary pointers 
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half)
        while ((lowP <= mid) && (highP <= high)) {

            // if current item in low half <= current item in high half 
            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;
            } else {
                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;
            } // end if..else
            
            // increment pointer for location in original array
            aP++;
        } // end while

        /* When the while loop is done, either the low half or the high half is done 
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid) 
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        else // high half is done, move rest of low half
        
            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for
        
        return;
    } // end merge()
// *************************************************************
////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////
/***** QUICK SORTING ALGORITHM ******* */  
// the recursive quicksort method, which calls the partition method
    public static void quickSort(int[] a, int startIndex, int endIndex) {
        
        int pivotIndex;      // the index of pivot returned by the quicksort partition

        // if the set has more than one element, then partition
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex);
            // quicksort the low set
            quickSort(a, startIndex, pivotIndex - 1);
            // quiclsort the high set
            quickSort(a, pivotIndex + 1, endIndex);
        } // end if
        
    } // end quickSort()
    //************************************************************************
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// This method performs quicksort partitioning on a set of elements in an array.
////////////////////////////////////////////////////////////////////////////////
    public static int partition(int[] a, int startIndex, int endIndex) {

        int pivotIndex;             // the index of the chosen pivot element
        int pivot;                  // the value of the chosen pivot
        int midIndex = startIndex;  // boundary element between high and low sets

        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];

        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);

        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            // if a[i] is less than the pivot
            if (a[i] < pivot) {

                // put a[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;
            } // end if
        } // end for 
        
        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);

        // return index of pivot
        return midIndex;
        
    } // end partition
    //************************************************************************


////////////////////////////////////////////////////////////////////////////////
    // This method swaps two elements in an integer array
    public static void swap(int[] a, int first, int second) {
        
        int c;  // a catalyst variable used for the swap

        c = a[first];
        a[first] = a[second];
        a[second] = c;

    } // end Swap()
    //************************************************************************
////////////////////////////////////////////////////////////////////////////////
    
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
  
////////////////////////////////////////////////////////////////////////////////
// This method calculations the time elaspsed 
////////////////////////////////////////////////////////////////////////////////
public static double calculateDuration(long startTime){

        double time;
        long endTime = System.nanoTime();
         
        long duration = endTime - startTime;
        printLineBreak(71,'#');
        System.out.print("Time: ");
        System.out.printf("%12.8f %n", (double)duration/100000000) ;
        
        printLineBreak(71,'#');
        
        return time = (double)duration/100000000; 

} 
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////    
    // a method to print the elements of an integer array on one line 
////////////////////////////////////////////////////////////////////////////////
    public static void printArray(int[] a) {
 
        // iterate and print the array on one line
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if (i%50 == 1){
                System.out.println("");
            }
        }

        System.out.println();

    } // end printArray()
    //************************************************************************


public static void copyArray(int [] a, int [] b){


 for (int i = 0; i < a.length; i++) {
          b[i] = a[i];
        }

}
    
} // end class