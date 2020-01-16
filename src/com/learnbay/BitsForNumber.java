package com.learnbay;

public class BitsForNumber {
	public static void main(String[] args) {
		int n = 31;
		int result = bitsForNumber(n);
		System.out.println(result);
	}

	private static int bitsForNumber(int n) {
		int result = 0;
		while(n!=0) {
			n = n/2;
			result++;
		}
		return result;
	}
}
