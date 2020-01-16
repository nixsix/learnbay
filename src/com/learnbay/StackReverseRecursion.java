package com.learnbay;

import com.learnbay.ds.Stack;

public class StackReverseRecursion {

	public static void main(String[] args) throws Exception {
		Stack stack = new Stack(4);
		stack.push(23);
		stack.push(12);
		stack.push(8);
		stack.push(56);
		
		reverse(stack);
		System.out.println(stack);
		
	}

	private static void reverse(Stack stack) throws Exception{
		if(stack.isEmpty()) {
			return ;
		}
		
		int x = stack.pop();
		reverse(stack);
		pushAsFirstElement(stack, x);
		
	}

	private static void pushAsFirstElement(Stack stack, int x) throws Exception{
		
		if(stack.isEmpty()) {
			stack.push(x);
			return;
		}
		int element = stack.pop();
		pushAsFirstElement(stack,x);
		stack.push(element);
	}

}
