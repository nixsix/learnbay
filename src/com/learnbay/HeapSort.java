package com.learnbay;

public class HeapSort {

	static int A[] = {0,0,0,0,0,0,0};
	static int pointer = 0;
	public static void main(String[] args) {
		insert(15);insert(8);insert(7);insert(20);insert(32);
		
		for(int i =0;i<A.length;i++) {
			System.out.println(A[i]);
		}
	}
	private static void insert(int element) {
		A[pointer]= element;
		accomodateNewElement(pointer);
		pointer++;
	}
	private static void accomodateNewElement(int checkPointer) {
		int parent = (checkPointer -1)/2;
		while(parent>=0 && A[checkPointer] > A[parent]) {
			parent = (checkPointer-1)/2;
			swap(checkPointer, parent);
			checkPointer = parent;
			parent = (checkPointer-1)/2;
		}
			
	}
	private static void swap(int checkPointer, int parent) {
		int temp = A[checkPointer];
		A[checkPointer] = A[parent];
		A[parent] = temp;
	}

}
