package com.learnbay;

import static java.lang.System.out;

import com.learnbay.ds.Stack;

public class NextGreaterElementInArray {

	public static void main(String[] args) throws Exception {
		int inArr[] = {11, 13, 21, 3, 42, 5};
		nextGreaterElement(inArr);
		int out[] = nextGreaterElementReverseArray(inArr);
		for(int i=0;i<out.length;i++) {
			//System.out.println(out[i]);
		}
	}

	private static int[] nextGreaterElementReverseArray(int[] inArr) {
		int out[] = new int[inArr.length];

		int nextGreaterElement = inArr[inArr.length-1];
		for(int i=inArr.length-1,k=0;i>k;i--){
			if(i==inArr.length-1){
				out[i] = inArr[i];
				nextGreaterElement = inArr[i];
				continue;
			}
			if(inArr[i]> nextGreaterElement){
				out[i]  = inArr[i];
			}else{
				if(i+1 < inArr.length-2 && inArr[i] < inArr[i+1])
				{
					if(inArr[i+1]> nextGreaterElement){
						nextGreaterElement = inArr[i];
					}	
				}
				out[i]=nextGreaterElement;
			}
		}
		return out;
	}

	private static void nextGreaterElement(int[] inArr) throws Exception {
		Stack s = new Stack(inArr.length);
		for(int i = 0,k=inArr.length;i<k;i++) {
			int element =inArr[i];
			if(i==0) {
				s.push(inArr[i]);
				continue;
			}
			while(!s.isEmpty() && s.peek()< element ) {
				out.println(s.pop() + " --" +element);
			}
			s.push(inArr[i]);
		}
		while(!s.isEmpty()) {
			out.println(s.pop()+ " -- " +  " -1");
		}
	}

	private static void checkAndPrintStackElements(Stack s, int element) throws Exception{
		while(!s.isEmpty() && s.peek()< element ) {
			out.println(s.pop() + " --" +element);
		}
	}
}