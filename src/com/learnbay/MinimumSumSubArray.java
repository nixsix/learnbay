package com.learnbay;

public class MinimumSumSubArray {

	public static void main(String[] args) {

		int[] inArr = {10, 4, 3, 5 , 6, 1, 2 , 1};
		int k = 3;
		int[] minSum = minSumSubArray(inArr, k);
		for(int i = 0;i<k;i++) {
			System.out.print(minSum[i] + ",");
		}
	}

	private static int[] minSumSubArray(int[] inArr, int size) {
		int tempMinSum= inArr[0] + inArr[1] + inArr[2];
		int startIndexMinSum = 0; 
		for(int i = 0,k=inArr.length;i<k;i++){
			int currentSubArraySum = 0;
			if(i < k-size ) {
				currentSubArraySum = inArr[i] + inArr[i+1] + inArr[i+2];
			} 

			if(currentSubArraySum < tempMinSum) {
				tempMinSum = currentSubArraySum;
				startIndexMinSum = i;
			}
		}
		int [] outArr = new int[size];
		outArr[0] = inArr[startIndexMinSum];
		outArr[1] = inArr[startIndexMinSum+1];
		outArr[2] = inArr[startIndexMinSum+2];
		return outArr;
	}


}


