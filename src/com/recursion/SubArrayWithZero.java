package com.recursion;

public class SubArrayWithZero {

	public static void main(String[] args) {
		int [] inArr = {3,4,-7,1,5,3,-8,-2,5};
		boolean result = checkSubArrayWithZero(inArr);
		String s= "abcd";
		int pointer =2 ;
		String sw = s.substring(0, pointer) + s.substring(pointer+1);
		System.out.println(result);
	}

	private static boolean checkSubArrayWithZero(int[] inArr) {
		int len = inArr.length;

		for(int i =0; i<len; i++) {
			int sum = 0;
			for(int j=0;j<len-i;j++) {
				sum += inArr[j];
				if(sum==0) {
					return true;
				}
			}
		}
		return false;
	}
	
}
