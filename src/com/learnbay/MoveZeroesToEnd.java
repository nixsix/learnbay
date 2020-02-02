package com.learnbay;

import static java.lang.System.out;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		int [] inArray = {12,0,3,5,0,6,0,0,21,0,56,23,0,23,0,22,0};
		moveZeroesToEnd(inArray);
		for(int i=0,k=inArray.length;i<k;i++) {
			out.println(inArray[i]);
		}
	}

	private static void moveZeroesToEnd(int[] inArray) {
		int zerothPointer = inArray.length-1;
		for(int i=0,k=inArray.length;i<k;i++) {
			if(inArray[i]==0 && i<zerothPointer-1) {
				while(inArray[zerothPointer]==0  ) {
					zerothPointer--;
				}
				swap(i,zerothPointer,inArray);
			}
		}
	}

	private static void swap(int i, int zerothPointer, int[] inArray) {
		int temp = inArray[i];
		inArray[i] = inArray[zerothPointer];
		inArray[zerothPointer] = temp;
	}
}
