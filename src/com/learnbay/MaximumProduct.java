package com.learnbay;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.UUID;

public class MaximumProduct {

	public static void main(String[] args) {
		int [] inArr = {-10, -3, 5, 6, -2};
		int maxVal = maxProduct(inArr);
		//System.out.println(maxVal);
		
		for(int i=0; i< 300;i++) {
			String x = UUID.randomUUID().toString().substring(0,7) +":"+ (new Long(System.nanoTime())).toString().substring(7) ;
			System.out.println(x);
		
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss Z yyyy");
	}

	private static int maxProduct(int[] inArr) {
		int max1 = -10000000;
		int max2 = -10000000;
		
		int min1 = 10000000;
		int min2 = 1000000;
		for(int i=0,k=inArr.length;i<k;i++) {
			if(inArr[i]> max1) {
				max1 = inArr[i];
			}
			else if(inArr[i]> max2){
				max2 = inArr[i];
			}
			if(inArr[i]<min1) {
				min1=inArr[i];
			}
			else if(inArr[i]<min2) {
				min2=inArr[i];
			}
		}
		int maxResult = max1*max2;
		int minResult = min1*min2;

		int result = maxResult>minResult?maxResult:minResult;
		return result;
	}

}
