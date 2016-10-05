/* Corey Acri
 * CSCI 211 
 * Comparison of Sorting Algorithms
 *
 * This program compares various sorting algorithms 
 */

package comparingsortingalgorithms211;

import java.io.FileNotFoundException;



public class ComparingSortingAlgorithms211 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // set constants to represent the different sorting methods you want to run
        final int BUBBLERUN = 1;
        final int SELECTIONRUN = 2;
        final int INSERTIONRUN = 3;
        final int QUICKRUN = 4;
        final int MERGERUN = 5;

        // This is the outer loop which will run until the size of the arry is greater
        // than 10000000
        //100; 1000; 10,000; 100,000; 1,000,000, 10,000,000
        for (int size = 100; size <= 10000000; size *= 10) {

            //smaller loop for testing 
            //for(int size = 5; size <= 10; size++){
            // There are five sort methods, so here we create a new array and five copies
            // fill the first array 
            int[] bubbleArray = new int[size];
            fillArray(bubbleArray, size);

            // create selection sort array
            int[] selectionArray = new int[size];

            // copy values from bubble array to selection array
            copyArray(bubbleArray, selectionArray);

            // create insertion sort array 
            int[] insertionArray = new int[size];

            // copy values from bubble array to insertion array 
            copyArray(bubbleArray, insertionArray);

            // create quick sort array 
            int[] quickArray = new int[size];

            // copy values from bubble array to quick sort array 
            copyArray(bubbleArray, quickArray);

            // create merge sort array 
            int[] mergeArray = new int[size];

            // copy values from bubble sort array to merge sort array 
            copyArray(bubbleArray, mergeArray);

            // int representing the number of times you want to test each sort for each size
            int numberOfTimes = 10;

            //call method to run the sort of choice on the corresponding array
            runSortXTimes(bubbleArray, numberOfTimes, size, BUBBLERUN); // BUBBLE SORT
            runSortXTimes(selectionArray, numberOfTimes, size, SELECTIONRUN); // SELECTION SORT
            runSortXTimes(insertionArray, numberOfTimes, size, INSERTIONRUN); // INSERTION SORT
            runSortXTimes(quickArray, numberOfTimes, size, QUICKRUN); // QUICK SORT
            runSortXTimes(mergeArray, numberOfTimes, size, MERGERUN); // MERGE SORT

        } //end outer array size loop

    } // end main()

//******************************************************************************
// METHODS
//******************************************************************************    

////////////////////////////////////////////////////////////////////////////////   
// this is the primary method for testing the run times of the different 
// sorting algoritms. It receives an array, an int representing the number of 
// times to test the algorithm (x), an int for the array size and a constant
// corresponding to whichever algorithm should be tested
////////////////////////////////////////////////////////////////////////////////    
    public static void runSortXTimes(int[] array, int x, int size, int sortingAlgorithmChoice)
            throws FileNotFoundException {

        // the switch statement runs the case corresponding to sortingAlgorithmChoice's value 
        // BUBBLE = 1,    
        // SELECTION = 2,
        // INSERTION 3, 
        // QUICK = 4, 
        // MERGE = 5
        
        // declare name of sort as String for use in writing file later                  
        String sortType = "BubbleSort"; // Bubble is the default value since run first   

        //declare array to hold time values the size of x (number of passes)
        double[] timeArray = new double[x];

        // switch statement to determine which sort method to test
        switch (sortingAlgorithmChoice) {

            case 1:	// Bubble Sort

                if (size > 100000) { // Skip BubbleSort if size > 100000
                    printLineBreak(71, 'x');
                    System.out.println("Skipping BubbleSort, size too large");
                    printLineBreak(71, 'x');

                } else { // Test the BubbleSort

                    // declare name of sort as String for use in writing file later
                    sortType = "BubbleSort";

                    //console output
                    printLineBreak(71, '`');
                    System.out.println("TESTING BUBBLE SORT");
                    System.out.println("Array size: " + size);
                    printLineBreak(71, '`');

                    for (int k = 1; k <= x; k++) { //run the sort 'x' times

                        //make a copy of the original array every pass;  
                        int[] arrayCopy = new int[size];

                        copyArray(array, arrayCopy);
                        
                        // console output
                        System.out.println("ATTEMPT #" + k);

//leave for testing 
//        System.out.println("Array:");
//        printArray(array);
//        System.out.println("Copied Array (should match):");
//        printArray(arrayCopy);
//            
                        // declare a start time
                        long startTime = System.nanoTime();

                        // run sort method
                        bubbleSort(arrayCopy);

                        // calculate how long it took timer to run using k-1 
                        // as index because k starts at 1 for printing purposes
                        timeArray[k - 1] = calculateDuration(startTime);

//for testing
//           printLineBreak(71,':');
//
//             System.out.println("Original array should be unsorted (array copy):");
//             printArray(array);
//             System.out.println("Sorted (array copy):");
//             printArray(arrayCopy);
//             printLineBreak(71,':');
//            
                    } // close forLoop 

                    // call method to print to csv file
                    printCSV(size, x, timeArray, sortType);
                }
                break;

            case 2: // Run SelectionSort

                if (size > 100000) { // Skip SelectionSort if size > 100000
                    printLineBreak(71, 'x');
                    System.out.println("Skipping SelectionSort, size too large");
                    printLineBreak(71, 'x');

                } else { // Test the SelectionSort
                    
                    // set sortType for csv file
                    sortType = "SelectionSort";
                    
                    
                    // console output 
                    printLineBreak(71, '`');
                    System.out.println("TESTING SELECTION SORT");
                    System.out.println("Array size: " + size);
                    printLineBreak(71, '`');

                    for (int k = 1; k <= x; k++) { // run sort x times

                        //make a copy of the original array every pass;  
                        int[] arrayCopy = new int[size];

                        copyArray(array, arrayCopy);

//testing
//        System.out.println("Array:");
//        printArray(array);
//        System.out.println("Array Copy:");
//        printArray(arrayCopy);
//            
                        // console output
                        System.out.println("ATTEMPT #" + k);
                        
                        // set start time
                        long startTime = System.nanoTime();
                        
                        // run sort method
                        selectionSort(arrayCopy);

                        // calculate duration using k-1 as index because k starts at 1 for print purposes
                        timeArray[k - 1] = calculateDuration(startTime);

                        //for testing
//           printLineBreak(71,':');
//           System.out.println("Unsorted (array):");
//             printArray(array);
//             printLineBreak(71,':');
//             printLineBreak(71,'-');
//             printLineBreak(71,':');
//             System.out.println("Sorted (array copy):");
//             printArray(arrayCopy);
//             printLineBreak(71,':');
//            
                    }
                    printCSV(size, x, timeArray, sortType);
                }
                break;

            case 3:	// Run Insertion Sort 

                if (size > 100000) { // Skip Insertion Sort if size > 100000

                    printLineBreak(71, 'x');
                    System.out.println("Skipping Insertion Sort, size too large");
                    printLineBreak(71, 'x');

                } else { // Test the Insertion Sort

                    // declare name of sort as String for use in writing file later
                    sortType = "InsertionSort";

                    //console output
                    printLineBreak(71, '`');
                    System.out.println("TESTING INSERTION SORT");
                    System.out.println("Array size: " + size);
                    printLineBreak(71, '`');
                    
                    for (int k = 1; k <= x; k++) { // run sort x times

                        //make a copy of the original array every pass;  
                        int[] arrayCopy = new int[size];

                        copyArray(array, arrayCopy);

                        // for testing
//        System.out.println("Array:");
//        printArray(array);
//        System.out.println("Array Copy:");
//        printArray(arrayCopy);
//            
                        //console output 
                        System.out.println("ATTEMPT #" + k);
                        
                        // declare start time
                        long startTime = System.nanoTime();
                        
                        // run sort method
                        insertionSort(arrayCopy);

                        // using k-1 as index because k starts at 1 for print purposes
                        timeArray[k - 1] = calculateDuration(startTime);

                        //for testing
//           printLineBreak(71,':');
//           System.out.println("Unsorted (array):");
//             
//             printArray(array);
//             printLineBreak(71,':');
//             printLineBreak(71,'-');
//             printLineBreak(71,':');
//             System.out.println("Sorted (array copy):");
//             printArray(arrayCopy);
//             printLineBreak(71,':');
//            
                    } // close for loop
                    
                    // print results to csv file
                    printCSV(size, x, timeArray, sortType);

                } // close else 
                break;

            case 4:	// Quick Sort

                // declare name of sort as String for use in writing file later
                sortType = "QuickSort";
                
                
                //console output
                printLineBreak(71, '`');
                System.out.println("TESTING QUICK SORT");
                System.out.println("Array size: " + size);
                printLineBreak(71, '`');
                
                for (int k = 1; k <= x; k++) { // run sort x times

                    //make a copy of the original array every pass;  
                    int[] arrayCopy = new int[size];

                    copyArray(array, arrayCopy);

                    //for testing
//        System.out.println("Array:");
//        printArray(array);
//        System.out.println("Array Copy:");
//        printArray(arrayCopy);
//                  

                    // console output 
                    System.out.println("ATTEMPT #" + k);
                    
                    // declare start time
                    long startTime = System.nanoTime();
                    
                    // run sort method
                    quickSort(arrayCopy, 0, (arrayCopy.length - 1));

                    // calculate duration using k-1 as index because k starts at 1 for print purposes
                    timeArray[k - 1] = calculateDuration(startTime);
                    
                    
                    //for testing
//           printLineBreak(71,':');
//           System.out.println("Unsorted (array):");
//           

//             printArray(array);
//             printLineBreak(71,':');
//             printLineBreak(71,'-');
//             printLineBreak(71,':');
//             System.out.println("Sorted (array copy):");
//             printArray(arrayCopy);
//             printLineBreak(71,':');
//            
                } // close for loop
                
                // print time results to csv 
                printCSV(size, x, timeArray, sortType);
                break;

            case 5:	// Merge Sort

                // set sortType for use for csv file later
                sortType = "MergeSort";

                //console output 
                printLineBreak(71, '`');
                System.out.println("TESTING MERGE SORT");
                System.out.println("Array size: " + size);
                printLineBreak(71, '`');

                for (int k = 1; k <= x; k++) { // run sort x times

                    //make a copy of the original array every pass;  
                    int[] arrayCopy = new int[size];

                    // the temporary array for the MergeSort method
                    int[] temp = new int[array.length];

                    copyArray(array, arrayCopy);

                    // for testing
//        System.out.println("Array:");
//        printArray(array);
//        System.out.println("Array Copy:");
//        printArray(arrayCopy);
//            
                    //console output 
                    System.out.println("ATTEMPT #" + k);
                    
                    // set startTime 
                    long startTime = System.nanoTime();
                    
                    // run sort method
                    mergeSort(arrayCopy, temp, 0, (arrayCopy.length - 1));

                    // calculate duration using k-1 as index because k starts at 1 for print purposes
                    timeArray[k - 1] = calculateDuration(startTime);

                    //for testing
//           printLineBreak(71,':');
//           System.out.println("Unsorted (array):");
//             printArray(array);
//             printLineBreak(71,':');
//             printLineBreak(71,'-');
//             printLineBreak(71,':');
//             System.out.println("Sorted (array copy):");
//             printArray(arrayCopy);
//             printLineBreak(71,':');
//             
                } // close for loop
                // print time results to csv
                printCSV(size, x, timeArray, sortType);
                break;

            default: // default case
                System.out.println("ERROR: INVALID CHOICE");
        } //end switch

    } // end runSortXTimes

////////////////////////////////////////////////////////////////////////////////   
// INSERTION SORT     
////////////////////////////////////////////////////////////////////////////////
    public static void insertionSort(int[] a) {

        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;

        for (j = 1; j < a.length; j++) // Start with 1 (not 0)
        {
            key = a[j];
            for (i = j - 1; (i >= 0) && (a[i] < key); i--) // Smaller values are moving up
            {
                a[i + 1] = a[i];
            }
            a[i + 1] = key;    // Put the key in its proper location
        }

    }

////////////////////////////////////////////////////////////////////////////////
// BUBBLE SORT This method sorts values in the passed string array
////////////////////////////////////////////////////////////////////////////////
    public static void bubbleSort(int[] array) {

        boolean swapped;    // a boolean variable to keep track of when array values are swapped 
        int temp;        // a catalyst variable for swapping values of variables

        do //the outer post-test loop will  repeat another pass through the list when swapped in true
        {
            swapped = false;
            for (int i = 0; i < (array.length - 1); i++) // a pass through the array to the second to last element
            {
                if (array[i + 1] < array[i]) // if the two items are out of order
                {
                    // Swap the two items and set swapped to true 
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }  // end if

            } // end for

        } while (swapped);	// the outer loop will repeat if swapped is true – another pass

    }// end bubbleSortOriginal()

////////////////////////////////////////////////////////////////////////////////
// SELECTION SORTING ALGORITHM 
////////////////////////////////////////////////////////////////////////////////
    public static void selectionSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length; i++) {
            // Assume first element is min
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;

                }
            }
            if (min != i) {
                final int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }

    }

////////////////////////////////////////////////////////////////////////////////
//MERGE SORTING ALGORITHM
////////////////////////////////////////////////////////////////////////////////
    public static void mergeSort(int[] a, int[] temp, int low, int high) {

        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        int mid;  // the middle of the array – last item in low half

        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part
            // find middle (last element in low half)   
            mid = (low + high) / 2;
            mergeSort(a, temp, low, mid);
            mergeSort(a, temp, mid + 1, high);

            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if 

        return;

    }// end mergerSort()
    
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
        if (lowP > mid) {
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        } else // high half is done, move rest of low half
        {
            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for
        }
        return;
    } // end merge()
// *************************************************************
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
    /**
     * *** QUICK SORTING ALGORITHM *******
     */
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
// This method calculates the time elaspsed 
////////////////////////////////////////////////////////////////////////////////
    public static double calculateDuration(long startTime) {

        double time;
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        printLineBreak(71, '#');
        System.out.print("Time: ");
        // return the elapsed time in seconds   (nanoseconds/ 1 billion)
        System.out.printf("%12.8f %n", (double) duration / 100000000);

        printLineBreak(71, '#');
        // return the elapsed time in seconds   (nanoseconds/ 1 billion)
        return time = (double) duration / 1000000000;

    }
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////    
// a method to print the elements of an integer array on one line 
////////////////////////////////////////////////////////////////////////////////
    public static void printArray(int[] a) {

        // iterate and print the array on one line
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if (i % 50 == 1) {
                System.out.println("");
            }
        }

        System.out.println();

    } // end printArray()
    //************************************************************************

////////////////////////////////////////////////////////////////////////////////    
// this method fills an array with random integers based on a given size
////////////////////////////////////////////////////////////////////////////////    
    public static void fillArray(int[] a, int size) {

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * size + 1);
        }

    }

////////////////////////////////////////////////////////////////////////////////    
// this method makes a copy of an array
//////////////////////////////////////////////////////////////////////////////// 
    public static void copyArray(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

    }

////////////////////////////////////////////////////////////////////////////////     
// this method creates a csv file each time a sort method is test for a given size
//////////////////////////////////////////////////////////////////////////////// 
    public static void printCSV(int size, int pass, double[] time, String sortType) throws FileNotFoundException {

        // create a File class object 
        java.io.File testResult = new java.io.File(sortType + "Size" + size + ".csv");

        // Create a PrintWriter text output stream and link it to the file
        java.io.PrintWriter outfile = new java.io.PrintWriter(testResult);

        outfile.println(sortType);
        outfile.println("Size: " + size);

        // print the column headers
        for (int i = 1; i <= time.length; i++) {
            outfile.print("Pass " + i + ",");
        }

        // start a new row
        outfile.println();

        // print row of results
        for (int j = 0; j < time.length; j++) {
            outfile.print(time[j]);
            outfile.print(",");
        }

        //close file
        outfile.close();

    }

} // end class
