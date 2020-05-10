package com.recursion;

public class DuplicateArrayElement {

	public static void main(String[] args) {
		int[] inArr = {1,4,6,9,3,7,5,2,5};
		int[] dup = findDuplicate(inArr);
		
		for (int i = 0; i < dup.length; i++) {
			System.out.print(dup[i]+",");
		}
		System.out.println(dup  + "Final array");
		for (int i = 0; i < inArr.length; i++) {
			System.out.print(inArr[i]+",");
		}
	}

	private static int[] findDuplicate(int[] arr) {
		int [] result = new int[2];
		for(int i = 0,k =arr.length-1;i<k;i++) {
			int val = Math.abs(arr[i]);
			if(arr[val-1]<0) {
				result[0] = val;
			}
			arr[val-1] = arr[val]*-1;
		}
		return result;
	}

}
