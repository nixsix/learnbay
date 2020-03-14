package com.learnbay;

import static java.lang.System.out;

public class ShortestSubArray {

	public static void main(String[] args) {
		int [] A = {17,85,93,-45,-21};
		int k = 150;
		out.println(shortestSubarray(A,k));
	}

	public static  int shortestSubarray(int[] A, int K) {
		int freshIndexStart=0;
		int freshIndexEnd=0;
		int sum =0;
		int prevBestEnd=Integer.MAX_VALUE;
		int prevBestStart=prevBestEnd/2;
		boolean foundAtleastOnce= false;
		int posEqualsSum = 0;
		for(int i=0,counter=A.length;i<counter;i++)
		{
			sum = sum + A[i];
			if(sum >= K ){
				foundAtleastOnce = true;
				freshIndexEnd =i;
				if(freshIndexEnd-freshIndexStart < prevBestEnd - prevBestStart){
					prevBestEnd = freshIndexEnd;
					prevBestStart = freshIndexStart;
					freshIndexStart=i;
					freshIndexEnd=0;
				}
				if(A[i]<K) {
					sum = A[i];
				} else if (A[i]==K){
					posEqualsSum = 1;
				} else {
					sum =0;
				}
			}
		}
		if(!foundAtleastOnce) {
			return -1;
		}
		if(posEqualsSum ==1) {
			return 1;
		}
		if(prevBestEnd==prevBestStart){
            if(prevBestStart==0 )
             return 1;
            else {
            	return prevBestStart;
            }
        }
		return (prevBestEnd - prevBestStart +1);
	}

}
