package com.greatLearning.main;

import java.util.Stack;

public class CheckBalancedString {
	
	public static boolean checkBracketsBalanced(String value) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int index = 0; index < value.length(); index++) {
			
			Character character = value.charAt(index);
			if(character.equals('(') || character.equals('{') || character.equals('[')) {
				stack.push(character);
				continue;
			}
			if(stack.isEmpty())
				return false;
			Character c;
			
			switch(character) {
			case ')':
				c = stack.pop();
				if(c.equals('{') || c.equals('['))
					return false;
				break;
			case '}':
				c = stack.pop();
				if(c.equals('(') || c.equals('['))
					return false;
				break;
			case ']':
				c = stack.pop();
				if(c.equals('{') || c.equals('('))
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		 System.out.println(checkBracketsBalanced("((()))"));
	}
}
