package com.learnbay;

import com.learnbay.ds.Stack;

public class StackSortRecursion {

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
		pushAsSortedElement(stack, x);
		
	}

	private static void pushAsSortedElement(Stack stack, int x) throws Exception{
		
		if(stack.isEmpty()||x> stack.peek()) {
			stack.push(x);
			return;
		}
		int element = stack.pop();
		pushAsSortedElement(stack,x);
		stack.push(element);
	}

}
