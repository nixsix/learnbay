package com.learnbay;

import java.util.Arrays;

public class RecursiveBubbleSort {
	
	public static void main(String... args) {
		int [] inArr = {10,3,5,2,9,8};
		int  si = 0; 
		int  li = inArr.length-1;
		bubbleSort(inArr,si,li);
		System.out.println(Arrays.asList(inArr));
	}

	public static int [] bubbleSort(int [] inArr, int  si, int  li) {
		if(li == 0) {
			return inArr;
		}
		if(si==li) {
			return bubbleSort(inArr, 0, li-1);
		}
		if(si+1 <= li && inArr[si]> inArr[si+1]) {
			swap(si, si+1, inArr);
		}
		bubbleSort(inArr, si+1, li );
		return inArr;
	}

	private static void swap(int  i, int  j, int [] inArr) {
		int  temp = inArr[i];
		inArr[i] = inArr[j];
		inArr[j] = temp;
	}
	
}
