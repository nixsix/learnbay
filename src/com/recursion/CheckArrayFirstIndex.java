package com.recursion;

public class CheckArrayFirstIndex {

	public static void main(String[] args) {
		
		int [] inputArray1 = {3,8,6,1,9,7,12};
		int [] inputArray2 = {1,2,3,4,5,5,7};
		System.out.println(firstIndex(inputArray1,0, 12));
		System.out.println(firstIndex(inputArray2,0, 12));
	}

	private static int firstIndex(int[] inputArray1, int pos, int data) {
		if(pos == inputArray1.length) {
			return -1;
		}
		if(inputArray1[pos]!=data) {
			return firstIndex(inputArray1, pos+1, data);
		}else {
			return pos;
		}
	}

}
