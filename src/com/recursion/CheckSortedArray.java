package com.recursion;

public class CheckSortedArray {

	public static void main(String[] args) {
		int [] inputArray1 = {3,8,6,1,9,7};
		int [] inputArray2 = {1,2,3,4,5,5,7};
		System.out.println(isSorted(inputArray1,0));
		System.out.println(isSorted(inputArray2,0));
	}

	public static boolean isSorted(int[] arr, int pos) {
		if(pos == arr.length-1) {
			return true;
		}
		if(arr[pos] <= arr[pos +1]) {
			return isSorted(arr, pos+1);
		}else {
			return false;
		}
	}
	
}
