package com.learnbay;

import static java.lang.System.out;

import java.util.Stack;
public class ValidateStackSequence {

	public static void main(String[] args) {
		int [] pushed = {1,2,3,4,5};
		int [] popped = {4,5,3,2,1};
		System.out.println(validateStackSequences(pushed, popped));
	}


	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if((pushed == null || popped == null)|| (pushed.length != popped.length)){
			return false;
		}   
		int popPointer = 0;
		Stack<Integer> s = new Stack<>();
		for(int i =0;i<pushed.length;i++){
			s.push(pushed[i]);
 			popPointer = checkPop(popped, popPointer, s);
		}
		
		if(!s.isEmpty()|| popPointer!= popped.length-1) {
			while(!s.isEmpty() && s.peek()==popped[popPointer]) {
				s.pop();
			}
		}
		if(s.isEmpty()){
			return true;
		}
		return false;
	}


	private static int checkPop(int[] popped, int popPointer, Stack<Integer> s) {
		while(!s.isEmpty() && popped[popPointer]==s.peek()){
			s.pop();
			popPointer++;
		}
 		return popPointer;
	}
}