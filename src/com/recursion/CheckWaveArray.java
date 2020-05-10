package com.recursion;

public class CheckWaveArray {

	public static void main(String... args) {
		int [] inArr = {1,3,6,4,7,8,9,3,4,7,2,4};
		//i/p 1,3,6,4,7,8,9,3,4,7,2,4

		//o/p 1 3 6 3 7 8 9 3 4 7 2 4 

		boolean increasingInitially = inArr[0] < inArr[1];
		for(int i=1, k=inArr.length-1; i<k; i++) {

			if(increasingInitially ) {
				if(i%2 == 1 && inArr[i] > inArr[i+1]) {
					swap(inArr, i, i+1);
				}else if (i%2 == 0 && inArr[i] < inArr[i+1]){
					swap(inArr, i, i+1);
				}
			}else {
				if(i%2 == 0 && inArr[i] > inArr[i+1]) {
					swap(inArr, i, i+1);
				}else if (i%2 == 1 && inArr[i] < inArr[i+1]){
					swap(inArr, i, i+1);
				}
			}
		}
		
		for(int i=0;i<inArr.length;i++) {
			System.out.print(inArr[i]+",");
		}
	}

	private static void swap(int[] inArr, int i, int j) {
		int temp = inArr[i];
		inArr[i] = inArr[j];
		inArr[j] = temp;
	}
}
