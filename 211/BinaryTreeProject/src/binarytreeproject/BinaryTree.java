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

        root = null;

    }

    // constructor to initialize BinaryTree from array
    BinaryTree(int[] array) {

        for (int i = 0; i < array.length; i++) {
            
            int value = array[i];
            
            addNode(value);

        }

    }

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
                
             height++; // we either added a left or right child at this point so height increases by 1; 

            } //close while loop 

        } // close else statement to look at first root 

    } // close addNode method

}
