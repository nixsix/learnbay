package com.learnbay;

import com.learnbay.ds.Stack;

public class NextGreaterElementInArray {

	public static void main(String[] args) throws Exception {
		int inArr[] = {11, 13, 21, 3, 42, 5};
		nextGreaterElement(inArr);
	}

	private static void nextGreaterElement(int[] inArr) throws Exception {
		Stack s = new Stack(inArr.length);
		for(int i = 0,k=inArr.length;i<k;i++) {
			if(i==0) {
				s.push(inArr[i]);
				continue;
			}
			if(i == k-1) {
				System.out.println(inArr[i] + " --" + " -1");
				continue;
			}

			if(!s.isEmpty()&&inArr[i]> s.peek()) {
				checkAndPrintStackElements(s,inArr[i]);
				s.push(inArr[i]);
				continue;
			}
			if(inArr[i]< s.peek()) {
				s.push(inArr[i]);
			}
		}

		while(!s.isEmpty()) {
			System.out.println(s.pop()+ " -- " +  " -1");
		}
	}

	private static void checkAndPrintStackElements(Stack s, int element) throws Exception{
		while(!s.isEmpty() && s.peek()< element ) {
			System.out.println(s.pop() + " --" +element);
		}
	}
}


