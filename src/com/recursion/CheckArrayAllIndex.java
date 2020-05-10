package com.recursion;

import java.util.stream.IntStream;

public class CheckArrayAllIndex {

	public static void main(String[] args) {

		int [] inputArray1 = {3,8,6,1,9,7,12};
		int [] inputArray2 = {1,2,5,3,4,5,5,7,9,6,2,5,0};
		displayArr(allIndices(inputArray1,0, 12,0));
		displayArr(allIndices(inputArray2,0, 5,0));

	}

	private static void displayArr(int[] allIndices) {
		String result = "";
		for(int i =0;i< allIndices.length; i++) {
			System.out.print(allIndices[i]+",");
			result = String.join(",", ""+allIndices[i]);
		}
		System.out.println("\n");
	}

	private static int[] allIndices(int[] inputArray, int pos, int data, int count) {
		if(inputArray.length == pos) {
			return new int[count];
		}
		int [] resultIndices = null;
		if(inputArray[pos]==data) {
			resultIndices = allIndices(inputArray, pos+1, data, count+1);
		}else {
			resultIndices = allIndices(inputArray, pos+1, data, count);
		}
		if(inputArray[pos]==data) {
			resultIndices[count]=pos;
		}
		return resultIndices;
	}

}
