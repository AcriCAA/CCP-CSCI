/* Corey Acri 
 * CSCI 211
 * CityProject.java  -- project class file with the project's main method 
 *
 *  * The CityProject software package creates a graph of cities in the Unitied 
 * States with links between the cities. Each city is a vertex in the graph.
 * Each link between cities is an edge in the graph. The data for the cities and
 * links are read into arrays from CSV data files, which should be in the 
 * project folder. (CSV files, can be created, read, and edited using MS Excel.)
 *
 * The package's main class is the CityProject class. Other classes include:
 * 
 *   * AjacencyNode - a node for a linked list of Cities.  Each City has a list 
 *     of adjacnt cities, created from the links data file. Each list node has 
 *     a destination City, distance data, and a pointer to the next node. 
 *
 *   * City extends Vertex - Each City is a Vertex with added properties.  
 *     Each City has a unique name, and X and Y coordinates for location on a 
 *     1500 by 900 JPanel.
 *
 *   * Edge - an edge in a graph, with a source, destination, and length.
 *   
 *   * CityMap extends JPanel - a map of the graph on a 1500 by 900 GUI JPanel.
 *
 *   * Vertex - each Vertex in a graph.
 * 
 * The main method in the CityProject class calls methods to reads City and Edge 
 * data from data files into arrays, set up the adjacency list in each instance 
 * of City, print a list of Vertex cities and their Edges, then draw a map of the graph.
 *
 * created for use by students in CSCI 211 at Community Colle of Philadelphia
 * copyright 2014 by C. herbert.  last edited Nov. 23, 2014 by C. Herbert
 *
 * modified by Corey Acri December 2016 to include Dikstra's Algorithm analysis
 */

package cityproject;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import static java.lang.Integer.MAX_VALUE;


public class CityProject {

    // main metod for the project
    public static void main(String[] args) {
        
        // scanner for input
        Scanner kb = new Scanner(System.in);
        String startCityName = "no name"; 
        String destinationCityName = "no name"; 

        City[] cities = new City[200]; //array of cities (Vertices) max = 200
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }

        Edge[] links = new Edge[2000];// array of links  (Edges)  max = 2000
        for (int i = 0; i < links.length; i++) {
            links[i] = new Edge();
        }

        int cityCount; //    actual number of cities
        int linkCount; //    actual number of links

        // load cities into an array from a datafile
        cityCount = readCities(cities);

        // load links into an array from a datafile
        linkCount = readLinks(links, cities);

        // create the adjacency list for each city based on the link array
        createAdjacencyLists(cityCount, cities, linkCount, links);
        
        

        // print adjacency lists for all cities
//        PrintAdjacencyLists(cityCount, cities);

        // instatiate a new scrollable map of the cities and links
         DrawScrollableMap(cityCount, cities, linkCount, links);


// Corey Modifications

    //stackCities(cities); // testing
    
    
       printGetStartCity();
       startCityName = getCityNameFromUser(kb, cities);
              
      printGetDestinationCity();
      destinationCityName = getCityNameFromUser(kb, cities);
       

     dijkstratize(cities, startCityName, destinationCityName, cityCount);
        
    } // end main
    //************************************************************************
  
    

    /*************************************************************************** 
    * dijkstratize() 
    * runs Dijkstra's Algorithm to find the shortest path between two cities
    ***************************************************************************/ 
    public static void dijkstratize(City [] cities, String startCity, String endCity, int cityCount){
    
    
    City currentVertex = new City(); // create variable for currentVertex
    City destinationVertex = new City(); // destination 
    
    // Set the currentVertex to be the source vertex. 
    currentVertex = findCity(cities, startCity);
    destinationVertex = findCity(cities, endCity);
    
    
    // Set its bestDistance to be zero, 
    currentVertex.setBestDistance(0);
    
    //and leave its immediatePredecessor null.
    currentVertex.setImmediatePredecessor(null);
    

    
    
    int uHasMembers = Integer.MAX_VALUE;
    
    
    
    CityStack uStack = new CityStack();
    City vertexFromUWithShortestBestDistance = new City(); 
    
    
    CityStack destinationStack = new CityStack();
    
    while(uHasMembers > 0){
        
         // Step a. For each vetex adjacent to currentVertex, determine if there is 
         // a new shortest path to vertices adjacent to currentVertex through currentVertex.
         // If there is a new shortest path to a vertex through the currentVertex
         // update its bestDistance and immediatePredecessor values
         determineBestDistance(currentVertex, cities, cityCount);
         
         // Step b. Mark current Vertex as Visited
       // setVisited(currentVertex, cities, cityCount);
        
        currentVertex.setVisited(true);
        
        //update currentVertex to be the vertex from U with the shortest bestDistance
        vertexFromUWithShortestBestDistance = vertexFromUBestDistance(cities, cityCount, currentVertex);
        currentVertex = vertexFromUWithShortestBestDistance;
        
      
        
        
        
        
        uHasMembers = uCount(cities, cityCount); 
        
       
    
    } // end while 
    
    buildDestinationStack(destinationVertex, destinationStack);
    printResult(destinationStack, startCity);
    
    } // end dijkastra's 
    
    
    
    /*************************************************************************** 
    * determineBestDistance() 
    * this is 
    ***************************************************************************/  
    
   public static void determineBestDistance(City currentVertex, City [] cities, int cityCount){
// set current to adjacency list for this city





    
    int bestDistance = Integer.MAX_VALUE; //  placeholder for best distance
    int currentVertexBestDistance; 
    int adjacentVertexDistance; // distance to adjacent vertex
    int adjacentVertexBestDistance = 0 ; // best distance currently stored in the adjacent city
    int tempDistance; // temp value for distance grabbed from Adjancency Node List
    int distanceThroughCurrentVertex = 0;  // shortest path

    City currentCity = new City(); 
    City currentAdjacentCity = new City(); 
    City tempCity = new City(); // for testing  
    
    String setCurrentCityName; // temp string value to grab 
    
            tempCity = findCity(cities, currentVertex.getName());
    
            AdjacencyNode current = tempCity.getAdjacencyListHead();

            // iterate adjacency list and print each node's data
            while (current != null) {
                
                currentCity = current.getCity();
                
                adjacentVertexDistance = current.getcDistance();

                
                currentAdjacentCity = current.getCity();

               
                adjacentVertexBestDistance = currentAdjacentCity.getBestDistance(); // get the value for the best distance from the adjacent node

                
              
//                distanceThroughCurrentVertex = adjacentVertexDistance + currentVertexBestDistance; 
                distanceThroughCurrentVertex = adjacentVertexDistance + currentVertex.getBestDistance(); 
                
                
                if(distanceThroughCurrentVertex < currentAdjacentCity.getBestDistance()){
                //currentAdjacentCity = findCity(cities, currentAdjacentCity.getName());
                // set the best distance and immediate predecessor    
                currentAdjacentCity.setBestDistance(distanceThroughCurrentVertex);
                currentAdjacentCity.setImmediatePredecessor(tempCity);
                
                
                } // close if
                
              
                current = current.getNext(); //get next adjancey node

                
            } // end while (current != null) 
            
            
    } // close determineBestDistance
    
    /*************************************************************************** 
    * setVisited() 
    * 
    ***************************************************************************/ 
    public static void setVisited(City currentVertex, City[] cities, int cityCount){
    
    City cityToModify = new City(); // temp object to set visited value
    
    cityToModify = findCity(cities, currentVertex.getName());
    
    cityToModify.setVisited(true);
    
  
    }
    
    /*************************************************************************** 
    * printResult() 
    * 
    ***************************************************************************/ 
    public static void printResult(CityStack dStack, String startCityName){
    
    City tempCity = new City(); 
        System.out.println("\n==============FINAL ROUTE================\n"); 
        System.out.println("From " + startCityName); 
    while(dStack.count() > 0){
        tempCity = dStack.pop(); 
        
        System.out.println(tempCity.getName()); 
    
    }
    
    
    } // close print result
    
    
    /*************************************************************************** 
    * buildDestinationStack() 
    * 
    ***************************************************************************/ 
    public static void buildDestinationStack(City dVertex, CityStack dStack){
    
        City tempVertex = dVertex; 
        
           while(tempVertex.getImmediatePredecessor() != null){
           
           dStack.push(tempVertex);
           tempVertex = tempVertex.getImmediatePredecessor();
           
           }
    
    }
    
    /*************************************************************************** 
    * uCount()
    * 
    ***************************************************************************/ 
    public static int uCount(City []cities, int cityCount){
    
    int uCounter = 0; 
    
        for(int i = 0; i < cityCount; i++){
            if(cities[i].getVisited() == false){
            
                  uCounter++; 
            
            }

        }
    
        return uCounter; 
   
    }
   
    
    
    /*************************************************************************** 
    * vertexFromUBestDistance()
    * 
    ***************************************************************************/ 
    public static City vertexFromUBestDistance(City [] cities, int cityCount, City currentVertex){
    
       
       
       City bestCity = new City();  
       City tempCity = new City(); // temp city to compare values
       boolean tempVisited; 
       
       
   
       CityStack currentUStack = new CityStack(); 
     //create a stack of current u's 
        for(int i = 0; i < cityCount; i++){
            tempVisited = cities[i].getVisited();
                    
            if(tempVisited == false){
 
                   currentUStack.push(cities[i]);
//                   System.out.println("Pushed " + cities[i]); 
//                   if(cities[i].getVisited() == false)
//                       System.out.println("was not visited"); 

            }
        } // close for cities[] loop 
            
       if(currentUStack.count() > 0){
          
       bestCity = currentUStack.pop(); // arbitrarily set best city to first in stack so you have somthing to compare
       }
       
       
       while (currentUStack.count() > 0){
       
       tempCity = currentUStack.pop(); 
         
       if(tempCity.getBestDistance() < bestCity.getBestDistance()){
           bestCity = tempCity; 
                     
          }
       
       } // close while
           
            
        
       
     
      return bestCity; 
     
    
   
    } // close verFromBestDistance
   
    
    /*************************************************************************** 
    * stackCities() 
    * method to test putting cities in a stack 
    ***************************************************************************/ 
    public static void stackCities(City [] cities){
    
    CityStack stackedCities = new CityStack();
    
    City temp = new City(); // temp for City to be used for popping
    String cityName = "no name"; 
    
        System.out.println("Length of Cities Array = " + cities.length); 
    
    for(int i = 0; i < cities.length; i++){
    
        cityName = cities[i].getName(); 
        
        if (cityName != null) 
            stackedCities.push(cities[i]);
    
    }
    
    int stackSize = stackedCities.count(); 
    System.out.println("Stack size = " + stackSize);
    
    
    for(int j = 0; j < stackSize; j++){
    temp = stackedCities.pop(); 
        System.out.println(temp); 
    
    }
    
    } // close stackCities
    
    /*************************************************************************** 
    * printGetStartCity() 
    * prompts the user for the starting city name 
    ***************************************************************************/ 
    public static void printGetStartCity() {
   
        System.out.println("=============================================================");
        System.out.println("Please enter the city name for your starting point:");
          
    }
    
    
    /*************************************************************************** 
    * printGetDetinationCity() 
    * prompts the user for the starting city name 
    ***************************************************************************/ 
    public static void printGetDestinationCity() {
   
        System.out.println("=============================================================");
        System.out.println("Please enter the city name for your ending point:");
          
    }
    
    
    
    /*************************************************************************** 
    * printCityList(City [] cities)
    * prints a formatted list of existing cities 
    ***************************************************************************/ 
    public static void printCityList(City [] cities){
    
        String currentCityName = "no name";
        
        System.out.println("=============================================================");
        System.out.println("These are your choices for cities:");
            
          for (int i = 0; i < cities.length; i++){
                
                
                currentCityName = cities[i].getName(); 
                    

              if (currentCityName != null){ // checking if currentCityName has a string value
                  System.out.printf("%20s",currentCityName); 

                       } // close if 
              
              if (i % 3 == 0 && currentCityName != null){ // print a line every three cities
                  System.out.print("\n"); 
              
              }
              
             
             } //close loop  
          
           System.out.println("\n\n"); // add some padding at the end 
              
    }
        
    /*************************************************************************** 
    * String getCityNameFromUser(Scanner kb, City [] cities)
    * prompts the user for the starting or destination city name 
    ***************************************************************************/ 
    public static String getCityNameFromUser(Scanner kb, City [] cities){

       
        
        
        String currentCityName = "";
        boolean foundMatchForInput = false;
        String input = ""; // input string 
        

        
        
        do {
         // input n -- prompt & capture 
        
           
        input = kb.nextLine();
        
        if (input.compareTo("list cities") == 0){
        
        printCityList(cities);
        
        }
       
                for (int i = 0; i < cities.length; i++){
                
                
                currentCityName = cities[i].getName(); 
                  

              if (currentCityName != null){ // checking if currentCityName has a string value
                if(currentCityName.compareToIgnoreCase(input) == 0) {
                          System.out.println("***** Found Match ****");
                          foundMatchForInput = true; 
                          
                       }
              }
                                     
                } // close for loop
                
                if(foundMatchForInput == false) {

                        System.out.print(
                        "============================================================="
                        +"\nTry entering the city name again\n"
                                +" Type \"list cities\" for a list of city names"
           
                                + " You can \"type \\\":wq\\\" at anytime to quit program\n"
                                + "=> "); 

                }                        
            
          
        } while (input.compareTo(":wq") != 0 && foundMatchForInput == false);
        
        return input; 
        
    }
                
        
                           
                    
                
    
    
    
    
    /*************************************************************************** 
    * readCities() reads city data into an array from a data file.  The data   
    * file should be a CSV file with the city name and coordinates. City names 
    * should be unique. The coordinates are x and y coordinates for drawing on 
    * a 1500 by 900 JPanel  or JPanel. Each City will be a vertex in a graph of 
    * the cities. The array reference is a parameter. The methods returns the 
    * number of array elements used (the number of cities).                              
    ***************************************************************************/ 
    static int readCities(City[] cities) {

        int count = 0; // number of cities[] elements with data

        String[][] cityData = new String[123][3]; // holds data from the city file
        String delimiter = ",";                   // the delimiter in a csv file
        String line;                              // a String to hold each line from the file

        String fileName = "cities.csv";           // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile;
            infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there is another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();

                // split the line into separate objects and store them in a row in the array
                cityData[count] = line.split(delimiter);

                // read data from the 2D array into an array of City objects
                cities[count].setName(cityData[count][0]);
                cities[count].setX(Integer.parseInt(cityData[count][1]));
                cities[count].setY(Integer.parseInt(cityData[count][2]));

                count++;
            }// end while

            infile.close();

        } catch (FileNotFoundException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;

    } // end loadCities() ******************************************************


    
    /*************************************************************************** 
    * readLinks() reads link data into an array from a data file.  The data 
    * file should be a CSV file with source city name, destination city name, 
    * and length of the link on each line. The source and destination names 
    * should match names in the cities data file and array. 
    * The array reference is a parameter. The methods returns the number of 
    * array elements used (the number of links).
    ***************************************************************************/ 

    static int readLinks(Edge[] links, City[] cities) {
        int count = 0; // number of links[] elements with data

        String[][] CityLinkArray = new String[695][3]; // holds data from the link file
        String delimiter = ",";                       // the delimiter in a csv file
        String line;				      // a String to hold each line from the file

        String fileName = "links.csv";                // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();

                // split the line into separate objects and store them in a row in the array
                CityLinkArray[count] = line.split(delimiter);

                // read link data from the 2D array into an array of Edge objects
                // set source to vertex with city name in source column
                links[count].setSource(findCity(cities, CityLinkArray[count][0]));
                // set destination to vertex with city name in destination column
                links[count].setDestination(findCity(cities, CityLinkArray[count][1]));
                //set length to integer valuein length column
                links[count].setLength(Integer.parseInt(CityLinkArray[count][2]));

                count++;

            }// end while

        } catch (FileNotFoundException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    } // end loadLinks() *******************************************************

    /*************************************************************************** 
    * findCity() returns a reference to the City Object for the City with the 
    * specified name in the specified array .  City names should be unique 
    ***************************************************************************/ 
    static City findCity(City[] cities, String n) {
        int index = 0;  // loop counter
        // go through the cities array until the name is found
        // the name will be in the list

        while (cities[index].getName().compareTo(n) != 0) {

            index++;
        }// end while()
        return cities[index];

    } // end findCity() ********************************************************
    
    /*************************************************************************** 
    * Create AdjacencyLists() creates an adjacency list for each city. 
    * Each adjacency list is in alphabetical order.
    ***************************************************************************/ 
    static void createAdjacencyLists(int cityCount, City[] cities, int linkCount, Edge[] links) {

        AdjacencyNode temp = new AdjacencyNode();

        // iterate city array
        for (int i = 0; i < cityCount; i++) {

            /* Iterate the link array in reverse order.
               each new link will be placed at the head of the list
               resulting in a list in alphabetical order.*/
            for (int j = linkCount-1; j >= 0; j--) {
 
                /* if the currentl link's source is the current city, then
                   create a node for the link and inseert it into the 
                   adjancency list as the new head of the list. */
                if (links[j].getSource() == cities[i]) {

                    // temporarily store the current value of the list's head
                    temp = cities[i].getAdjacencyListHead();

                    //create a new node
                    AdjacencyNode newNode = new AdjacencyNode();
                    
                    // add city and distance data
                    newNode.setCity(links[j].getDestination());
                    newNode.setDistance(links[j].getLength());
                    
                    // point newNode to the previous list head
                    newNode.setNext(temp);

                    // set the new head of the list to newNode
                    cities[i].setAdjacencyListHead(newNode);

                }  // end if
            } // end for j  (iterate links)
        } // end for i (iterate cities)

    } // end createAdjacencyLists() ********************************************
    
    /*************************************************************************** 
    * PrintAdjacencyLists() print the adjacency list for each city. The set of  
    * lists is alphabetical, as is each list.
    ***************************************************************************/ 
static void PrintAdjacencyLists(int cityCount, City[] cities) {

        System.out.println("List of Edges in the Graph of Cities by Source City");
        // iterate array of cities
        for (int i = 0; i < cityCount; i++) {

            // set current to adjacency list for this city    
            AdjacencyNode current = cities[i].getAdjacencyListHead();

            // print city name
            System.out.println("\nFrom " + cities[i].getName());

            // iterate adjacency list and print each node's data
            while (current != null) {
                System.out.println("\t" + current.toString());
                current = current.getNext();
            } // end while (current != null) 

        }   // end for i 

    } // end PrintAdjacencyLists()**********************************************

    /*************************************************************************** 
    * DrawScrollableMap() creates a frame , then places
    * an instance of CityMap on the frame in a ScrollPane.
    ***************************************************************************/ 
    static void DrawScrollableMap(int cCount, City[] c, int lCount, Edge[] l)  {

        // create a frame for the map
        JFrame mapFrame = new JFrame();
       
        // set the frame's properties
        mapFrame.setTitle("Selected U.S. Cities");
        mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mapFrame.setLayout(new BorderLayout());
        mapFrame.setSize(1200, 600);
        
        // create an instance of CityMap
        CityMap map = new CityMap(cCount, c, lCount, l);
        
        // put the map on a ScrollPane in the frame
        mapFrame.add(new JScrollPane(map), BorderLayout.CENTER);
        // show the map
        mapFrame.setVisible(true);
        
    } // end DrawScrollablemap() ***********************************************
 
} // end class cityProject *****************************************************
