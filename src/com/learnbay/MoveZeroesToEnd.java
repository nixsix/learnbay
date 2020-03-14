package com.learnbay;

import static java.lang.System.out;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		int [] inArray = {12,0,3,5,0,6,0,0,21,0,56,23,0,23,0,22,0};
		//moveZeroesToEnd(inArray);
		//moveZeroesToEndPreservingOrder(inArray);
		pushZerosToEnd(inArray, inArray.length);
		for(int i=0,k=inArray.length;i<k;i++) {
			out.println(inArray[i]);
		}
	}

	private static void moveZeroesToEndPreservingOrder(int[] inArray) {
		for(int i=0,k=inArray.length;i<k;i++) {
			
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

	private static void pushZerosToEnd(int [] arr, int n) 
	{ 
		int count = 0;  // Count of non-zero elements 

		// Traverse the array. If element encountered is 
		// non-zero, then replace the element at index 'count' 
		// with this element 
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) { 
				arr[count] = arr[i];  
				count++; 
				System.out.println(arr[i] + " ");
			}
		}	
		// Now all non-zero elements have been shifted to 
		// front and 'count' is set as index of first 0. 
		// Make all elements 0 from count to end. 
		while (count < n) {
			arr[count++] = 0;
		}
	} 
}
