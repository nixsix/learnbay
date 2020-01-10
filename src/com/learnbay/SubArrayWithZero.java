package com.learnbay;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZero {

	public static void main(String[] args) {
		int [] inArr = {3, 6,9 ,-3,-7, 10, -4, 5, -3 ,1 ,-199};
		subArrayWithZero(inArr);
	}

	private static boolean subArrayWithZero(int[] inArr) {
		int sum = 0;
		boolean result = false;
		Map<Integer, Integer> intMap = new HashMap<>();
		for(int i =0;i<inArr.length-1; i++) {
			sum += inArr[i];
			System.out.println(sum);
			Integer output = intMap.put(sum, 0);
			if(output !=null) {
				result = true;
				break;
			}
		}
		System.out.println(result);
		return result;
	}

}
