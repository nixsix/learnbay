package com.recursion;

public class PrintN {
	public static void main(String... args) {
		PDISkip(89);
	}

	private static void print(int i) {
		if (i == 0) {
			return;
		}
		System.out.println(i);
		print(i-1);
		System.out.println(i);
	}

	private static void PDISkip(int i) {
		if (i == 0) {
			return;
		}
		if(i%2 == 1) {
			System.out.println(i);
		}
		PDISkip(i-1);
		if(i%2 == 0) {
			System.out.println(i);
		}
	}
}
