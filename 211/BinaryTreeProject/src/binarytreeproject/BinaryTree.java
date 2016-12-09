/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreeproject;

/**
 *
 * @author AcriCAA
 */
public class BinaryTree {

    int height;
    int size; 

    Node root;

    // null constructor 
    BinaryTree() {

         
       

    }

    // constructor to initialize BinaryTree from array
    BinaryTree(int[] array) {
        
        int value;

        for (int i = 0; i < array.length; i++) {
            
            value = array[i];
            
            insert(value);

        }

    }

 
 
// insertNodes recursively
// reference: http://javabeat.net/binary-search-tree-traversal-java/
    
  public void insert(int value){
  
  Node newNode = new Node(value);
  
  if(root == null){
  
    root = newNode;
    size = 1; //created a root so size = 1; 
    height = 0; // height is zero at root; 
    return;
  
  }
      
  size++; 
  insertRec(root,newNode);
  
  
  }
  
// helper method for inserting Nodes recursively
private void insertRec(Node latestNode, Node node){

 
  
    if ( latestNode.value > node.value){

 

      if ( latestNode.leftChild == null ){
        
        latestNode.leftChild = node;
        height++; 
        return;

      }

      else{

        insertRec(latestNode.leftChild, node);
        
      }

    }

    else{

      if (latestNode.rightChild == null){
        
        latestNode.rightChild = node;
        
        return;

      }

      else{
        
        insertRec(latestNode.rightChild, node);
        
      }
      
    }
    
    
     

 


  }// close insertRec method



  
    
    
    
    // In order traversal     
   public void inOrderTraversal(Node focusNode){
       
    if (focusNode == null) return; 
    
    inOrderTraversal(focusNode.leftChild);
    
    System.out.println(focusNode);
    
    inOrderTraversal(focusNode.rightChild);
    
    
       
   } // close inOrderTraversal 
   
   
//preorder Traversal   
 public void preOrderTraversal(Node focusNode){
 
  if (focusNode == null) return; 
     System.out.println(focusNode); 
  preOrderTraversal(focusNode.leftChild);
  preOrderTraversal(focusNode.rightChild);

 }
 
public void postOrderTraversal(Node focusNode){

if (focusNode == null) return; 
    postOrderTraversal(focusNode.leftChild);
    postOrderTraversal(focusNode.rightChild);
    System.out.println(focusNode); 

}


public void searchTree(int searchValue){
    
    Node currentNode = root; 

    
    while(currentNode.value != searchValue){
        
         if(searchValue < currentNode.value){
         
             // look at the leftNode
             currentNode = currentNode.leftChild;
         
         } else {
             // look at the right child
             currentNode = currentNode.rightChild;
         
         }
         
         // if no match 
         if (currentNode == null){
             System.out.println("No match"); 
             break;
         }
        
    } // end while loop
    //make sure you have a node that is not null and then double check it matches the search value
    if(currentNode != null && currentNode.value == searchValue)
    System.out.println("FOUND: Node value of " + currentNode.value + " matches search value of " +
            searchValue); 
     
   
    
   
} // close searchTree
    



// find minimum value in tree; 
public int findMinimum(){
    if (root == null){

        return 0; 
    }
    Node currentNode = root; 
    
    while(currentNode.leftChild != null){

        currentNode = currentNode.leftChild; 
    }
return currentNode.value; 
}

// find maxium value in tree
public int findMaximum(){
    if (root == null){

        return 0; 
    }
    Node currentNode = root; 
    
    while(currentNode.rightChild != null){

        currentNode = currentNode.rightChild; 
    }
    return currentNode.value; 
}





// FOR TESTING (not used)    
//alternative  method for adding node non-recursively using while loop
// source: http://www.newthinktank.com/2013/03/binary-tree-in-java/
    public void addNode(int value) {

        // create new node 
        Node newNode = new Node(value);

        // check if there is a root, otherwise, make the new node the root
        if (root == null) {
            root = newNode;
            size = 1; //created a root so size = 1; 
            height = 0; // height is zero at root; 
        } else {
            // look at the root first as we traverse the tree
            Node focusNode = root;

            //create a placeholder for a parent Node; 
            Node parent;

            while (true) {

                parent = focusNode;

                // start with left side of node
                if (value < focusNode.value) {

                    //look at leftChild 
                    focusNode = focusNode.leftChild;

                    // if leftChild has no children 
                    if (focusNode == null) {

                        //make new node the leftChild 
                        parent.leftChild = newNode;
                        size++; //increase size by one because added leftChild node
                        return; // get out of loop

                    } // close checking for no leftChild if statement

                } // close look at left side of the node if statement 
                else {

                    // look for rightChild node     
                    focusNode = focusNode.rightChild;

                    //check if rightChild has children
                    if (focusNode == null) {

                        //make new node the rightChild
                        parent.rightChild = newNode;
                        size++; //increase size by one because added rightChild node
                        return; // get out of the loop
                    }
                  
                }
                
            

            } //close while loop 

        } // close else statement to look at first root 

    } // close addNode method   




} // close class
