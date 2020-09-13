package com.learnbay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackSolutions {

	public static void main(String[] args) {
		int input []= {1,3,2,4}; 
		NGL(input);

	}

	private static void NGL(int[] a) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i =a.length-1;i>=0;i--) {
			// if stack is empty then no greater than found hence -1
			if(stack.isEmpty() ) {
				list.add(-1);				
			}else if(!stack.isEmpty() && stack.lastElement() > a[i]) {
				list.add(stack.lastElement());
			}else if(!stack.isEmpty() && stack.lastElement() <= a[i]) {
				while(!stack.isEmpty() && stack.lastElement() <= a[i]) {
					stack.pop();
				}
				if(stack.size()==0) {
					list.add(-1);
				}else {
					list.add(stack.lastElement());
				}
			}
			stack.push(a[i]);
		}
		Collections.reverse(list);
		System.out.println(list);
	}

}
