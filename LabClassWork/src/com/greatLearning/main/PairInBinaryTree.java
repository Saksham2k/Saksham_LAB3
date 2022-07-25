package com.greatLearning.main;

import java.util.HashSet;
import java.util.Set;

public class PairInBinaryTree {
	
	static class Node{
		private Node left;
		private Node right;
		private int data;
		
		Node(){
			left=right=null;
		}
	}
	
	public static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		return temp;
	}
	
	public static Node insert(Node root, int key) {
		if(root == null) {
			return newNode(key);
		}
		
		if(key < root.data) {
			root.left = insert(root.left,key);
		}
		else {
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	public static boolean findPair(Node root, int sum, Set set) {
		if(root == null)
			return false;
		else {
			boolean isPresent = findPair(root.left,sum,set);
			if(isPresent) {
				return isPresent;
			}
			
			if(set.contains(sum - root.data)) {
				System.out.println("Pais is ("+ (sum-root.data)+","+root.data+")");
				return true; 
			}
			else {
				set.add(root.data);
			}
			return findPair(root.right,sum,set);
		}
	}
	
	public static void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		boolean isPresent = findPair(root,sum,set);
		if(!isPresent) {
			System.out.println("Pair does not exist");
		}
	}
	
	public static void main(String[] args) {
		Node root = null;
		PairInBinaryTree pair = new PairInBinaryTree();
		root = pair.insert(root, 40);
		root = pair.insert(root, 20);
		root = pair.insert(root, 60);
		root = pair.insert(root, 10);
		root = pair.insert(root, 30);
		root = pair.insert(root, 50);
		root = pair.insert(root, 70);
		findPairWithGivenSum(root,75);
	}
}
