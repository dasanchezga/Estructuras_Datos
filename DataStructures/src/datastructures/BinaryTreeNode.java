/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author dlsan
 */
public class BinaryTreeNode<DataType>{
    DataType data;
    Integer height;
    BinaryTreeNode<DataType> leftSon;
    BinaryTreeNode<DataType> rightSon;
	
    public BinaryTreeNode(DataType data) {
	this.data = data;
	this.height = 0;
	this.leftSon = null;
	this.rightSon = null;
    }
}
