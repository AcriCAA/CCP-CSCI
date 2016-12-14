/* RouteMap.java  
 * The CityProject software package creates a graph of cities in the Unitied 
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
 *     1500 by 900 Canvas.
 *
 *   * Edge - an edge in a graph, with a source, destination, and length.
 *   
 *   * CityMap extends Canvas - a map of the graph on a 1500 by 900 GUI JPanel.
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
 * Modified 
 */

package cityproject;

import java.awt.*;
import javax.swing.*;

public class RouteMap extends JPanel {

    City[] cities = new City[200];  //array of cities (Vertices) max = 200
    int cityCount;                  // actual number of cities
    Edge[] links = new Edge[2000];  // array of links  (Edges)  max = 2000
    int linkCount;                  // avtual number of links

    RouteMap() {

    } // end CityCanvas(...)    

    RouteMap(int cCount, City[] c, int lCount, Edge[] l) {
    setPreferredSize(new Dimension(1500, 900));
        this.cities = c;
        this.cityCount = cCount;
        this.links = l;
        this.linkCount = lCount;
                
    } // end CityCanvas(...)    

    public void paint(Graphics graphics) {
        
        City immediatePredecessor = new City(); 
        City currentCity = new City(); 

        // fill background
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1500, 900);

        // place us image under map
        Image us = new ImageIcon("us.png").getImage();
        graphics.drawImage(us, 125, 0, null);

        // draw links
        // iterate link array
        String linkSourceName, linkDestinationName, currentCityName, nextCityName; 
       
           
        
        
        
           // COREY trying to draw only links that pertain to city 
           for(int j = 0; j < cities.length; j++){ // get a city
                 currentCityName = cities[j].getName();
               //find the corresponding link for the currentCity and the nextOne
             if(j+1 != cities.length){
             
               nextCityName = cities[j+1].getName(); 
                    for (int i = 0; i < linkCount; i++) {
                        
                        //get the link source and destination name
                        linkSourceName = links[i].getSource().getName(); 
                        linkDestinationName = links[i].getDestination().getName();
                        
                        //if the link source and destination match the city and next city assign the draw values
                           if((linkSourceName.compareToIgnoreCase(currentCityName) == 0) && 
                       (linkDestinationName.compareToIgnoreCase(nextCityName) == 0)){
                                    
            int xS = links[i].getSource().getX();       // x coordinate of source city
            int yS = links[i].getSource().getY();       // y coordinate of source city
            int xD = links[i].getDestination().getX();	// x coordinate of destination city
            int yD = links[i].getDestination().getY();  // y coordinate of destination city
                        
                  
               
               
           
           

            graphics.setColor(new Color(200, 200, 200));

            graphics.drawLine(xS, yS, xD, yD);
            
            } //end draw it if 
                       
            } // end link loop 
            
           } // end check for out of bounds exception loop
                
           } //end cities for loop
          
        

        // draw cities
        for (int i = 0; i < cityCount; i++) {
            //draw a dot for each city, 4 x 4 pixels
            graphics.setColor(Color.red);
            graphics.fillOval(cities[i].getX() - 3, cities[i].getY() - 3, 6, 6);

        } // end for

        // draw labels
        for (int i = 0; i < cityCount; i++) {
            // draw a label for each city, offest by 6 hor. and 9 ver. pixels
            graphics.setColor(Color.black);
            graphics.setFont(new Font("Lucida Console", Font.BOLD, 9));
            graphics.drawString(cities[i].getName(), cities[i].getX() + 6, cities[i].getY() + 9);
        } // end for

        // add note to the canvas
        Image logo = new ImageIcon("note.png").getImage();
        graphics.drawImage(logo, 35, 600, null);

    }  // end paint()

} // end class RouteMap
//**********************************************************************************************************************************
