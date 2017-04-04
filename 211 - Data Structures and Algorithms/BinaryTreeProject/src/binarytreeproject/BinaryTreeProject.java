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
public class BinaryTreeProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        //arbitrary array of integers to load into BinaryTree
       // int [] loadArray = {40, 4, 34, 45, 14, 55, 48, 13, 15, 49, 47,56,55,66,77};
        
//        int [] loadArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //char [] loadArray = {'A','B','C','D','E','F','G'};
        
        int [] loadArray = {7,1,0,3,2,5,4,6,9,8,10};
        
        System.out.println("Length of the array is " + loadArray.length);
        
        BinaryTree bt = new BinaryTree(loadArray);
        
        int size = bt.size; 
        int height = bt.height; 
        
        System.out.println("Size of the tree is " + size + "\nHeight of the tree is "
                + height); 
        System.out.println("In Order Traversal:"); 
        bt.inOrderTraversal(bt.root);
        System.out.println("PreOrder Traversal:"); 
        bt.preOrderTraversal(bt.root);
        System.out.println("PostOrder Traversal:"); 
        bt.postOrderTraversal(bt.root);
        
        
        System.out.println("Maximum Value:"); 
        int max = bt.findMaximum();
        System.out.println(max); 
        
        System.out.println("Minimum Value:"); 
        int min = bt.findMinimum();
        System.out.println(min); 
        
        int searchValue = 55; 
        System.out.println("Searching for " + searchValue); 
        bt.searchTree(searchValue);
        
        
    }
    
}
