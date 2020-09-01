package com.learnbay;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = {10,30,50,70};
		int b[] = {20,40,60,80};
		int merge[] = mergeSortedArrays(a,b);
		
		int bigInput [] = {4,1,6,3,9,5,8,2,7,11};
		
		int mid = bigInput.length/2;
		int low = 0;
		int high =bigInput.length-1;
		
		int finalSortedArray[] = mergeSort(bigInput, low, high);
		for(int i=0;i<finalSortedArray.length;i++) {
			System.out.println(finalSortedArray[i]);
		}
	}

	private static int[] mergeSort(int[] input, int low, int high) {
		if(low==high) {
			int[] br = new int[1];
			br[0] = input[low];
			return br;
		}
		
		int mid = (low+high)/2;
		
		int left[]= mergeSort(input, low, mid);
		int right[] =mergeSort(input, mid+1, high);
		return mergeSortedArrays(left, right);
	}

	public static int [] mergeSortedArrays(int[] a, int b[]) {
		int [] merged = new int[a.length+b.length];
		int i=0;int j=0; int k = 0; 
		while(i<a.length && j<b.length) {
				if(a[i]<=b[j]) {
					merged[k++]=a[i++];
				}
				else {
					merged[k++]=b[j++];
				}
				if(i==a.length) { 
					while(j<b.length) {merged[k++]=b[j++];}
				}else  if(j==b.length){
					while(i<a.length) {merged[k++]=a[i++];}
				}
		}
		return merged;
	}
}
